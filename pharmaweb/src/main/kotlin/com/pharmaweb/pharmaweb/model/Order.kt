package com.pharmaweb.pharmaweb.model

import javax.persistence.*

@Entity(name = "orders")
data class Order(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        val customer_id: Long = 0,

        val date: String = "",

        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn(name = "code_order")
        val products: List<Product>? = null

)