package express

import js.require

class Compression {
    val compression: dynamic get() = require("compression")
    val function get() = compression()
}