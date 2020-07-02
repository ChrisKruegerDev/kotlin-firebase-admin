package firebase

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