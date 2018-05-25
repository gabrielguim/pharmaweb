package com.pharmaweb.pharmaweb.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity
data class Druggist(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get: NotBlank
        val fullName: String  = "",

        @get: Email
        val email: String = "",

        @get: NotBlank
        val crf: String = ""

)