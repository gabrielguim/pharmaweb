package com.pharmaweb.pharmaweb.repository

import com.pharmaweb.pharmaweb.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, String>
