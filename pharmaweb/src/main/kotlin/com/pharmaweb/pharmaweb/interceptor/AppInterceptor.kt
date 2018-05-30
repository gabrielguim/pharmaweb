package com.pharmaweb.pharmaweb.interceptor

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView

@Component
class AppInterceptor: HandlerInterceptor{

    val log = LoggerFactory.getLogger(AppInterceptor::class.java);

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any) : Boolean {
        log.info("1. from PreHandle method." + request)
        return true
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any, model: ModelAndView?) {
        log.info("3. from PostHandle method.")
    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any, e: Exception?) {
        log.info("4. from AfterCompletion method - Request Completed!")
    }
}