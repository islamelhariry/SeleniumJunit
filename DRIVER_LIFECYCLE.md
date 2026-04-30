# Driver Lifecycle

Driver Lifecycle Flow
@BeforeAll

        |
        v
DriverManager.init(config)

        |
        v
Factory.forConfig(config)

        |
        v
LocalStrategy or RemoteStrategy

        |
        v
WebDriver created

        |
        v
@BeforeEach

        |
        v
DriverManager.get()

        |
        v
Test executes

        |
        v
@AfterAll

        |
        v
DriverManager.quit()
