package firebase

import kotlin.js.Promise

external interface Auth {
    fun getUser(uid: String): Promise<UserRecord>
    fun createUser(properties: CreateRequest): Promise<UserRecord>
    fun deleteUser(uid: String): Promise<Any>
}