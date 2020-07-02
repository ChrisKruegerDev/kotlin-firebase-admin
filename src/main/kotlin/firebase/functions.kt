package firebase

import express.Express

@JsModule("firebase-functions")
external object functions {

    object https {
        fun onRequest(handler: Express): CloudFunction
    }

    object auth {
        fun user(): UserBuilder
    }

    object pubsub {
        fun schedule(schedule: String): ScheduleBuilder
    }

    object firestore {
        fun document(path: String): DocumentBuilder
    }

}


