package me.hs.eventproducer.application

import me.hs.stocknotifier.common.auth.ApprovalKeyManager
import org.springframework.stereotype.Service

@Service
class StockSummaryService(
    private val approvalKeyManager: ApprovalKeyManager
) {

}
