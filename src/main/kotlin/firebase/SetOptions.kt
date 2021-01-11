package firebase

import kotlin.js.Json
import kotlin.js.json

object SetOption {

    fun merge(enable: Boolean = true): Json = json("merge" to enable)

    fun mergeFields(vararg fieldNames: String): Json {
        return json("mergeFields" to fieldNames)
    }

}