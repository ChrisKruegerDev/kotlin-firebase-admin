package firebase

import kotlin.js.Promise

external interface Query {
    fun get(): Promise<QuerySnapshot>
    fun where(fieldPath: Any, opStr: String, value: Any): Query
    fun orderBy(fieldPath: Any, directionStr: String?): Query
    fun limit(limit: Int): Query
}

object QueryDirection {
    const val DESCENDING = "desc"
    const val ASCENDING = "asc"
}


fun Query.whereEqualTo(field: String, value: Any): Query = where(field, "==", value)
fun Query.whereGreaterThan(field: String, value: Any): Query = where(field, ">", value)
fun Query.whereLesserThan(field: String, value: Any): Query = where(field, "<", value)