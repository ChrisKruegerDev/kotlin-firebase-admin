package firebase.firestore

external interface Firestore {
    /**
     * The app associated with this Firestore service instance
     */
    val app: dynamic

    /**
     * Creates a write batch, used for performing multiple writes as a single atomic operation
     */
    fun batch(): WriteBatch
    fun collection(collectionPath: String): CollectionReference
}