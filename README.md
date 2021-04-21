[![Maven Central](https://img.shields.io/maven-central/v/dev.chriskrueger/kotlin-firebase-admin?label=Maven%20Central)](https://search.maven.org/artifact/dev.chriskrueger/kotlin-firebase-admin)
[![Kotlin](https://img.shields.io/badge/kotlin-1.4.32-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/Gradle-7-green?style=flat)](https://gradle.org)
[![Twitter](https://img.shields.io/badge/-chrisnkrueger-08a0e9?style=flat&logo=twitter&logoColor=white&link=https://twitter.com/chrisnkrueger/)](https://twitter.com/chrisnkrueger)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

# kotlin-firebase-admin
A lightweight Kotlin wrapper for Firebase Admin backend API library. Major version number of this wrapper matches that of Firebase itself.

## Adding to your project

The library is published to Maven Central.

### Gradle

Add the Maven Central repository if it is not already there.

```kotlin
repositories {
    mavenCentral()
}
```

To use the library in a single-platform project, add a dependency.

```kotlin
dependencies {
    implementation("dev.chriskrueger:kotlin-firebase-admin:1.4.0")
}
```

## Setup Firebase in Kotlin project

### Firebase installation
Create a new Kotlin Multiplatform or  Kotlin/JS project. Navigate to folder where the function code is going to be stored and type following commands:

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

Example project is [kotlin-firebase-functions-sample](https://github.com/chrisbln/kotlin-firebase-functions-sample).

### Gradle dependencies

To start using `kotlin-firebase-functions` in your Kotlin/JS project, add the following four dependencies to the `dependencies` block for your JavaScript target inside your `build.gradle` file:
```kotlin
implementation("dev.chriskrueger:kotlin-firebase-admin:1.4.0")
implementation("dev.chriskrueger:kotlin-express:1.1.1")

implementation(npm("text-encoding", "0.7.0"))
implementation(npm("compression", "1.7.4"))

// if not installed via npm directly
implementation(npm("firebase-admin", "8.12.1"))
implementation(npm("firebase-functions", "3.7.0"))
implementation(npm("kotlinx-coroutines-core", "1.3.7"))
```

## Getting started
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
