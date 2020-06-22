package com.kjs

external fun require(module: String): dynamic
external val exports: dynamic

/**
 * Build jsObject with
 * jsObject {
 *   id = "123"
 * }
 */
fun jsObject(init: dynamic.() -> Unit): dynamic {
    val o = js("{}")
    init(o)
    return o
}

fun jsObject(vararg pairs: Pair<Any, Any?>): dynamic {
    return jsObject(pairs.asIterable())
}

fun jsObject(pairs: Iterable<Pair<Any, Any?>>): dynamic {
    val data: dynamic = js("({})")
    for ((name, value) in pairs) {
        data[name] = value
    }
    return data
}