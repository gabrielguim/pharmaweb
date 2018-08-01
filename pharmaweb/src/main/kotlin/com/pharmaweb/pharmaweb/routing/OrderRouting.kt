package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Order
import com.pharmaweb.pharmaweb.model.Product
import com.pharmaweb.pharmaweb.service.OrderService
import com.pharmaweb.pharmaweb.service.ProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/orders")
@Api(value = "Order Endpoint", description = "Order CRUD operations")
class OrderRouting {

    @Autowired
    lateinit var orderService: OrderService

    @ApiOperation(value = "Returns all the registered orders")
    @GetMapping
    fun getAll() : List<Order> = orderService.getAll()

    @ApiOperation(value = "Registers a new given order")
    @PostMapping
    fun register(@Valid @RequestBody order: Order) = orderService.register(order)

    @ApiOperation(value = "Returns a single order that has the given id")
    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") orderId: Long) = orderService.findById(orderId)

    @ApiOperation(value = "Returns a list of orders that were made by the customer with the given id")
    @GetMapping("/customer/{customer_id}")
    fun findOrderByCustomer(@PathVariable(value = "customer_id") customerId: String) = orderService.findOrderByCustomer(customerId)

    @ApiOperation(value = "Alters a single order using the new given order that has the given id")
    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") orderId: Long,
              @Valid @RequestBody newOrder: Order) = orderService.alter(orderId, newOrder)

    @ApiOperation(value = "Deletes a single order that has the given id")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") orderId: Long) = orderService.delete(orderId)

}