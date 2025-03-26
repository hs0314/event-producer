package me.hs.stocknotifier.adapter.client

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import kotlinx.coroutines.reactor.awaitSingle
import me.hs.stocknotifier.common.auth.AuthRequest
import me.hs.stocknotifier.common.auth.AuthResponse

@Component
class StockApiClient(
        private val webClient: WebClient
) {

    suspend fun getApprovalKey(request: AuthRequest): AuthResponse {
        return webClient.post()
                .uri("/oauth2/Approval")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(AuthResponse::class.java)
                .awaitSingle() // reactor의 Mono를 Kotlin 코루틴 suspend로 변환
    }
}