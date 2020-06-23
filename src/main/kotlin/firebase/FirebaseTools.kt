package firebase

import js.require

typealias FirestoreDelete = (path: String, options: dynamic) -> Unit

class FirebaseTools {
    private val firebaseTools: dynamic = require("firebase-tools")

    val delete: FirestoreDelete = firebaseTools.firestore.delete.unsafeCast<FirestoreDelete>()
}