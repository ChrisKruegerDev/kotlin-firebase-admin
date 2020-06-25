package express

import js.require

fun express(useCompression: Boolean = true): ExpressApp {
    val module: dynamic = require("express")
    val app = module().unsafeCast<ExpressApp>()
    if (useCompression)
        app.use(compression())
    return app
}

fun compression(): Any {
    val module: dynamic = require("compression")
    return module() as Any
}
