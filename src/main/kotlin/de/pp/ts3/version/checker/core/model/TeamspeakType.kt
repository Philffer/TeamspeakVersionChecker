package de.pp.ts3.version.checker.core.model

/**
 * Enum representation of the tabs available at teamspeak3.
 * Right now, the tabs 'SDK' and 'TS5 Beta Program' are not available
 *
 * @author Philipp Pfeiffer
 */
enum class TeamspeakType(var urlSuffix: String) {
    CLIENT("client"),
    SERVER("server")
}