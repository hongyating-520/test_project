package com.test.controller.other;

import com.test.listen.GlobalEventMulticaster;
import com.test.listen.ReloadEvent;
import com.test.listen.UpdateEvent;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;


/**
 * @author:zzq
 * @Date:2021/5/28-05-28
 */

@RestController
@RequestMapping("/vue")
//@Api(value = "/vue",tags = {"tags1"},description = "·api接口描述")
public class TestController {


    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    HttpServletResponse response;

    @Transactional
    @RequestMapping("/he")
//    @ApiOperation(value = "哈哈", notes = "哈接口", httpMethod = "POST")
//    @ApiResponses(value = {@ApiResponse(code = 100000, message = "成功")})
    public String gethh(@ApiParam(value = "参数RequestParam") @RequestBody ObjectParam objectParam) {

        return objectParam.getUsername();
    }

    @RequestMapping(value = "/redict")
    public ModelAndView redict(@RequestBody ObjectParam param) {
        System.out.println(param.getUsername());
        String tempDir = System.getProperty("java.io.tmpdir");
        System.out.println(tempDir);
        File file = new File(tempDir);
        //WebUtils.TEMP_DIR_CONTEXT_ATTRIBUTE
        System.out.println("==========1====");
        ReloadEvent reloadEvent = new ReloadEvent();
        reloadEvent.setKeys(new String[]{"sdf", "sv"});
        GlobalEventMulticaster.Publish(reloadEvent);
        GlobalEventMulticaster.publish(new UpdateEvent(), true);
        System.out.println("==========2====");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", "sucess");
        return modelAndView;
    }

    @RequestMapping("/font")
    public String getFont(String code) {
        ModelAndView view = new ModelAndView();
        System.out.println("getfont:" + code);
        view.addObject("font", "0.0.43");
        view.setViewName("font");
        Cookie cookie = new Cookie("test","6666");
        Cookie cookie1 = new Cookie("test","6666");
        cookie.setDomain("baidu.com");
        cookie.setMaxAge(60 * 60 * 24 );
        response.addCookie(cookie);
        return "view";
    }


    public static void main(String[] args) {
        String basePackage = "dsf@fdf@xxc";
        Assert.notNull(basePackage, "如果为null泡IllegalArgumentException异常");
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
