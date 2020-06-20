package com.kfirebase.express

import com.kfirebase.require

class ExpressInstance : Express {
    override val express: dynamic get() = require("express")
    override val app: ExpressApp
        get() {
            val app = express().unsafeCast<ExpressApp>()
            app.use(Compression().function as Any)
            return app
        }
}