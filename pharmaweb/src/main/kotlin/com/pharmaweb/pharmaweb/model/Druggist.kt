package com.pharmaweb.pharmaweb.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

@Entity(name = "druggist")
data class Druggist(

        @Id
        @get: NotBlank
        val uid: String  = "",

        @get: NotBlank
        val fullName: String  = "",

        @get: Email
        val email: String = "",

        @get: NotBlank
        val crf: String = "",

        val registrationToken: String = ""

) {
    private constructor() : this("", "", "", "", "")
}