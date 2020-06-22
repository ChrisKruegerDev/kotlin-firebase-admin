package com.kfirebase.functions

import com.kexpress.ExpressApp


external interface Https {
    fun onRequest(handler: ExpressApp)
}