package com.example.shopping.dao.repository

import com.example.shopping.dao.entities.Watch
import org.springframework.stereotype.Repository

@Repository
class WatchRepositoryWrapper(private val watchRepository: WatchRepository) {
    fun getByWatchIdlist(list: List<Int>): List<Watch?>? {
        return watchRepository.findByWatchIds(list)
    }
}
