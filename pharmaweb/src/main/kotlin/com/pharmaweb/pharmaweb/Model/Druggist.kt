package com.pharmaweb.pharmaweb.Model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Druggist(@Id val id: Long,
                    var crf: String,
                    var fullName: String)