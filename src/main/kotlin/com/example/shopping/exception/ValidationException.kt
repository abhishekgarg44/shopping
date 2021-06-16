package com.example.shopping.exception

class ValidationException(message: String? = null, cause: Throwable? = null) :
    GenericException(message, cause)
