package com.pharmaweb.pharmaweb.model

import javax.persistence.*

@Entity(name = "demand")
data class Order(

        val date: String = "",

        var status: String = "",

        @OneToMany(
            cascade = [CascadeType.ALL],
            orphanRemoval = true
        )
        val products: List<Product> = listOf(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="customer_id")
        val customer: Customer = Customer(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0

) {
        private constructor() : this("", "")
}