package com.pharmaweb.pharmaweb.model

import javax.persistence.*

@Entity(name = "prescription")
data class Prescription(

        val date: String = "",

        var status: String = "",

        var imageUrl: String = "",

        @OneToOne
        val customer: Customer = Customer(),

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0

) {
        private constructor() : this("", "")
}