package firebase

external interface CollectionReference : Query {
    fun doc(documentPath: String): DocumentReference
}
