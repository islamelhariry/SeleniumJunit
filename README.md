# Selenium Execution Engine

A scalable, extensible Selenium automation framework built using modern design patterns:

- **Builder** for runtime configuration
- **Abstract Factory** for browser selection
- **Strategy** for local vs. remote execution
- **ThreadLocal Singleton** for parallel-safe WebDriver management
- **Tag-based test suites** (smoke, regression, full)
- **Gradle-powered execution** with full CLI configurability

This framework is designed for **local**, **headless**, and **Selenium Grid** execution and is fully ready for **CI/CD pipelines**.

---

## 🚀 Quick Start

### Run all tests
./gradlew test

### Run smoke suite
./gradlew regressionTest

---

## 🖥️ Browser Selection

### Chrome
./gradlew regressionTest -Dbrowser=chrome

### Edge
./gradlew regressionTest -Dbrowser=edge

---

## 🕶️ Headless Mode

Chrome:
./gradlew regressionTest -Dbrowser=chrome -Dheadless=true

Firefox:
./gradlew regressionTest -Dbrowser=firefox -Dheadless=true

Edge:
./gradlew regressionTest -Dbrowser=edge -Dheadless=true

---

## 🌐 Selenium Grid Execution

Chrome on Grid:
./gradlew regressionTest \
-Dbrowser=chrome \
-Dremote=true \
-DgridUrl=http://localhost:4444/wd/hub

Firefox on Grid:
./gradlew regressionTest \
-Dbrowser=firefox \
-Dremote=true \
-DgridUrl=http://localhost:4444/wd/hub


---

## 🧱 Architecture Summary

execution.core/
│
├── DriverConfig.java          → Builder pattern (reads -D flags)
├── WebDriverFactory.java      → Abstract Factory (Chrome/Firefox/Edge)
├── ChromeDriverFactory.java
├── FirefoxDriverFactory.java
├── EdgeDriverFactory.java
│
├── DriverCreationStrategy.java → Strategy (Local vs Remote)
├── LocalStrategy.java
├── RemoteStrategy.java
│
└── DriverManager.java         → ThreadLocal Singleton (1 driver per thread)

Tests live under:

qa.tools/
smoke/
regression/

Selenium example tests (`dev/selenium/**`) are excluded from compilation.

---

## 🧪 CI/CD Integration

This framework is CI-ready because:

- All configuration is passed via `-D` flags
- No code changes required per environment
- Grid execution works out-of-the-box
- ThreadLocal driver supports parallel builds

### GitHub Actions Example

```yaml
name: Regression Suite

on: [push, pull_request]

jobs:
  regression:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'

      - name: Run regression tests (Chrome headless)
        run: ./gradlew regressionTest -Dbrowser=chrome -Dheadless=true
