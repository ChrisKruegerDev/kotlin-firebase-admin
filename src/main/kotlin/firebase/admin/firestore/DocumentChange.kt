package firebase.admin.firestore

external interface DocumentChange {
    val after: DocumentSnapshot
    val before: DocumentSnapshot
}