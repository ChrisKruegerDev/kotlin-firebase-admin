package firebase


external interface UserRecord {
    val uid: String?
    val providerData: Array<UserInfo>
}

val UserRecord.isAnonymous get() = providerData.isEmpty()