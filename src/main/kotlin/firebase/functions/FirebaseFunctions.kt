package firebase.functions

import firebase.admin.AuthTrigger
import firebase.database.Database
import firebase.firestore.FirestoreTrigger

/*
 * Build firebase functions:
 * fun functions(): FirebaseFunctions {
 *     val module: dynamic = require("firebase-functions")
 *
 *     return object : FirebaseFunctions {
 *         override val config: Config get() = module.config().unsafeCast<Config>()
 *         override val https: Https get() = module.https.unsafeCast<Https>()
 *         override val database get() = module.database.unsafeCast<Database>()
 *         override val firestore get() = module.firestore.unsafeCast<FirestoreTrigger>()
 *         override val auth: AuthTrigger get() = module.auth.unsafeCast<AuthTrigger>()
 *     }
 * }
 */
external interface FirebaseFunctions {
    val config: Config
    val https: Https
    val database: Database
    val firestore: FirestoreTrigger
    val auth: AuthTrigger
}
