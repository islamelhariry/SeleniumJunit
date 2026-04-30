# Selenium Grid Execution Flow

Flow Diagram
Gradle Command:
-Dremote=true
-DgridUrl=http://localhost:4444/wd/hub

        |
        v
DriverConfig.remote = true

        |
        v
WebDriverFactory.forConfig()

        |
        v
RemoteStrategy

        |
        v
RemoteWebDriver(gridUrl, capabilities)

        |
        v
Grid Hub

        |
        v
Grid Node (Chrome/Firefox/Edge)

        |
        v
Test Execution
