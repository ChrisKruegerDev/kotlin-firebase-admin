package firebase

import kotlin.js.Promise

external interface UserBuilder {

    fun onCreate(handler: UserHandler): Promise<UserRecord>
    fun onDelete(handler: UserHandler): Promise<UserRecord>

}

typealias UserHandler = (user: UserRecord, context: EventContext) -> Promise<Any>?