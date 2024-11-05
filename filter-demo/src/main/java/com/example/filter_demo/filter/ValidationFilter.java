package com.example.filter_demo.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
public class ValidationFilter extends OncePerRequestFilter {

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        RequestWrapper wrapper = new RequestWrapper( request);

        if ("POST".equalsIgnoreCase(wrapper.getMethod())) {
            byte[] bytes = StreamUtils.copyToByteArray(wrapper.getInputStream());
            String body = new String( bytes, "UTF-8");

            if( body != null){
                String urldecoded = java.net.URLDecoder.decode(body, StandardCharsets.UTF_8.name());
                checkInput( urldecoded);
            }
        }

        Enumeration<String> names = wrapper.getParameterNames();
        while( names.hasMoreElements()){
            String name = names.nextElement();
            checkInput( wrapper.getParameter( name));
        }

        filterChain.doFilter(wrapper,response);
    }

    private void checkInput(String input) throws ServletException {

        System.out.println( "Input:\n" + input);

        if( input.length() > 40){
            throw new ServletException("Parameter not safe: " + input);
        }

        List<String> blacklist = new ArrayList<>();
        blacklist.add("<");
        blacklist.add(">");
        blacklist.add("delete");
        blacklist.add("select");
        blacklist.add("insert");

        for( String s: blacklist){
            if( input.toLowerCase().contains(s.toLowerCase())){
                throw new ServletException("Parameter not safe: " + input);
            }
        }
    }
}
