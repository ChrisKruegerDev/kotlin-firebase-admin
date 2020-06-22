package firebase.admin.firestore

import kotlin.js.Promise

external interface Query {
    fun get(): Promise<QuerySnapshot>
    fun where(fieldPath: String, opStr: String, value: Any): Query
}

fun Query.whereEqualTo(field: String, value: Any) = where(field, "==", value)