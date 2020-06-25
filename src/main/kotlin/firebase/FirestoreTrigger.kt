package firebase

import firebase.DocumentBuilder

external interface FirestoreTrigger {

    /**
     * Select the Firestore document to listen to for events.
     * @param path Full database path to listen to. This includes the name of
     * the collection that the document is a part of. For example, if the
     * collection is named "users" and the document is named "Ada", then the
     * path is "/users/Ada".
     */
    fun document(path: String): DocumentBuilder

}