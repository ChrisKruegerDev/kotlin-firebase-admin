package firebase.functions

import express.Express

external interface Https {
    fun onRequest(handler: Express)
}