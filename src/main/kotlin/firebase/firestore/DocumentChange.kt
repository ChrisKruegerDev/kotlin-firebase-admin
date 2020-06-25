package firebase.firestore

external interface Change<T> {
    val after: T
    val before: T
}

typealias DocumentChange = Change<DocumentSnapshot>
