# bintray-release

Super easy way to release your Android artifacts to bintray.

## Description

This is a helper for publish libraries to bintray. It is intended to help configuring stuff related to maven and bintray.
At the moment it works with Android Library projects, plain Java and plain Groovy projects, but our focus is to mainly support Android projects.

## Adding to project

To publish a library to bintray using this plugin, add these dependencies to the `build.gradle` of the module that will be published:

```groovy
apply plugin: 'com.lwfwind.bintray-publish' // must be applied after your artifact generating plugin (eg. java / com.android.library)

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.lwfwind:bintray-publish:1.0.0'
    }
}
```


## Simple usage

Use the `publish` closure to set the info of your package:

```groovy
publish {
    userOrg = 'lwfwind'
    groupId = 'com.lwfwind'
    artifactId = 'bintray-publish'
    publishVersion = '1.0.0'
    desc = 'Oh hi, this is a nice description for a project, right?'
    website = 'https://github.com/lwfwind/bintray-publish'
}
```

Finally, use the task `bintrayUpload` to publish (make sure you build the project first!):

```bash
$ ./gradlew clean build bintrayUpload -PbintrayUser=BINTRAY_USERNAME -PbintrayKey=BINTRAY_KEY -PdryRun=false
```
