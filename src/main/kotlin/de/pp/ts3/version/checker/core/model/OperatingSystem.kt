package de.pp.ts3.version.checker.core.model

/**
 * Enum representation of the operatingsystems teamspeak3 has downloads for
 *
 * @author Philipp Pfeiffer
 */
enum class OperatingSystem(val validForClient: Boolean, val validForServer: Boolean, val className: String) {
    LINUX(true, true, "linux"),
    MACOS(true, true, "macos"),
    WINDOWS(true, true, "windows"),
    ANDROID(true, false, "android"),
    IOS(true, false, "ios"),
    FREEBSD(false, true, "freebsd")

}