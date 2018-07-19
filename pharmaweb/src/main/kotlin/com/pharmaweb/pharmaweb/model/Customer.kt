package com.pharmaweb.pharmaweb.model

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity(name = "customer")
data class Customer(

        @Id
        @get: NotBlank
        val uid: String  = "",

        @get: NotBlank
        val fullName: String  = "",

        @get: Email
        val email: String = "",

        val registrationToken: String = "",

        val address: String = "",

        val phone: String = ""

) {
        private constructor() : this("", "", "")
}