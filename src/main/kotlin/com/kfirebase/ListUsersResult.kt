package com.kfirebase

import com.kfirebase.admin.UserRecord

external interface ListUsersResult {
    val pageToken: String?
    val users: List<UserRecord>?
}