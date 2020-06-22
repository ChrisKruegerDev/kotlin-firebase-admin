package firebase.admin.firestore

external interface Firestore {
    val app: dynamic //The app associated with this Firestore service instance
    fun batch(): WriteBatch //Creates a write batch, used for performing multiple writes as a single atomic operation
    fun collection(collectionPath: String): CollectionReference
}