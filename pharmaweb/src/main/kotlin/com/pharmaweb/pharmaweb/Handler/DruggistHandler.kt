package com.pharmaweb.pharmaweb.Handler

import com.pharmaweb.pharmaweb.Model.Druggist
import com.pharmaweb.pharmaweb.Repository.DruggistRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

@Component
class DruggistHandler(private val repository: DruggistRepository) {

    fun getAll(request: ServerRequest) = ok().body(repository.findAll())

    fun addDruggist(request: ServerRequest): Mono<ServerResponse> {
        val user = request.bodyToMono<Druggist>()
        return ok().body(repository.saveAll(user))
    }

}