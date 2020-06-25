package firebase

import kotlin.js.Json
import kotlin.js.Promise

external interface Firestore {
    fun batch(): WriteBatch
    fun collection(collectionPath: String): CollectionReference
    fun doc(documentPath: String): DocumentReference
    fun settings(settings: Json)
    fun enablePersistence(): Promise<Unit>
}