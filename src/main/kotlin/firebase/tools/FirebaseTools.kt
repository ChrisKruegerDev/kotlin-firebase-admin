package firebase.tools

import js.require

typealias FirestoreDelete = (path: String, options: dynamic) -> Unit

class FirebaseTools {

    private val module: dynamic = require("firebase-tools")

    val delete: FirestoreDelete = module.firestore.delete.unsafeCast<FirestoreDelete>()

}