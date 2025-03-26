package me.hs.stocknotifier.common.auth

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "authorization")
@Component
class AuthorizationProperties (
        var appkey: String = "",
        var secretkey: String = ""
)