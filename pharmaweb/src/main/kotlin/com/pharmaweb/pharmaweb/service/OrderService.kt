package com.pharmaweb.pharmaweb.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.api.client.json.Json
import com.pharmaweb.pharmaweb.model.Order
import com.pharmaweb.pharmaweb.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification


@Service
class OrderService() {

    @Autowired
    lateinit private var repository: OrderRepository

    fun getAll() = repository.findAll().toList()

    @Transactional
    fun register(order: Order) {
        val mapper = jacksonObjectMapper()

        val message = Message.builder()
                .setNotification(Notification("Titulo", "Body"))
                .putData("order", mapper.writeValueAsString(order))
                .setToken(order.customer.registrationToken)
                .build()

        FirebaseMessaging.getInstance().send(message)

        FirebaseMessaging.getInstance().send(message)

        // send notification
        repository.save(order)
    }

    fun findById(orderId: Long): ResponseEntity<Order> {
        return repository.findById(orderId).map { product ->
            ResponseEntity.ok(product)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun findOrderByUser(userId: String) : ResponseEntity<Order> {
        val orders = getAll()
        for (order in orders) {
            if (order.customer.uid.equals(userId)) {
                return ResponseEntity.ok().body(order)
            }
        }

        return ResponseEntity.notFound().build()
    }

    fun alter(orderId: Long, newOrder: Order): ResponseEntity<Order> {
        return repository.findById(orderId).map {
            val updatedOrder: Order = it.copy(date = newOrder.date,
                                              customer = newOrder.customer,
                                              status = newOrder.status,
                                              products = newOrder.products)

            ResponseEntity.ok().body(repository.save(updatedOrder))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(orderId: Long): ResponseEntity<Void> {
        return repository.findById(orderId).map { product  ->
            repository.delete(product)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}