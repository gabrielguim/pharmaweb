package com.pharmaweb.pharmaweb.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PositiveOrZero

@Entity(name = "product")
data class Product(

        @Id
        val code: String = "",

        @get: NotBlank
        val name: String  = "",

        @get: NotBlank
        val description: String  = "",

        @get: NotBlank
        val imageUrl: String  = "",

        @get: NotBlank
        val department: String = "",

        @get: NotBlank
        val category: String = "",

        @get: PositiveOrZero
        val price: Float = 0f

)