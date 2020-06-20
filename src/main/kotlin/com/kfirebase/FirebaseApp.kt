package com.kfirebase

import com.kfirebase.admin.Admin
import com.kfirebase.admin.firestore.Firestore
import com.kfirebase.functions.Config
import com.kfirebase.functions.Https

external interface FirebaseApp {
    val admin: Admin
    val firestore: Firestore
    val functions: dynamic
    val https: Https
    val config: Config
}