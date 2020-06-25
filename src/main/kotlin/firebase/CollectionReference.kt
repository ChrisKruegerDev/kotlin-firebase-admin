package firebase

import kotlin.js.Promise

external interface CollectionReference : Query {
    val id: String
    val parent: DocumentReference?
    val path: String
    fun doc(documentPath: String): DocumentReference
    fun add(data: dynamic): Promise<DocumentReference>
    fun isEqual(other: CollectionReference): Boolean
}

fun CollectionReference.addValues(vararg pairs: Pair<String, Any?>): Promise<DocumentReference> {
    val res: dynamic = js("({})")
    for ((name, value) in pairs) {
        res[name] = value
    }
    return add(res)
}
