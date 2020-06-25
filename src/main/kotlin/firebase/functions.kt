package firebase

import express.Express

@JsModule("firebase-functions")
external object functions {

    fun config(): Config

    object https {
        fun onRequest(handler: Express): HttpsFunction
    }

    object auth {
        fun user(): UserBuilder
    }

}