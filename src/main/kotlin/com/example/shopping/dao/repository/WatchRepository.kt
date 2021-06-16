package com.example.shopping.dao.repository

import com.example.shopping.dao.entities.Watch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface WatchRepository : JpaRepository<Watch, Int> {
    @Query("select o from Watch o where watchId in :ids")
    fun findByWatchIds(@Param("ids") watchIdList: List<Int?>?): List<Watch?>?
}
