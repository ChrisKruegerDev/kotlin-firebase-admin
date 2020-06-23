package firebase.admin.firestore

import firebase.functions.EventContext

external interface DocumentBuilder {

    fun onWrite(handler: (change: Change<DocumentSnapshot>, context: EventContext) -> Unit)
    fun onUpdate(handler: (change: Change<DocumentSnapshot>, context: EventContext) -> Unit)

    fun onCreate(handler: (snapshot: DocumentSnapshot, context: EventContext) -> Unit)
    fun onDelete(handler: (snapshot: DocumentSnapshot, context: EventContext) -> Unit)

}