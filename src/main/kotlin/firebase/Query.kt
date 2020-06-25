package firebase

import kotlin.js.Promise

external interface Query {
    val firestore: Firestore
    fun get(options: Any? = definedExternally): Promise<QuerySnapshot>
    fun where(fieldPath: Any, opStr: String, value: Any): Query
    fun orderBy(fieldPath: Any, directionStr: String?): Query
    fun limit(limit: Int): Query
    fun onSnapshot(next: (snapshot: QuerySnapshot) -> Unit, error: (error: Error) -> Unit): () -> Unit
}

fun Query.whereEqualTo(field: String, value: Any) = where(field, "==", value)
fun Query.whereGreaterThan(field: String, value: Any) = where(field, ">", value)
fun Query.whereLesserThan(field: String, value: Any) = where(field, "<", value)