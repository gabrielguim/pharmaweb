package com.pharmaweb.pharmaweb.interceptor

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConfiguration: WebMvcConfigurer {

    @Autowired
    lateinit var appInterceptor: AppInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(appInterceptor).addPathPatterns("/api/**");
    }

}