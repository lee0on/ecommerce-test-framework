# ecommerce-test-framework

UI test automation for an e-commerce site. Stack: Selenium 4 + JUnit 5 + AssertJ, with Allure reporting.

## Prerequisites

- JDK 22
- Maven 3.9+
- Chrome (or Firefox) installed locally — driver binaries are managed automatically by Selenium Manager, no manual download needed.

## Running tests

```
mvn test
```

Override browser / headless mode:

```
mvn test -Dbrowser=firefox -Dheadless=true
```

Target a specific environment config (see `config/`):

```
mvn test -Denv=staging
```

## Viewing the Allure report

```
mvn test
mvn allure:serve
```

## Project structure

- `config/` — environment properties (`config.properties`, `config-dev.properties`, `config-staging.properties`)
- `src/main/java/com/ecomauto/`
  - `config/` — configuration loading
  - `driver/` — WebDriver setup
  - `pages/` — page objects (`base`, `catalog`, `cart`, `checkout`, `account`)
  - `components/` — reusable UI widgets (header, footer, modals)
  - `utils/` — waits, screenshots, test data generation helpers
- `src/test/java/com/ecomauto/`
  - `base/` — shared test base classes / JUnit 5 extensions
  - `tests/` — test classes, grouped by feature area
  - `testdata/` — test data builders/providers
- `src/main/resources/log4j2.xml` — logging config
- `src/test/resources/junit-platform.properties` — JUnit 5 platform config (parallel execution, etc.)

No page objects or test classes exist yet — this is scaffolding only.
