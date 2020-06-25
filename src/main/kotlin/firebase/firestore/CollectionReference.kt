package firebase.firestore

import kotlin.js.Promise

external interface CollectionReference : Query {
    val firestore: Firestore
    val id: String
    val parent: DocumentReference?
    fun add(data: dynamic): Promise<DocumentReference>
    fun doc(documentPath: String): DocumentReference
}

fun CollectionReference.addValues(vararg pairs: Pair<String, Any?>): Promise<DocumentReference> {
    val res: dynamic = js("({})")
    for ((name, value) in pairs) {
        res[name] = value
    }
    return add(res)
}
