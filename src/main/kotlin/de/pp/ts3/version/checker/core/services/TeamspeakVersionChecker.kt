package de.pp.ts3.version.checker.core.services

import de.pp.ts3.version.checker.core.client.TeamspeakVersionCheckerImpl
import de.pp.ts3.version.checker.core.model.Language
import de.pp.ts3.version.checker.core.model.OperatingSystem
import de.pp.ts3.version.checker.core.model.TeamspeakType

/**
 * Client-Interface responsible for providing basic methods to retrieve informations from the Teamspeak3 site
 * @author Philipp Pfeiffer
 */
interface TeamspeakVersionChecker {

    /**
     * Sets the TeamspeakType after client creation
     *
     * @param teamspeakType
     *
     * @return the actual client instance for chaining multiple set-methods builder-style together
     */
    fun setTeamspeakType(teamspeakType: TeamspeakType): TeamspeakVersionCheckerImpl

    /**
     * Sets the OperatingSystem after client creation
     *
     * @param operatingSystem
     *
     * @return the actual client instance for chaining multiple set-methods builder-style together
     */
    fun setOperatingSystem(operatingSystem: OperatingSystem): TeamspeakVersionCheckerImpl

    /**
     * Sets the Language after client creation
     *
     * @param language
     *
     * @return the actual client instance for chaining multiple set-methods builder-style together
     */
    fun setLanguage(language: Language): TeamspeakVersionCheckerImpl

    /**
     * Sets the architecture of the OS (32 or 64)
     *
     * @param architecture
     *
     * @return the actual client instance for chaining multiple set-methods builder-style together
     */
    fun setArchitecture(architecture: Int): TeamspeakVersionCheckerImpl

    /**
     * @return the latest stable version available as a download for the given parameters
     */
    fun getVersion(): String?

    /**
     * @return the download URL for the version
     */
    fun getDownloadURL(): String?

}