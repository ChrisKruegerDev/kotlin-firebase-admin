package firebase.firestore

import js.jsObject
import kotlin.js.Promise


external interface DocumentReference {
    val firestore: Firestore
    val id: String
    val parent: CollectionReference
    val path: String
    fun collection(collectionPath: String): CollectionReference
    fun create(data: DocumentData): Promise<WriteResult>
    fun delete(precondition: Precondition = definedExternally): Promise<WriteResult>
    fun get(): Promise<DocumentSnapshot>
    fun getCollections(): Promise<Array<CollectionReference>>
    fun set(data: dynamic, options: SetOptions = definedExternally): Promise<WriteResult>

    /**
     * @param dataOrField - (UpdateData, string, or FieldPath)
     * An object containing the fields and values with which to update the document or the path of the first field to update.
     * @param preconditionOrValues - (any type, string, FieldPath, or Precondition)
     * An alternating list of field paths and values to update or a Precondition to restrict this update. Value may be repeated.
     *
     * @return A Promise that resolves once the data has been successfully written to the backend.
     */
    fun update(dataOrField: dynamic, preconditionOrValues: dynamic = definedExternally): Promise<dynamic>
    fun update(data: dynamic): Promise<Any?>
}

fun DocumentReference.setValues(vararg pairs: Pair<String, Any?>): Promise<WriteResult> {
    return set(jsObject(*pairs))
}
