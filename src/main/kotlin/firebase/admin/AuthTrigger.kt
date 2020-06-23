package firebase.admin

external interface AuthTrigger {
    /**
     * Handle events related to Firebase authentication users.
     */
    fun user(): UserBuilder
}