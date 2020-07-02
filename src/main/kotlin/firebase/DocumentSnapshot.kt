package firebase

external interface DocumentSnapshot {
    val exists: Boolean
    val ref: DocumentReference
    fun get(field: String): Any
    fun <T> data(): T
}

fun <T : Any> DocumentSnapshot.getValue(field: String) = get(field) as T