package de.pp.ts3.version.checker.core.client

import de.pp.ts3.version.checker.core.model.Language
import de.pp.ts3.version.checker.core.model.OperatingSystem
import de.pp.ts3.version.checker.core.model.TeamspeakType
import de.pp.ts3.version.checker.core.services.HTMLParserService
import de.pp.ts3.version.checker.core.services.TeamspeakVersionChecker

/**
 * Implementation of the TeamspeakVersionChecker Interface
 *
 * @author Philipp Pfeiffer
 */
data class TeamspeakVersionCheckerImpl(var operatingSystem: OperatingSystem, var teamspeakType: TeamspeakType, var architecture: Int, var language: Language): TeamspeakVersionChecker {

    val htmlParserService: HTMLParserService = HTMLParserServiceImpl()

    var downloadUrl: String? = null

    override fun setOperatingSystem(operatingSystem: OperatingSystem): TeamspeakVersionCheckerImpl {
        this.operatingSystem = operatingSystem
        return this
    }

    override fun setTeamspeakType(teamspeakType: TeamspeakType): TeamspeakVersionCheckerImpl {
        this.teamspeakType = teamspeakType
        return this
    }

    override fun setLanguage(language: Language): TeamspeakVersionCheckerImpl {
        this.language = language
        return this
    }

    override fun setArchitecture(architecture: Int): TeamspeakVersionCheckerImpl {
        this.architecture = architecture
        return this
    }

    override fun getVersion(): String? {
        return htmlParserService.getVersion(operatingSystem = operatingSystem, teamspeakType = teamspeakType, architecture = architecture, language = language)
    }

    override fun getDownloadURL(): String? {
        downloadUrl = htmlParserService.getDownloadURL(operatingSystem = operatingSystem, teamspeakType = teamspeakType, architecture = architecture, language = language)
        return downloadUrl
    }

}