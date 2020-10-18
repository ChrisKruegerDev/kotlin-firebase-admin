package firebase

/**
 * JS: export interface UploadOptions extends CreateResumableUploadOptions, CreateWriteStreamOptions
 */
external interface UploadOptions : CreateResumableUploadOptions {
    val destination: String?
}

external interface CreateResumableUploadOptions {
    val metadata: Metadata?
}

/**
 * For example:
 * const metadata = {
 * contentType: contentType,
 * };
 *
 * JS: export declare type Metadata = any
 */
typealias Metadata = Any