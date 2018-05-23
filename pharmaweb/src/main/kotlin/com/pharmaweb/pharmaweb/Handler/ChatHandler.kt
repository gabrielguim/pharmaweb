package com.pharmaweb.pharmaweb.Handler

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.pharmaweb.pharmaweb.Model.Message
import org.springframework.web.socket.*
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.atomic.AtomicLong

class ChatHandler : TextWebSocketHandler() {

    /**
     * One user session to one druggist session
     * An user can only have one active session mapped,
     * otherwise druggists can have how many they want
     */
    val sessionList = HashMap<WebSocketSession, WebSocketSession>()
    var uids = AtomicLong(0)

    @Throws(Exception::class)
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessionList -= session
    }

    override fun handleTextMessage(session: WebSocketSession, data: TextMessage) {
        val mapper = jacksonObjectMapper()
        val message: Message = mapper.readValue(data.payload)
        sessionList.put(session, session)
        println(data.payload)
//        // {type: "join/say", data: "name/msg"}
//        when (json.get("type").asText()) {
//            "join" -> {
//                val user = User(uids.getAndIncrement(), json.get("data").asText())
//                sessionList.put(session, user)
//                // tell this user about all other users
//                emit(session, )
//                // tell all other users, about this user
//                broadcastToOthers(session, )
//            }
//            "say" -> {
//                broadcast(Message("say", json.get("data").asText()))
//            }
//        }
    }

    fun emit(session: WebSocketSession, msg: Message) = session.sendMessage(TextMessage(jacksonObjectMapper().writeValueAsString(msg)))
    fun broadcast(msg: Message) = sessionList.forEach { emit(it.key, msg) }
    fun broadcastToOthers(me: WebSocketSession, msg: Message) = sessionList.filterNot { it.key == me }.forEach { emit(it.key, msg) }
}