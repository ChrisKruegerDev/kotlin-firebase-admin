package com.kfirebase.admin.firestore

external interface FirestoreTrigger {
    fun document(path: String): DocumentTrigger
}