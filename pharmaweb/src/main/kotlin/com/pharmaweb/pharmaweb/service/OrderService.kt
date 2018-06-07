package com.pharmaweb.pharmaweb.service

import com.pharmaweb.pharmaweb.model.Order
import com.pharmaweb.pharmaweb.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class OrderService() {

    @Autowired
    lateinit private var repository: OrderRepository

    fun getAll() = repository.findAll().toList()

    fun register(order: Order) = repository.save(order)

    fun findById(orderId: Long): ResponseEntity<Order> {
        return repository.findById(orderId).map { product ->
            ResponseEntity.ok(product)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alter(orderId: Long, newOrder: Order): ResponseEntity<Order> {
        return repository.findById(orderId).map {
            val updatedOrder: Order = it.copy(date = newOrder.date,
                                              customer_id = newOrder.customer_id,
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