package com.pharmaweb.pharmaweb.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity(name = "user")
data class User(

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

)