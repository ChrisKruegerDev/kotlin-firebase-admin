package com.kexpress

import com.kjs.require

class Compression {
    val compression: dynamic get() = require("compression")
    val function get() = compression()
}