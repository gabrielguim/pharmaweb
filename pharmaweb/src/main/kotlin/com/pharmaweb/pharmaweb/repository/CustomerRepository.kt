package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, String>
