package com.kfirebase.admin.firestore

import com.kfirebase.admin.Admin

external interface GeoPoint {
    val admin: Admin
    fun build(latitude: Float, longitude: Float): dynamic
}