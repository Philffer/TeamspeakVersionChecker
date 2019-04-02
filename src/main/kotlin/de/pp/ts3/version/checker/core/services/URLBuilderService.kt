package de.pp.ts3.version.checker.core.services

import de.pp.ts3.version.checker.core.model.Language
import de.pp.ts3.version.checker.core.model.TeamspeakType

/**
 * Service-Interface responsible for constructing the Request-URL
 * @author Philipp Pfeiffer
 */
interface URLBuilderService {

    /**
     * Returns the URL of the HTML-Document to search in
     *
     * @param language
     * @param teamspeakType
     *
     * @return the constructed Request-URL based on the given parameters
     */
    fun buildUrl(language: Language, teamspeakType: TeamspeakType): String

}