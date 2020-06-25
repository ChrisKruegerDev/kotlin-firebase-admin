package firebase

external interface App {
    val name: String
    fun auth(): Auth
    fun firestore(): Firestore
}