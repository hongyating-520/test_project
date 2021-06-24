package com.test.model;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/*
 * @author ZZQ
 * @Date 2021/6/21 5:19 下午
 */
public class ModelMain {

    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration(freemarker.template.Configuration.VERSION_2_3_23);

/// 设置放置模板的页面路径,此处我在resources目录下新建了文件夹templates,所有模板文件都放在此目录下
           ClassPathResource classPathResource = new ClassPathResource("templates");
            configuration.setDirectoryForTemplateLoading(new File("/templates/font2.ftl"));
            configuration.setDefaultEncoding("utf-8");
            Template template = configuration.getTemplate("freemark/html.ftl");
            Map<String, String> map = new HashMap<>();
            map.put("font","0.0.43");
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template,map);
            System.out.println(content);
        }catch (Exception e){
        e.printStackTrace();}
    }
}
