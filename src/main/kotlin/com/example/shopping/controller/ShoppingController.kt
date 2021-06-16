package com.example.shopping.controller

import com.example.shopping.models.CheckoutResponse
import com.example.shopping.service.CheckoutService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("")
class ShoppingController(
    private val checkoutService: CheckoutService
) {
    @PostMapping(
        value = ["/checkout"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun checkout(@RequestBody idList: List<Int>): ResponseEntity<CheckoutResponse> {
        return ResponseEntity(checkoutService.getPriceAtCheckout(idList), HttpStatus.OK)
    }
}
