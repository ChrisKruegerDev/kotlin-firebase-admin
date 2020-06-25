package firebase

external interface ListUsersResult {
    val pageToken: String?
    val users: List<UserRecord>?
}