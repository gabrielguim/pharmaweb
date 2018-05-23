package com.pharmaweb.pharmaweb.Handler

import com.pharmaweb.pharmaweb.Model.User
import com.pharmaweb.pharmaweb.Repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class UserHandler(private val repository: UserRepository) {

    fun getAll(request: ServerRequest) = ok().body(repository.findAll())

    fun addUser(request: ServerRequest): Mono<ServerResponse> {
        val user = request.bodyToMono<User>()
        return ok().body(repository.saveAll(user))
    }

}