package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Order
import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.service.OrderService
import com.pharmaweb.pharmaweb.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/orders")
class OrderRouting {

    @Autowired
    lateinit var orderService: OrderService

    @GetMapping
    fun getAll() : List<Order> = orderService.getAll()

    @PostMapping
    fun register(@Valid @RequestBody order: Order) = orderService.register(order)

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") orderId: Long) = orderService.findById(orderId)

    @GetMapping("/{user_id}")
    fun findOrderByUser(@PathVariable(value = "user_id") userId: String) = orderService.findOrderByUser(userId)

    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") orderId: Long,
              @Valid @RequestBody newOrder: Order) = orderService.alter(orderId, newOrder)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") orderId: Long) = orderService.delete(orderId)

}