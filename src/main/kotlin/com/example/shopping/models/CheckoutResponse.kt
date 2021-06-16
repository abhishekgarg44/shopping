package com.example.shopping.models

data class CheckoutResponse(
    var price: Int? = null,
    var errors: List<Error>? = null
)
