package me.hs.stocknotifier.common.auth

import me.hs.stocknotifier.adapter.client.StockApiClient
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.Instant

@Component
class ApprovalKeyManager(
    private val stockApiClient: StockApiClient,
    private val properties: AuthorizationProperties
){

    private var cachedKey: String? = null
    private var expirationTime: Instant? = null

    suspend fun getApprovalKey(): String? {
        if (cachedKey == null || Instant.now().isAfter(expirationTime)) {
            cachedKey = null
            expirationTime = null

            refreshKey();
        }
        return cachedKey
    }

    suspend fun refreshKey() {
        val request = AuthRequest(
            appkey = properties.appkey,
            secretkey = properties.secretkey
        )

        val response = stockApiClient.getApprovalKey(request)

        this.cachedKey = response.approval_key
        this.expirationTime = Instant.now().plus(Duration.ofHours(1))
    }


}