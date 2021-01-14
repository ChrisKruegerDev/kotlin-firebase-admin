package firebase

import kotlin.js.Promise

external interface Query {

    /**
     * Executes the query and returns the results as a `QuerySnapshot`.
     *
     * @return A Promise that will be resolved with the results of the Query.
     */
    fun get(): Promise<QuerySnapshot>

    /**
     * Creates and returns a new Query with the additional filter that documents
     * must contain the specified field and that its value should satisfy the
     * relation constraint provided.
     *
     * This function returns a new (immutable) instance of the Query (rather
     * than modify the existing instance) to impose the filter.
     *
     * @param fieldPath The path to compare
     * @param opStr The operation string (e.g "<", "<=", "==", ">", ">=").
     * @param value The value for comparison
     * @return The created Query.
     */
    fun where(fieldPath: Any, opStr: String, value: Any?): Query

    /**
     * Creates and returns a new Query that's additionally sorted by the
     * specified field, optionally in descending order instead of ascending.
     *
     * This function returns a new (immutable) instance of the Query (rather
     * than modify the existing instance) to impose the order.
     *
     * @param fieldPath The field to sort by.
     * @param directionStr Optional direction to sort by ('asc' or 'desc'). If
     * not specified, order will be ascending.
     * @return The created Query.
     */
    fun orderBy(fieldPath: Any, directionStr: String? = definedExternally): Query

    /**
     * Creates and returns a new Query that only returns the first matching
     * documents.
     *
     * This function returns a new (immutable) instance of the Query (rather
     * than modify the existing instance) to impose the limit.
     *
     * @param limit The maximum number of items to return.
     * @return The created Query.
     */
    fun limit(limit: Int): Query

    /**
     * Creates and returns a new Query that only returns the last matching
     * documents.
     *
     * You must specify at least one orderBy clause for limitToLast queries,
     * otherwise an exception will be thrown during execution.
     *
     * Results for limitToLast queries cannot be streamed via the `stream()`
     * API.
     *
     * @param limit The maximum number of items to return.
     * @return The created Query.
     */
    fun limitToLast(limit: Int): Query

    /**
     * Specifies the offset of the returned results.
     *
     * This function returns a new (immutable) instance of the Query (rather
     * than modify the existing instance) to impose the offset.
     *
     * @param offset The offset to apply to the Query results.
     * @return The created Query.
     */
    fun offset(offset: Int): Query

    /**
     * Creates and returns a new Query that starts at the provided fields
     * relative to the order of the query. The order of the field values
     * must match the order of the order by clauses of the query.
     *
     * @param fieldValues The field values to start this query at, in order
     * of the query's order by.
     * @return The created Query.
     */
    fun startAt(vararg fieldValues: String): Query

    /**
     * Creates and returns a new Query that starts after the provided fields
     * relative to the order of the query. The order of the field values
     * must match the order of the order by clauses of the query.
     *
     * @param fieldValues The field values to start this query after, in order
     * of the query's order by.
     * @return The created Query.
     */
    fun startAfter(vararg fieldValues: String): Query

    /**
     * Creates and returns a new Query that ends at the provided fields
     * relative to the order of the query. The order of the field values
     * must match the order of the order by clauses of the query.
     *
     * @param fieldValues The field values to end this query at, in order
     * of the query's order by.
     * @return The created Query.
     */
    fun endAt(vararg fieldValues: String): Query

}

object QueryDirection {
    const val DESCENDING = "desc"
    const val ASCENDING = "asc"
}


fun Query.whereEqualTo(field: String, value: Any): Query = where(field, "==", value)
fun Query.whereArrayContains(field: String, value: Any): Query = where(field, "array-contains", value)
fun Query.whereArrayContainsAny(field: String, value: Array<Any>): Query = where(field, "array-contains-any", value)
fun Query.whereIn(field: String, value: Array<Any>): Query = where(field, "in", value)
fun Query.whereNotIn(field: String, value: Array<Any>): Query = where(field, "not-in", value)
fun Query.whereNotEqualTo(field: String, value: Any): Query = where(field, "!=", value)
fun Query.whereGreaterThan(field: String, value: Any): Query = where(field, ">", value)
fun Query.whereGreaterEqualsTo(field: String, value: Any): Query = where(field, ">=", value)
fun Query.whereLesserThan(field: String, value: Any): Query = where(field, "<", value)
fun Query.whereLesserEqualsTo(field: String, value: Any): Query = where(field, "<=", value)