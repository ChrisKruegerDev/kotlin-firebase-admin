package firebase.admin

import firebase.functions.EventContext
import kotlin.js.Promise

external interface UserBuilder {

    fun onCreate(handler: (user: UserRecord, context: EventContext) -> Unit): Promise<UserRecord>
    fun onDelete(handler: (user: UserRecord, context: EventContext) -> Unit): Promise<UserRecord>

}