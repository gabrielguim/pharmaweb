package com.pharmaweb.pharmaweb.interceptor

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class InterceptorConfiguration: WebMvcConfigurer {

    @Autowired
    lateinit var appInterceptor: AppInterceptor

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(appInterceptor).addPathPatterns("/api/**");
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
    }

}