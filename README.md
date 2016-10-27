# bintray-publish

Super easy way to publish your Android artifacts to bintray.

## Adding to project

To publish a library to bintray using this plugin, add these dependencies to the `build.gradle` of the module that will be published:

```groovy
apply plugin: 'com.lwfwind.bintray-publish' // must be applied after your artifact generating plugin (eg. java / com.android.library)

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.lwfwind:bintray-publish:1.1'
    }
}
```


## Simple usage

Use the `publish` closure to set the info of your package:

```groovy
Properties properties = new Properties()
properties.load(project.rootProject.file('local.properties').newDataInputStream())
publish {
    bintrayUser = properties.getProperty("bintray.user")
    bintrayKey = properties.getProperty("bintray.apikey")
    userOrg = 'userOrg'
    groupId = 'groupId'
    artifactId = 'artifactId'
    version = 'version'
    description = 'description'
    website = "https://github.com/website"
    dryRun = false
}
```

Finally, use the task `bintrayUpload` to publish (make sure you build the project first!):
