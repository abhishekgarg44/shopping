package com.example.shopping.service

import com.example.shopping.models.CheckoutResponse
import org.springframework.stereotype.Component

@Component
class CheckoutService {
    fun checkout(idList: List<Int>) : CheckoutResponse {
        var response = CheckoutResponse()
        response.price = 5
        return response
    }
}
