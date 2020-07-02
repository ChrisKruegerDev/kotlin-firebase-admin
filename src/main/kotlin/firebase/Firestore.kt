package firebase

external interface Firestore {
    fun collection(collectionPath: String): CollectionReference
}