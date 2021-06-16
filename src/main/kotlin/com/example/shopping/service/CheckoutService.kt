package com.example.shopping.service

import com.example.shopping.dao.entities.Watch
import com.example.shopping.dao.repository.WatchRepositoryWrapper
import com.example.shopping.models.CheckoutResponse
import org.springframework.stereotype.Component

@Component
class CheckoutService(private val watchRepositoryWrapper: WatchRepositoryWrapper) {
    fun checkout(requestWatchIdList: List<Int>): CheckoutResponse {

        var requestWatchIdMap: MutableMap<Int, Int> = mutableMapOf()

        var uniqueWatchIdList = mutableListOf<Int>()
        for (watchId in requestWatchIdList) {
            if (requestWatchIdMap.get(watchId) == null) {
                requestWatchIdMap.put(watchId, 1)
                uniqueWatchIdList.add(watchId)
            } else {
                requestWatchIdMap.put(watchId, requestWatchIdMap.get(watchId)!! + 1)
            }
        }

        var dbWatchList: List<Watch> = watchRepositoryWrapper.getByWatchIdlist(uniqueWatchIdList) as List<Watch>

        var dbWatchIdMap: MutableMap<Int, Watch> = mutableMapOf()

        for (watch in dbWatchList) {
            watch.watchId?.let { dbWatchIdMap.put(it, watch) }
        }

        var response = CheckoutResponse()
        response.price = 5
        return response
    }
}
