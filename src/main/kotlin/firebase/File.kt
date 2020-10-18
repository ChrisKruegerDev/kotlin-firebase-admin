package firebase

import kotlin.js.Promise
import kotlin.js.json

external interface File {

    fun save(data: Any, options: SaveOptions? = definedExternally): Promise<Unit>

}

fun File.save(data: Any, resumable: Boolean?, contentType: String): Promise<Unit> {
    val options = json(
        "resumable" to resumable,
        "metadata" to json("contentType" to contentType)
    )
    return save(data, options)
}

typealias SaveOptions = Any