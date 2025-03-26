package me.hs.stocknotifier.common.auth

data class AuthRequest(
        val grant_type: String = "client_credentials", // fixed
        val appkey: String,
        val secretkey: String
)
