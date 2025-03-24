package me.hs.eventproducer.common

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix = "authorization")
@Component
class AuthorizationProperties (
        var appkey: String = "",
        var secretkey: String = ""
)