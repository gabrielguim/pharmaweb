package com.pharmaweb.pharmaweb.interceptor

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseToken
import org.slf4j.LoggerFactory
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AppInterceptor: HandlerInterceptor{

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any) : Boolean {
        val firebaseToken = request.getHeader("token")
        val uid = request.getHeader("uid")

        val authTask: FirebaseToken = FirebaseAuth.getInstance().verifyIdTokenAsync(firebaseToken, true).get()

        return uid == authTask.uid
    }

}
