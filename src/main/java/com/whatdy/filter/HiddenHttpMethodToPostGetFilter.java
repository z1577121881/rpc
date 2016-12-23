package com.whatdy.filter;

import com.sun.net.httpserver.HttpExchange;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Proxy;
import java.util.Locale;

/**
 * 由于在Tomcat 1.8中使用 HiddenHttpMethodFilter  进行装饰之后的 request,和response 会出现不被允许的情况,所以我们在到达
 * 客户端之前进行了拦截,将原来的请求转化为POST,GET方式.
 */
public class HiddenHttpMethodToPostGetFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String method = request.getMethod().toUpperCase();
        HttpMethodRequestWrapper wrapper = null;
        if (method.equals("POST")) {
            wrapper = new HttpMethodRequestWrapper(request, method);

        } else if (method.equals("GET")) {
            wrapper = new HttpMethodRequestWrapper(request, method);

        } else {
            wrapper = new HttpMethodRequestWrapper(request, "GET");
        }
        filterChain.doFilter(wrapper, response);
    }

    public void destroy() {

    }
    private static class HttpMethodRequestWrapper extends HttpServletRequestWrapper {
        private final String method;

        public HttpMethodRequestWrapper(HttpServletRequest request, String method) {
            super(request);
            this.method = method;
        }

        public String getMethod() {
            return this.method;
        }
    }
}
