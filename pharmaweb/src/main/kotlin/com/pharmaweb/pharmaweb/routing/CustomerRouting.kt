package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Customer
import com.pharmaweb.pharmaweb.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customers")
class CustomerRouting {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping
    fun getAll() = customerService.getAll()

    @PostMapping
    fun register(@Valid @RequestBody customer: Customer) = customerService.register(customer)

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") customerId: String) = customerService.findById(customerId)

    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") customerId: String,
              @Valid @RequestBody newCustomer: Customer) = customerService.alter(customerId, newCustomer)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") customerId: String) = customerService.delete(customerId)

}