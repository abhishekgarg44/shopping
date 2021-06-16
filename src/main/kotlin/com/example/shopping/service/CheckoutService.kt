package com.example.shopping.service

import com.example.shopping.dao.entities.Watch
import com.example.shopping.dao.repository.WatchRepositoryWrapper
import com.example.shopping.models.CheckoutResponse
import org.springframework.stereotype.Component

@Component
class CheckoutService(private val watchRepositoryWrapper: WatchRepositoryWrapper) {
    fun getPriceAtCheckout(requestWatchIdList: List<Int>): CheckoutResponse {

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

        var totalPrice = 0
        for ((watchId, count) in requestWatchIdMap) {

            if (dbWatchIdMap.get(watchId) != null) {
                totalPrice = totalPrice + getprice(dbWatchIdMap.get(watchId)!!, count)
            }
        }

        var response = CheckoutResponse()
        response.price = totalPrice
        return response
    }

    fun getprice(watch: Watch, count: Int): Int {

        var count = count
        var price = 0

        if (watch.discount != null && !watch.discount!!.isEmpty()) {
            var discount_count: Int = getDiscountCount(watch.discount)
            var discount_price: Int = getDiscountPrice(watch.discount)
            price = price + (count/discount_count * discount_price)
            count = count.mod(discount_count)
        }

        if (count != 0) {
            price = price + (watch.unitPrice?.times(count)!!)
        }
        return price
    }

    private fun getDiscountPrice(discount: String?): Int {
        var arr: Array<String> = discount!!.split(" ").toTypedArray()
        return arr[2].toInt()
    }

    private fun getDiscountCount(discount: String?): Int {
        var arr: Array<String> = discount!!.split(" ").toTypedArray()
        return arr[0].toInt()
    }
}
