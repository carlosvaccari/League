# League android-code-challenge

Repo: https://github.com/carlosvaccari/League

If you need access, please send me your email so I can provide it to you.

# About

This is a test for League company.

This project uses MVVM as arch, Hilt as DI, Coroutines and Compose.

It was implemented light and dark mode and a simple error screen in case of any exception happens while trying to
fetch data from network.

There are Unit Tests and Instrumented tests. The instructions of how to run them can be found on `How
To Run` section.

# Important

1 - The NetworkResult code isn't mine. It's something that I'm used to use because it helps handling
error while fetching data from network. More info can be found here
-> https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe

2 - My understanding is that implementing a login screen + storing user token isn't the main goal of this test, 
so I've added a workaround to handle this in the class `RemoteDataSource`

# How To run

* InstrumentedTests -> ./gradlew connectedAndroidTest
* UnitTests -> ./gradlew test
* Application -> ./gradlew assemble installDebug