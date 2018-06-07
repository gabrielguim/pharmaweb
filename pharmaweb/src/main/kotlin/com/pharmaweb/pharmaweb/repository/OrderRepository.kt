package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Order, Long>