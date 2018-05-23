package com.pharmaweb.pharmaweb

import com.pharmaweb.pharmaweb.Handler.ChatHandler
import com.pharmaweb.pharmaweb.Handler.DruggistHandler
import com.pharmaweb.pharmaweb.Handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class RoutingConfiguration: WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        // Chat Handler
        registry.addHandler(ChatHandler(), "/api/chat").withSockJS()
    }

    @Bean
    fun userRouter(handler: UserHandler): RouterFunction<ServerResponse> = router {
        ("/api/user" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/", handler::getAll)
            POST("/", handler::addUser)
        }
    }

    @Bean
    fun druggistRouter(handler: DruggistHandler): RouterFunction<ServerResponse> = router {
        ("/api/druggist" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/", handler::getAll)
            POST("/", handler::addDruggist)
        }
    }
}