package com.example.shopping.exception

/**
 * Generic exception class. Holds Error message and cause
 */
abstract class GenericException(
    message: String? = null,
    cause: Throwable? = null
) : Exception(message, cause)
