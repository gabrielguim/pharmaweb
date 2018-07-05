package com.pharmaweb.pharmaweb.model

import javax.persistence.*

@Entity(name = "demand")
data class Order(

        val date: String = "",

        var status: String = "",

        @ManyToMany(
                cascade = [CascadeType.REFRESH, CascadeType.MERGE],
                fetch = FetchType.LAZY)
        @JoinTable(
                name = "ORDER_PRODUCTS",
                joinColumns = [JoinColumn(name = "ORDER_ID")],
                inverseJoinColumns = [JoinColumn(name = "PRODUCT_ID")])
        val products: List<Product> = listOf(),

        @OneToOne
        val customer: Customer = Customer(),

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0

) {
        private constructor() : this("", "")
}