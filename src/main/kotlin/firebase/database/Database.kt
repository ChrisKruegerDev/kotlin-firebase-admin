package firebase.database

external interface Database {

    val app: dynamic

    fun goOffline()
    fun goOnline()
    fun ref(path: String): Reference
    fun refFromURL(url: String): Reference

}