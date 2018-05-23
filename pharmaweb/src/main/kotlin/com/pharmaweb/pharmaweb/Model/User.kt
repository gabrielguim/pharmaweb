package com.pharmaweb.pharmaweb.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(@Id val id: Long,
                var email: String,
                var fullName: String)