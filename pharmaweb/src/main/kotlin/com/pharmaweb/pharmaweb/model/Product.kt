package com.pharmaweb.pharmaweb.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
data class Product(

        @Id
        val code: String = "",

        @get: NotBlank
        val name: String  = "",

        @get: NotBlank
        val department: MutableList<String> = mutableListOf(),

        @get: NotBlank
        val category: String = "",

        @get: NotBlank
        val price: Float = 0f,

        @get: NotBlank
        val discount: Float = 0f

)