import de.pp.ts3.version.checker.core.model.OperatingSystem
import de.pp.ts3.version.checker.core.model.TeamspeakType
import de.pp.ts3.version.checker.core.client.TeamspeakVersionCheckerFactory
import de.pp.ts3.version.checker.core.services.TeamspeakVersionChecker


var client: TeamspeakVersionChecker = TeamspeakVersionCheckerFactory.create(OperatingSystem.LINUX, TeamspeakType.CLIENT)

var version: String? = client.getVersion()

var downloadUrl: String? = client.getDownloadURL()

println(version)

println(downloadUrl)