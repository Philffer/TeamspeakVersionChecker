package de.pp.ts3.version.checker.core.services

import de.pp.ts3.version.checker.core.model.Language
import de.pp.ts3.version.checker.core.model.OperatingSystem
import de.pp.ts3.version.checker.core.model.TeamspeakType

/**
 * Service-Interface responsible for finding the desired Information out of the HTML-Document
 * @author Philipp Pfeiffer
 */
interface HTMLParserService {

    /**
     * Extracts the latest version for the given parameters out of the HTML-Document
     *
     * @param operatingSystem
     * @param teamspeakType
     * @param architecture
     * @param language
     *
     * @return the version as a String, if it is found
     */
    fun getVersion(
            operatingSystem: OperatingSystem,
            teamspeakType: TeamspeakType,
            architecture: Int,
            language: Language
    ): String?

    /**
     * Extracts the download-URL of the latest version for the given parameters out of the HTML-Document
     *
     * @param operatingSystem
     * @param teamspeakType
     * @param architecture
     * @param language
     *
     * @return the download-URL as a String, if it is found
     */
    fun getDownloadURL(
        operatingSystem: OperatingSystem,
        teamspeakType: TeamspeakType,
        architecture: Int,
        language: Language
    ): String?
}