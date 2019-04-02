package de.pp.ts3.version.checker.core.client

import de.pp.ts3.version.checker.core.model.Language
import de.pp.ts3.version.checker.core.model.OperatingSystem
import de.pp.ts3.version.checker.core.model.TeamspeakType

/**
 * Factory Class for creating new instances of the TeamspeakVersionChecker
 * @author Philipp Pfeiffer
 */
interface TeamspeakVersionCheckerFactory {

    companion object {
        fun create(operatingSystem: OperatingSystem, teamspeakType: TeamspeakType, architecture: Int = 64, language: Language = Language.ENGLISH): TeamspeakVersionCheckerImpl = TeamspeakVersionCheckerImpl(operatingSystem, teamspeakType, architecture, language)
    }

}