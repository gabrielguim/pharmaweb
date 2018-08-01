package com.pharmaweb.pharmaweb.interceptor

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseToken
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class AppInterceptor: HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any) : Boolean {
        return if (request.headerNames.toList().contains("access-control-request-headers")) { // CORS
            true
        } else {
            val firebaseToken = request.getHeader("token")
            val uid = request.getHeader("uid")

            val authTask: FirebaseToken = FirebaseAuth.getInstance().verifyIdTokenAsync(firebaseToken, true).get()

            uid == authTask.uid
        }
    }
}
