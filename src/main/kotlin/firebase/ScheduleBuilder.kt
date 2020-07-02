package firebase

import kotlin.js.Promise

external interface ScheduleBuilder {
    fun onRun(handler: ScheduleHandler): CloudFunction
}

typealias ScheduleHandler = (context: EventContext) -> Promise<Any>?