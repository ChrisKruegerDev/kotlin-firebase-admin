package com.kfirebase

import com.kfirebase.admin.Admin
import com.kfirebase.admin.Auth
import com.kfirebase.admin.database.Database
import com.kfirebase.admin.firestore.Firestore
import com.kfirebase.admin.firestore.FirestoreTrigger
import com.kfirebase.functions.Config
import com.kfirebase.functions.Https
import com.kjs.require

class FirebaseAppInstance : FirebaseApp {

    override val admin: Admin = require("firebase-admin").unsafeCast<Admin>()
    override val functions: dynamic = require("firebase-functions")
    override val config: Config = functions.config().unsafeCast<Config>()
    override val https: Https = functions.https.unsafeCast<Https>()
    override val database: Database get() = admin.asDynamic().database().unsafeCast<Database>()
    override val databaseTriggers = functions.database.unsafeCast<Database>()
    override val firestoreTrigger = functions.firestore.unsafeCast<FirestoreTrigger>()
    override val firestore: Firestore get() = admin.asDynamic().firestore().unsafeCast<Firestore>()
    override val auth: Auth get() = admin.asDynamic().auth().unsafeCast<Auth>()

}