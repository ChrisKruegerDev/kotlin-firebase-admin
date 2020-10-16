package firebase

import kotlin.js.Promise

external interface CollectionReference : Query {
    fun doc(): DocumentReference
    fun doc(documentPath: String): DocumentReference
    fun add(data: dynamic): Promise<DocumentReference>
}
