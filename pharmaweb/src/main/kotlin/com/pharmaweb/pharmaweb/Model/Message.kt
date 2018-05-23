package com.pharmaweb.pharmaweb.Model

class Message(val senderToken: String, val receiverToken: String,
              val userId: Long, val druggistId: Long,
              val text: String, val date: String)
