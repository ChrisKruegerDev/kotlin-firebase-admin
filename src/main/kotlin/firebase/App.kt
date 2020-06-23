package firebase

import firebase.admin.Admin
import firebase.admin.Auth
import firebase.admin.AuthTrigger
import firebase.admin.database.Database
import firebase.admin.firestore.Firestore
import firebase.admin.firestore.FirestoreTrigger
import firebase.functions.Config
import firebase.functions.Https

/**
 * A Firebase app holds the initialization information for a collection of
 * services.
 *
 * Do not call this constructor directly. Instead, use
 * {@link
 *   https://firebase.google.com/docs/reference/admin/node/admin#.initializeApp
 *   `admin.initializeApp()`}
 * to create an app.
 */
external interface App {

    val admin: Admin
    val functions: dynamic
    val https: Https
    val config: Config

    val database: Database
    val databaseTriggers: Database

    val firestore: Firestore
    val firestoreTrigger: FirestoreTrigger

    val auth: Auth
    val authTrigger: AuthTrigger

}