package firebase.functions

import firebase.admin.UserRecord
import kotlin.js.Promise

external interface UserBuilder {

    fun onCreate(handler: (user: UserRecord, context: EventContext) -> Unit): Promise<UserRecord>
    fun onDelete(handler: (user: UserRecord, context: EventContext) -> Unit): Promise<UserRecord>

}