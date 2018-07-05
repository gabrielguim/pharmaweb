package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<Order, Long>