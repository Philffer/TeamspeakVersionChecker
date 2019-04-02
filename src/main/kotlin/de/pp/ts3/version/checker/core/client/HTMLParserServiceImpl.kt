package de.pp.ts3.version.checker.core.client

import de.pp.ts3.version.checker.core.model.Language
import de.pp.ts3.version.checker.core.model.OperatingSystem
import de.pp.ts3.version.checker.core.model.TeamspeakType
import de.pp.ts3.version.checker.core.services.HTMLParserService
import de.pp.ts3.version.checker.core.services.URLBuilderService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

/**
 * Implementation of the HTMLParserService-Interface.
 * Responsible for extracting the information out of the HTML-document
 *
 * @author Philipp Pfeiffer
 */
class HTMLParserServiceImpl: HTMLParserService {

    val urlBuilderService: URLBuilderService = URLBuilderServiceImpl()

    private val placeholderType = "{type}"
    private val baseSelectorType: String = "div[id=${placeholderType}]"

    private val placeholderOS = "{os}"
    private val baseSelectorOS: String = "div[class=platform mb-5 ${placeholderOS}]"

    private val baseSelectorRow: String = "div[class=row dlRow py-3]"
    private val baseSelectorVersion: String = "span[class=de.pp.ts3.version.checker.getVersion]"
    private val baseSelectorDownloadURL: String = "input[class=mirror]"

    private val placeholderArchitecture = "{arch}"
    private val baseSelectorArchitecture: String = "${placeholderArchitecture}-bit"

    var latestContent: Element? = null

    private fun getHTMLContent(teamspeakType: TeamspeakType, language: Language): Document = Jsoup.connect(urlBuilderService.buildUrl(teamspeakType = teamspeakType, language = language)).get()

    private fun parse(operatingSystem: OperatingSystem, teamspeakType: TeamspeakType, architecture: Int, language: Language): Element? {
        val content: Document = getHTMLContent(teamspeakType = teamspeakType, language = language)

        val elements: Elements = content
            .select(baseSelectorType.replace(placeholderType, teamspeakType.urlSuffix))
            .select(baseSelectorOS.replace(placeholderOS, operatingSystem.className))
            .select(baseSelectorRow)

        val element: Element? = elements
            .filter{it.html().contains(baseSelectorArchitecture.replace(placeholderArchitecture, architecture.toString()))}.firstOrNull()

        latestContent = element

        return element
    }

    override fun getVersion(operatingSystem: OperatingSystem, teamspeakType: TeamspeakType, architecture: Int, language: Language): String? {
        val element: Element? = parse(operatingSystem = operatingSystem, teamspeakType = teamspeakType, architecture = architecture, language = language)

        return element?.select(baseSelectorVersion)?.first()?.html()
    }

    override fun getDownloadURL(operatingSystem: OperatingSystem, teamspeakType: TeamspeakType, architecture: Int, language: Language): String? {
        val element: Element? = parse(operatingSystem = operatingSystem, teamspeakType = teamspeakType, architecture = architecture, language = language)

        return element?.select(baseSelectorDownloadURL)?.first()?.attr("value")
    }
}