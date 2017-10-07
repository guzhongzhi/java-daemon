package com.gulusoft.servlet.filter;

import com.gulusoft.util.QueryStringParser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.FilterConfig;

@WebFilter(
    filterName = "ParametersFilter",
    urlPatterns="/category/*",
    initParams={
        @WebInitParam(name= "encoding", value= "UTF-8")
    }
)
public class CharsetFilter implements Filter {
    public static String DEFAULT_ENCODING = "ISO8859-1";

    String encoding = "UTF-8";
    String defaultEncoding = "ISO8859-1";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行过滤初始化操作");
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行过滤操作");
        String requestEncoding = servletRequest.getCharacterEncoding();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HashMap<String,String> filteredQuery = new HashMap<>();
        System.out.println(((HttpServletRequest) servletRequest).getQueryString());
        System.out.println(request.getPathInfo());
        System.out.println(request.getContextPath());
        if(((HttpServletRequest) servletRequest).getQueryString() != "" && defaultEncoding.equals(requestEncoding) == false) {
            String queryString = ((HttpServletRequest) servletRequest).getQueryString();
            HashMap<String,String> queryParameters = QueryStringParser.parseStr(queryString);
            Iterator<String> names = queryParameters.keySet().iterator();
            while(names.hasNext()) {
                String name = names.next();
                String encodedValue = new String(queryParameters.get(name).getBytes(defaultEncoding),encoding);
                filteredQuery.put(name,encodedValue);
            }
        }
        request.setAttribute("FilteredQuery",filteredQuery);
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("DES");
    }
}

