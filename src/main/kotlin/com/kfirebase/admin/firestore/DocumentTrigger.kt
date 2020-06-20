package com.kfirebase.admin.firestore

import com.kfirebase.functions.EventContext

external interface DocumentTrigger {
    fun onCreate(callback: (DocumentSnapshot, EventContext) -> Unit)
    fun onWrite(callback: (DocumentChange, EventContext) -> Unit)
    fun onUpdate(callback: (DocumentChange, EventContext) -> Unit)
    fun onDelete(callback: (DocumentSnapshot, EventContext) -> Unit)
}