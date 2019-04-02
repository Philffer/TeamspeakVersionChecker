package de.pp.ts3.version.checker.core.client

import de.pp.ts3.version.checker.core.model.Language
import de.pp.ts3.version.checker.core.model.TeamspeakType
import de.pp.ts3.version.checker.core.services.URLBuilderService

/**
 * Service Implementation of the URLBuilderService
 * Responsible for creating the Request-URL
 *
 * @author Philipp Pfeiffer
 */
class URLBuilderServiceImpl: URLBuilderService {

    private val urlPathLanguage: String = "{lang}"
    private val urlPathType: String = "{type}"

    private var baseUrl: String = "https://www.teamspeak.com/${urlPathLanguage}/downloads/#${urlPathType}"

    override fun buildUrl(language: Language, teamspeakType: TeamspeakType): String {
        return baseUrl.replace(urlPathLanguage, language.isoCode).replace(urlPathType, teamspeakType.urlSuffix)
    }


}