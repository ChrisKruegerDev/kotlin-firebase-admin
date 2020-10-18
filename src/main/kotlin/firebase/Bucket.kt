package firebase

import kotlin.js.Promise
import kotlin.js.json

external interface Bucket {

    val name: String

    fun file(name: String, options: dynamic = definedExternally): File
    fun upload(pathString: String): Promise<UploadResponse>

    /**
     * JS: upload(pathString: string, options?: UploadOptions): Promise<UploadResponse>;
     */
    fun upload(pathString: String, options: UploadOptions?): Promise<UploadResponse>
    fun upload(pathString: String, options: UploadOptions?, callback: UploadCallback): Promise<UploadResponse>

}

fun Bucket.file(name: String, resumable: Boolean) = file(name, json(
    "uploadType" to json("resumable" to resumable)
))

typealias UploadCallback = (err: Error, file: File?) -> Unit