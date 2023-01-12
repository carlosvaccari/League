# android-code-challenge

This repo is for the Android coding interview for new developers :)

Candidates:
Please put build instructions, assumptions and any other notes that you'd like your reviewers to
know about in this file

# About

This is a test for League company.

This projects uses MVVM as arch, Hilt as DI, Coroutines and Compose.

It was implemented light and dark mode and simple error screen in case any exception while trying to
fetch data happens.

There are Unit Tests and Instrumented tests. The instructions of how to run them can be found on How
To Run section.

# Important

The NetworkResult code isn't mine. It's something that I'm used to use because it helps handling
error while fetch data from network. More info can be found here
-> https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe

# How To run

* InstrumentedTests -> ./gradlew connectedAndroidTest
* UnitTests -> ./gradlew test
* Application -> ./gradlew assemble installDebug