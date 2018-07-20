package com.pharmaweb.pharmaweb.routing

import com.pharmaweb.pharmaweb.model.Customer
import com.pharmaweb.pharmaweb.service.CustomerService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customers")
@Api(value = "Customer Endpoint", description = "Customer CRUD operations")
class CustomerRouting {

    @Autowired
    lateinit var customerService: CustomerService

    @ApiOperation(value = "Returns all the registered customers")
    @GetMapping
    fun getAll() = customerService.getAll()

    @ApiOperation(value = "Registers a new given customer")
    @PostMapping
    fun register(@Valid @RequestBody customer: Customer) = customerService.register(customer)

    @ApiOperation(value = "Returns a single customer that has the given id")
    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") customerId: String) = customerService.findById(customerId)

    @ApiOperation(value = "Alters a single customer using the new given customer that has the given id")
    @PutMapping("/{id}")
    fun alter(@PathVariable(value = "id") customerId: String,
              @Valid @RequestBody newCustomer: Customer) = customerService.alter(customerId, newCustomer)

    @ApiOperation(value = "Deletes a single customer that has the given id")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") customerId: String) = customerService.delete(customerId)

}