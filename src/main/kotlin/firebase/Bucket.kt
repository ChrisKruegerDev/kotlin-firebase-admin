package firebase

import kotlin.js.Promise

external interface Bucket {

    val name: String

    fun file(name: String): File
    fun file(name: String, options: FileOptions?): File
    fun upload(pathString: String): Promise<UploadResponse>

    /**
     * JS: upload(pathString: string, options?: UploadOptions): Promise<UploadResponse>;
     */
    fun upload(pathString: String, options: UploadOptions?): Promise<UploadResponse>
    fun upload(pathString: String, options: UploadOptions?, callback: UploadCallback): Promise<UploadResponse>

}


typealias UploadCallback = (err: Error, file: File?) -> Unit