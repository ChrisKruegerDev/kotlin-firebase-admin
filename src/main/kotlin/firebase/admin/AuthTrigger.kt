package firebase.admin

import firebase.functions.UserBuilder

external interface AuthTrigger {
    /**
     * Handle events related to Firebase authentication users.
     */
    fun user(): UserBuilder
}