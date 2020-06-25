package firebase

import kotlin.js.Promise

external interface DocumentReference {
    val firestore: Firestore
    val id: String
    val parent: CollectionReference
    val path: String
    fun collection(collectionPath: String): CollectionReference
    fun create(data: DocumentData): Promise<WriteResult>
    fun delete(precondition: Precondition = definedExternally): Promise<WriteResult>
    fun get(): Promise<DocumentSnapshot>
    fun getCollections(): Promise<Array<CollectionReference>>
    fun set(data: dynamic, options: SetOptions = definedExternally): Promise<WriteResult>
    fun update(dataOrField: dynamic, preconditionOrValues: dynamic = definedExternally): Promise<dynamic>
    fun update(data: dynamic): Promise<Any?>
}

fun DocumentReference.setValues(vararg pairs: Pair<String, Any?>): Promise<WriteResult> {
    return set(jsObject(pairs.asIterable()))
}

private fun jsObject(pairs: Iterable<Pair<Any, Any?>>): dynamic {
    val data: dynamic = js("({})")
    for ((name, value) in pairs) {
        data[name] = value
    }
    return data
}
