package com.kfirebase

import com.kfirebase.admin.Admin
import com.kfirebase.admin.firestore.Firestore
import com.kfirebase.functions.Config
import com.kfirebase.functions.Https

class FirebaseAppInstance : FirebaseApp {

    override val admin: Admin = require("firebase-admin").unsafeCast<Admin>()
    override val functions: dynamic = require("firebase-functions")
    override val https: Https = functions.https.unsafeCast<Https>()
    override val config: Config = functions.config().unsafeCast<Config>()
    override val firestore: Firestore get() =  admin.asDynamic().firestore().unsafeCast<Firestore>()

}