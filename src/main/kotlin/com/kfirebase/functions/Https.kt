package com.kfirebase.functions

import com.kfirebase.express.ExpressApp


external interface Https {
    fun onRequest(handler: ExpressApp)
}