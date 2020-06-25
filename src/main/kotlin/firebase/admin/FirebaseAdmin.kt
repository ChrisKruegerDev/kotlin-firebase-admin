package firebase.admin

import firebase.database.Database
import firebase.firestore.Firestore

/*
 * Build firebase admin:
 * fun admin(): FirebaseAdmin {
 *     val module: dynamic = require("firebase-admin")
 *     val admin = module.unsafeCast<Admin>()
 *
 *     return object : FirebaseAdmin {
 *
 *         override val firestore: Firestore get() = module.firestore().unsafeCast<Firestore>()
 *         override val auth: Auth get() = module.auth().unsafeCast<Auth>()
 *         override val database: Database get() = module.database().unsafeCast<Database>()
 *
 *         override fun initializeApp(config: dynamic): Admin = admin.initializeApp(config)
 *
 *     }
 * }
 */
external interface FirebaseAdmin {

    val firestore: Firestore
    val auth: Auth
    val database: Database

    fun initializeApp(config: dynamic): Admin

}
