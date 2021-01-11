package firebase

import kotlin.js.Date
import kotlin.js.Promise
import kotlin.js.json

@JsModule("firebase-admin")
external object admin {

    fun app(name: String? = definedExternally): App
    fun initializeApp(): App
    fun initializeApp(options: Any, name: String? = definedExternally): App
    fun storage(): storage.Storage

    open class App {
        val name: String
        fun auth(): Auth
        fun firestore(): firestore.Firestore
    }

    object firestore {

        fun setLogLevel(level: String)

        open class Firestore {
            fun collection(collectionPath: String): CollectionReference
            fun batch(): WriteBatch
        }

        open class Timestamp {
            val seconds: Double
            val nanoseconds: Double

            companion object {
                fun now(): Timestamp
                fun fromDate(date: Date): Timestamp
                fun fromMillis(milliseconds: Double): Timestamp
            }

            fun toDate(): Date

            /**
             * seconds * 1000 + (nanoseconds / 1000000.0)
             */
            fun toMillis(): Double
            fun isEqual(other: Timestamp): Boolean
        }

        open class FieldValue {
            companion object {
                fun serverTimestamp(): FieldValue
                fun increment(n: Int): FieldValue
                fun delete(): FieldValue
                fun arrayRemove(vararg elements: Any): FieldValue
                fun arrayUnion(vararg elements: Any): FieldValue
            }
        }
    }

    /**
     * declare namespace admin.storage
     */
    object storage {
        open class Storage {
            /**
             *
             * @returns A [Bucket](https://cloud.google.com/nodejs/docs/reference/storage/latest/Bucket)
             * instance as defined in the `@google-cloud/storage` package.
             *
             * JS: bucket(name?: string): Bucket;
             */
            fun bucket(name: String? = definedExternally): Bucket
        }
    }

    open class WriteBatch {
        fun commit(): Promise<Unit>
        fun delete(documentReference: DocumentReference): WriteBatch
        fun set(documentReference: DocumentReference, data: Any, options: Any? = definedExternally): WriteBatch
        fun update(documentReference: DocumentReference, data: Any): WriteBatch
        fun update(documentReference: DocumentReference, field: Any, value: Any?, vararg moreFieldsAndValues: Any?): WriteBatch
    }

}

fun admin.WriteBatch.setData(documentRef: DocumentReference, data: Any, merge: Boolean) =
    set(documentRef, data, json("merge" to merge))

fun admin.WriteBatch.setData(documentRef: DocumentReference, data: Any, vararg mergeFields: String) =
    set(documentRef, data, json("mergeFields" to mergeFields))
