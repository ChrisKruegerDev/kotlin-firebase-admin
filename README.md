## kotlin-firebase-functions
A lightweight Kotlin wrapper for Firebase Functions backend API library. Major version number of this wrapper matches that of Firebase itself.

### Setup

#### Project setup for Multiplatform
Create a new Kotlin Multiplatform project.
Navigate to folder where function code (Kotlin Multiplatform folder) is going to be stored and type following commands:

```
# Allow Firebase CLI access to your projects
firebase login

# Initialize project in this folder
firebase init functions

# Install kotlin dependancy for future use
cd functions
npm install kotlin --save
npm install kotlinx-coroutines-core --save
```

An example is this project [kotlin-firebase-functions-sample](https://github.com/chrisbln/kotlin-firebase-functions-sample).


#### Using Gradle
As for all wrappers, make sure that you have the Bintray repository added to your build file:


```kotlin
repositories {
    // . . .
    maven("https://dl.bintray.com/chrisbln/maven")
    // . . .
}
```


To start using `kotlin-firebase-functions` in your Kotlin/JS project, add the following four dependencies to the `dependencies` block for your JavaScript target inside your `build.gradle.kts` or `build.gradle` file:
```kotlin
implementation("com.chrisbln:kotlin-firebase-functions:1.1.0")
implementation("com.chrisbln:kotlin-express:1.0.1")

implementation(npm("text-encoding", "0.7.0"))
implementation(npm("compression", "1.7.4"))

// if not installed via npm directly
implementation(npm("firebase-admin", "8.12.1"))
implementation(npm("firebase-functions", "3.7.0"))
implementation(npm("kotlinx-coroutines-core", "1.3.7"))
```

### Getting started
Initialize a new firebase app instance:

```kotlin
val app = admin.initializeApp()
```

#### HTTP request

```kotlin
val app = express()
app.get("") { _, res ->
    res.status(200).send("hello")
}
exports.hello = firebaseApp.https.onRequest(app)
```

#### Firestore trigger

```kotlin
exports.updateName = functions.firestore
            .document("user/{userId}")
            .onUpdate { change, _ ->
                val user = change.before.data<UserData>()
                val userEdit = change.after.data<UserData>()

                console.log("update ${user.name} to ${userEdit.name}")
            }
```
