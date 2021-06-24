package com.test.listen;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.*;
import java.util.LinkedHashSet;
import java.util.Set;

//@Component
public class GlobalEventMulticaster implements BeanPostProcessor {

    private static Set<MyListener<?>> LISTENER_SRT = new LinkedHashSet<>();

    public final static void publish(Event event,Boolean sync){
        if (event == null){
            return;
        }
        for (MyListener listener : getListenerByEvent(event)) {
            if (sync == true){
                listener.doEvent(event);
            }else {
                new Thread(()->{
                    listener.doEvent(event);
                }).start();
            }
        }
    }

    public final static void Publish(Event event){
        publish(event,false);
    }

    public void addListener(MyListener listener){
        LISTENER_SRT.add(listener) ;
    }

    private static Set<MyListener<?>> getListenerByEvent(Event event){
        Set<MyListener<?>> hashSet = new LinkedHashSet<>();
        try {
            if (!CollectionUtils.isEmpty(LISTENER_SRT)){
                Class<? extends Event> aClass = event.getClass();
                String typeName = aClass.getTypeName();
                if (typeName ==null){
                    return hashSet;
                }
                for (MyListener<?> listener : LISTENER_SRT) {
                    Type superclass = listener.getClass().getGenericSuperclass();
                    ParameterizedType p=(ParameterizedType)superclass;
                    Type[] allTType = p.getActualTypeArguments();
                    if (allTType ==null || allTType.length==0){
                        continue;
                    }
                    for (Type type : allTType) {
                        String name = type.getTypeName();
                        if (typeName.equals(name)){
                            hashSet.add(listener);
                        }
                    }
                }
            }
            return hashSet;
        }catch (Exception e){
            e.printStackTrace();
            return hashSet;
        }
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyListener){
            MyListener listener = (MyListener) bean;
            addListener(listener);
            System.out.println("loal Listener:"+beanName);
        }
        return bean;
    }
}
