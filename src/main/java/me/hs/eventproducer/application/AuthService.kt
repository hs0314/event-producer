package me.hs.eventproducer.application

import me.hs.eventproducer.common.AuthorizationProperties
import me.hs.eventproducer.common.StockApiClient
import me.hs.eventproducer.common.AuthRequest
import org.springframework.stereotype.Service

@Service
class AuthService(
        private val stockApiClient: StockApiClient,
        private val properties: AuthorizationProperties
) {

    suspend fun getApprovalKey(): String {
        val request = AuthRequest(
                appkey = properties.appkey,
                secretkey = properties.secretkey
        )

        val response = stockApiClient.getApprovalKey(request)
        return response.approval_key
    }
}
