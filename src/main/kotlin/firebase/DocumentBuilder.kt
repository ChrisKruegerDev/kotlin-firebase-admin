package firebase

external interface DocumentBuilder {

    fun onWrite(handler: DocumentChangeHandler)
    fun onUpdate(handler: DocumentChangeHandler)

    fun onCreate(handler: DocumentHandler)
    fun onDelete(handler: DocumentHandler)

}


typealias DocumentChangeHandler = (change: DocumentChange, context: EventContext) -> Unit
typealias DocumentHandler = (snapshot: DocumentSnapshot, context: EventContext) -> Unit