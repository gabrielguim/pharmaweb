package com.pharmaweb.pharmaweb.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get: NotBlank
        val fullName: String  = "",

        @get: NotBlank
        val email: String = "",

        @get: NotBlank
        val address: String = "",

        @get: NotBlank
        val phone: String = ""

)