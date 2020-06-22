package com.kfirebase.admin.firestore

external interface QuerySnapshot {
    val docChanges: Array<DocumentChange>
    val docs: Array<DocumentSnapshot>
    val empty: Boolean
    val metaata: dynamic
    val size: Int
    fun forEach(callback: (DocumentSnapshot) -> Unit, thisArg: Any? = definedExternally)
}