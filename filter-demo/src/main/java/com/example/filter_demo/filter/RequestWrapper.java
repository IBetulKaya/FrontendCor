package com.example.filter_demo.filter;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.util.StreamUtils;

import java.io.IOException;

public class RequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    public RequestWrapper(HttpServletRequest request) throws IOException {

        super(request);

        // You can read the i nputstream only once
        this.body = StreamUtils.copyToByteArray(request.getInputStream());
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new ServletInputStreamWrapper(this.body);
    }
}