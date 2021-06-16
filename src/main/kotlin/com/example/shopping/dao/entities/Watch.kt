package com.example.shopping.dao.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "WATCH_CATALOGUE")
class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var watchId: Int? = null
    var watchName: String? = null
    var unitPrice: Int? = null
    var discount: String? = null
}
