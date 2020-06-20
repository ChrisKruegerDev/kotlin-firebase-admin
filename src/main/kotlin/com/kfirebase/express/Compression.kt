package com.kfirebase.express

import com.kfirebase.require

class Compression {
    val compression: dynamic get() = require("compression")
    val function get() = compression()
}