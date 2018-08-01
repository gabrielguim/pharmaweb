package com.pharmaweb.pharmaweb.service

import com.pharmaweb.pharmaweb.model.Customer
import com.pharmaweb.pharmaweb.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    private lateinit var repository: CustomerRepository

    fun getAll() = repository.findAll().toList()

    fun register(customer: Customer) = repository.save(customer)

    fun findById(customerId: String): ResponseEntity<Customer> {
        return repository.findById(customerId).map { customer ->
            ResponseEntity.ok(customer)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alter(customerId: String, newCustomer: Customer): ResponseEntity<Customer> {
        return repository.findById(customerId).map {
            val updatedCustomer: Customer = it.copy(fullName = newCustomer.fullName,
                                            email = newCustomer.email,
                                            address = if (newCustomer.address.isEmpty()) it.address else  newCustomer.address,
                                            phone = if (newCustomer.phone.isEmpty()) it.phone else  newCustomer.phone,
                                            registrationToken = if (newCustomer.registrationToken.isEmpty()) it.registrationToken else  newCustomer.registrationToken)

            ResponseEntity.ok().body(repository.save(updatedCustomer))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun delete(customerId: String): ResponseEntity<Void> {
        return repository.findById(customerId).map { customer  ->
            repository.delete(customer)

            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}