package firebase

import kotlin.js.Date

@JsModule("firebase-admin")
external object admin {

    fun app(name: String? = definedExternally): App
    fun initializeApp(): App
    fun initializeApp(options: Any, name: String? = definedExternally): App

    object firestore {
        open class Timestamp {
            companion object {
                fun now(): Timestamp
                fun fromDate(date: Date): Timestamp
                fun fromMillis(milliseconds: Double): Timestamp
            }

            fun toDate(): Date
            fun toMillis(): Double
            fun isEqual(other: Timestamp): Boolean
        }

        open class FieldValue {
            companion object {
                fun increment(n: Int): FieldValue
            }
        }
    }

}

external interface App {
    val name: String
    fun auth(): Auth
    fun firestore(): Firestore
}
