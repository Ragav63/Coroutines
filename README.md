A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously. Coroutines were added to Kotlin in version 1.3 and are based on established concepts from other languages.

On Android, coroutines help to manage long-running tasks that might otherwise block the main thread and cause your app to become unresponsive. Over 50% of professional developers who use coroutines have reported seeing increased productivity. This topic describes how you can use Kotlin coroutines to address these problems, enabling you to write cleaner and more concise app code.

Features
Coroutines is our recommended solution for asynchronous programming on Android. Noteworthy features include the following:

Lightweight: You can run many coroutines on a single thread due to support for suspension, which doesn't block the thread where the coroutine is running. Suspending saves memory over blocking while supporting many concurrent operations.
Fewer memory leaks: Use structured concurrency to run operations within a scope.
Built-in cancellation support: Cancellation is propagated automatically through the running coroutine hierarchy.
Jetpack integration: Many Jetpack libraries include extensions that provide full coroutines support. Some libraries also provide their own coroutine scope that you can use for structured concurrency.
Examples overview
Based on the Guide to app architecture, the examples in this topic make a network request and return the result to the main thread, where the app can then display the result to the user.

Specifically, the ViewModel Architecture component calls the repository layer on the main thread to trigger the network request. This guide iterates through various solutions that use coroutines to keep the main thread unblocked.

ViewModel includes a set of KTX extensions that work directly with coroutines. These extension are lifecycle-viewmodel-ktx library and are used in this guide.

Dependency info
To use coroutines in your Android project, add the following dependency to your app's build.gradle file:

Groovy
Kotlin

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}
