package com.ll.exam.app_2022_09_23.app.base;

import com.ll.exam.app_2022_09_23.app.interceptor.BeforeActionInterceptor;
import com.ll.exam.app_2022_09_23.app.interceptor.NeedToLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final BeforeActionInterceptor beforeActionInterceptor;
    private final NeedToLoginInterceptor needToLoginInterceptor;


    // 인터셉터 적용
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir;

        ir = registry.addInterceptor(beforeActionInterceptor);
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/favicon.ico");
        ir.excludePathPatterns("/resource/**");
        ir.excludePathPatterns("/gen/**");
        ir.excludePathPatterns("/error");

        ir = registry.addInterceptor(needToLoginInterceptor);
        ir.addPathPatterns("/article/write");
        ir.addPathPatterns("/member/me");
    }
}
