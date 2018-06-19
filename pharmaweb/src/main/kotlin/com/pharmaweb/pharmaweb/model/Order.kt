package com.pharmaweb.pharmaweb.model

import javax.persistence.*

@Entity(name = "order")
data class Order(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @ManyToOne(optional = false)
        @JoinColumn(name = "customer", nullable = false, updatable = true)
        val customer: User = User(),

        val date: String = "",

        var status: String = "",

        @OneToMany(cascade = [CascadeType.ALL])
        @JoinColumn(name = "code_order")
        val products: List<Product>? = null

)