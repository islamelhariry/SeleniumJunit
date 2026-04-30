# Architecture Diagram

High-Level Architecture

                   +----------------------+
                   |   Gradle CLI Flags   |
                   |  -Dbrowser=chrome    |
                   |  -Dheadless=true     |
                   |  -Dremote=true       |
                   +----------+-----------+
                              |
                              v
                    +------------------+
                    |  DriverConfig    |
                    |  (Builder)       |
                    +--------+---------+
                             |
                             v
                 +--------------------------+
                 |   WebDriverFactory       |
                 | (Abstract Factory)       |
                 +------+------+------------+
                        |      |
                        |      |
        +---------------+      +----------------+
        |                                      |
        v                                      v
+-------------------+                +--------------------+
| ChromeDriverFactory|               | FirefoxDriverFactory|
+---------+----------+               +----------+----------+

        |                                    |
        v                                    v
+------------------+                 +------------------+
| LocalStrategy    |                 | RemoteStrategy   |
| (Local Driver)   |                 | (Grid Driver)    |
+---------+--------+                 +---------+--------+

        |                                    |
        v                                    v
+-------------+                      +-------------+
| WebDriver   |                      | WebDriver   |
+------+------+                      +------+------+

        |                                    |
        v                                    v
+-----------------------------------------------+
|              DriverManager (ThreadLocal)      |
+-----------------------------------------------+
