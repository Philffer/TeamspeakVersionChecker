# Teamspeak3 Version Checker

This project was written in Kotlin.

## Getting started

To get this project use 
```
git pull https://github.com/Philffer/TeamspeakVersionChecker.git
```
or download it as a .zip.

## Functionality

It scrapes the current version and download-URL from https://www.teamspeak.com/en/downloads/

## Dependencies

* JSOUP (for HTML parsing)
* kotlin-script-runtime (for running .kts scripts) 

## Build with

* [Maven](https://maven.apache.org/) - Dependency Management.
You can compile the repository as a .jar file and add it to your project with the command
`mvn clean install`

## How to use

```kotlin
var client: TeamspeakVersionChecker = TeamspeakVersionCheckerFactory.create(OperatingSystem.LINUX, TeamspeakType.CLIENT)

var version: String? = client.getVersion()

var downloadUrl: String? = client.getDownloadURL()
```

### Enums for Clientcreation

Enum | Required? | Represents
---- | --------- | ----------
Language | no | The language to choose from the dropdown at https://www.teamspeak.com/en/downloads/. The default value is 'English'
TeamspeakType | yes | The tabs for choosing the download (see: https://www.teamspeak.com/en/downloads/). Only 'TS3 Client' and 'Server' are supported
OperatingSystem | yes | The OS, for which the version should be checked

### Language

Following enums are available:

* GERMAN
* ENGLISH
* FRENCH
* ITALIAN
* PORTUGESE
* RUSSIAN
* TURKISH
* SPANISH
* POLISH
* THAILAND
* CHINESE
* TAIWENSE

### TeamspeakType

Following enums are available:

* CLIENT: represents the 'TS3 Client' tab at https://www.teamspeak.com/en/downloads/
* SERVER: represents the 'Server' tab at https://www.teamspeak.com/en/downloads/

#### OperatingSystem

Following enums are available:

Value | Available for client | Available for server
----- | -------------------- | --------------------
LINUX | yes | yes
MACOS | yes | yes
WINDOWS | yes | yes
ANDROID | yes | no
IOS | yes | no
FREEBSD | no | yes
