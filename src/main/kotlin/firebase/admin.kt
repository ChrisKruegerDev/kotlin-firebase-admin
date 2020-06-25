package firebase

@JsModule("firebase-admin")
external object admin {

    fun app(name: String? = definedExternally): App
    fun initializeApp(options: Any? = definedExternally, name: String? = definedExternally): App

}
