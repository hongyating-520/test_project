package com.test.controller;

import com.test.empServer.EmpServiceImple;
import com.test.empServer.UserServiceImple;
import com.test.listen.GlobalEventMulticaster;
import com.test.listen.ReloadEvent;
import com.test.listen.UpdateEvent;
import com.test.server.Emp;
import com.test.server.Users;
import io.swagger.annotations.*;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * @author:zzq
 * @Date:2021/5/28-05-28
 */

@RestController
@RequestMapping("/vue")
@Api(value = "/vue",tags = {"tags1"},description = "·api接口描述")
public class TestController {

    @Autowired
    UserServiceImple userServiceImple;
    @Autowired
    EmpServiceImple empServiceImple;

    @Transactional
    @RequestMapping("/ha")
    @ApiOperation(value = "哈哈", notes = "哈接口", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 100000, message = "成功")})
    public String gethh(@ApiParam(value = "参数RequestParam") @RequestBody RequestParam requestParam){
        System.out.println(requestParam.getUsername()+"-"+requestParam.getPasswor());
        int i = new Random().nextInt(100)+100;
        System.out.println("random:"+i);
        Users jom = new Users().setUsername("jom").setPassword(String.valueOf(i)).setEnabled(true);
        userServiceImple.updateByPKey(jom);
        System.out.println("======1=======");
        Emp emp = new Emp();

        emp.setEname("tom");
        emp.setJob(String.valueOf(i));
        emp.setMgr(new Date());
        emp.setSal(new BigDecimal(new BigInteger(String.valueOf(i)), 2));
        empServiceImple.updateInfo(emp,jom);
        return requestParam.getUsername();
    }
    @RequestMapping("/he")
//    @ApiOperation(value = "呵呵", notes = "呵呵接口", httpMethod = "POST")
//    @ApiResponses(value = {@ApiResponse(code = 100, message = "失败")})
    public String getInterceptor(){
        System.out.println("redisdfsdfdsf");
        return "sucess";
    }

//    public static void main(String[] args) throws Throwable{
//        System.out.println("wqe");
//        List<String> warnings = new ArrayList<String>();
//        boolean overwrite = true;
//        File configFile = new File("/Users/mima0000/java_project/test_project/vue-web1/target/classes/generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(configFile);
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//        myBatisGenerator.generate(null);
//    }
    @RequestMapping(value = "/redict" )
    public ModelAndView redict(){
        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println(tempDir);
        File file = new File(tempDir);
        //WebUtils.TEMP_DIR_CONTEXT_ATTRIBUTE


        System.out.println("==========1====");
        ReloadEvent reloadEvent = new ReloadEvent();
        reloadEvent.setKeys(new String[]{"sdf","sv"});
        GlobalEventMulticaster.Publish(reloadEvent);
        GlobalEventMulticaster.publish(new UpdateEvent(),true);
        System.out.println("==========2====");
        return new ModelAndView("redirect:/vue/he");
    }

    public static void main(String[] args) {
        String basePackage = "dsf@fdf@xxc";
        Assert.notNull(basePackage,"如果为null泡IllegalArgumentException异常");
        //StrigUtils中拆分工具
        String[] strings = StringUtils.tokenizeToStringArray(basePackage,
                "@");
        //通过classloader扫描路径所有.class文件：classpath*:com/test/controller/**/*.class
        System.out.println(determineRootDir("com/test/controller/**/*.class"));

    }

    protected static String determineRootDir(String location) {
        AntPathMatcher matcher = new AntPathMatcher();
        int prefixEnd = location.indexOf(":") + 1;
        int rootDirEnd = location.length();
        while (rootDirEnd > prefixEnd && matcher.isPattern(location.substring(prefixEnd, rootDirEnd))) {
            rootDirEnd = location.lastIndexOf('/', rootDirEnd - 2) + 1;
        }
        if (rootDirEnd == 0) {
            rootDirEnd = prefixEnd;
        }
        return location.substring(0, rootDirEnd);
    }
   
}
