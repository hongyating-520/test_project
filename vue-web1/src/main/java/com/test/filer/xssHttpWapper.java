package com.test.filer;

import com.oracle.tools.packager.IOUtils;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.function.Function;

/*
 * @author ZZQ
 * @Date 2021/6/17 11:23 上午
 */
public class xssHttpWapper extends HttpServletRequestWrapper {
     private InputStream inputStream;
    private HttpServletRequest request;
    private Map<String, String[]> map;
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public xssHttpWapper(HttpServletRequest request) {
        super(request);
        map = request.getParameterMap();
        this.request=request;
    }

    @Override
    public String getParameter(String name) {
        System.out.println("xss:getParameter");

        return super.getParameter(name);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        inputStream.mark(123);
        read(inputStream);
        System.out.println("2"+inputStream.read());
        inputStream.reset();
        System.out.println("3"+inputStream.read());
        read(inputStream);
        return inputStream;
    }

    public void read(InputStream inputStream){
        try {
            byte[] bytes = new byte[1024 * 1024];
            int nRead = 1;
            int nTotalRead = 0;
            while (nRead > 0) {
                nRead = inputStream.read(bytes, nTotalRead, bytes.length - nTotalRead);
                if (nRead > 0)
                    nTotalRead = nTotalRead + nRead;
            }
            String str = new String(bytes, 0, nTotalRead, "utf-8");
            System.out.println(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        System.out.println("xss:getParameterMap");

        return super.getParameterMap();
    }

    @Override
    public Enumeration<String> getParameterNames() {
        System.out.println("getParameterNames");

        return super.getParameterNames();
    }

    @Override
    public String[] getParameterValues(String name) {
        System.out.println("getParameterValues");
        return super.getParameterValues(name);
    }



}
/*springboot通过拦截器获取参数有两种方式，
        一种通过request.getParameter获取Get方式传递的参数，
        另外一种是通过request.getInputStream或reques.getReader获取通过POST/PUT/DELETE/PATCH传递的参数；

@PathVariable注解是REST风格url获取参数的方式，只能用在GET请求类型，通过getParameter获取参数
@RequestParam注解支持GET和POST/PUT/DELETE/PATCH方式，Get方式通过getParameter获取参数和post方式通过getInputStream或getReader获取参数
@RequestBody注解支持POST/PUT/DELETE/PATCH，可以通过getInputStream和getReader获取参数
HttpServletRequest参数可以通过getParameter和getInputStream或getReader获取参数


*/
