package com.example.fileservice.infrastructure.presenter.rest.authentication.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.IpAddressMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class IpMatcher implements RequestMatcher {
    private final IpAddressMatcher ipAddressMatcher;
    public IpMatcher(String ip){
        this.ipAddressMatcher = new IpAddressMatcher(ip);
    }
    @Override
    public boolean matches(HttpServletRequest request) {
        return this.ipAddressMatcher.matches(request.getRemoteAddr());
    }
}
