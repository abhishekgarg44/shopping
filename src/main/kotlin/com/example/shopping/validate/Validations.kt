package com.example.shopping.validate

import com.example.shopping.exception.ValidationException
import com.example.shopping.util.Constants
import org.springframework.stereotype.Component

@Component
class Validations {
    @Throws(ValidationException::class)
    fun validateWatchidList(watchIdList: List<Int>) {
        if (watchIdList == null || watchIdList.isEmpty()) {
            throw ValidationException(
                Constants.ValidationConstants.ID_LIST_EMPTY
            )
        }
    }
}
