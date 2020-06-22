package com.kfirebase

import com.kfirebase.admin.Admin
import com.kfirebase.admin.Auth
import com.kfirebase.admin.database.Database
import com.kfirebase.admin.firestore.Firestore
import com.kfirebase.admin.firestore.FirestoreTrigger
import com.kfirebase.functions.Config
import com.kfirebase.functions.Https

external interface FirebaseApp {
    val admin: Admin
    val database: Database
    val firestore: Firestore
    val functions: dynamic
    val https: Https
    val config: Config
    val databaseTriggers: Database
    val firestoreTrigger: FirestoreTrigger
    val auth: Auth
}