API Automation Project
This is a sample API automation framework using Java, Maven, Rest Assured, TestNG, and Cucumber.
It automates testing for APIs such as ReqRes.in, JSONPlaceholder, GoRest, and more.
It is designed for simplicity, scalability, and easy onboarding of new team members.

Features
Java + Maven based, cross-platform.

Cucumber with TestNG for BDD style specifications.

Uses Rest Assured for HTTP requests and validations.
Supports data files, schema validation, dynamic configuration.
Generates beautiful HTML and Extent Reports.
Modular and ready for CI/CD or further customization.

----- Folder Structure ------
api-automation-project/
├── src
│   └── test
│       ├── java
│       │   └── com
│       │       └── api
│       │           ├── runners/
│       │           │    └── TestRunner.java
│       │           ├── stepdefinitions/
│       │           │    └── ReqResSteps.java
│       │           └── utils/
│       │                └── apiUtils.java, JsonUtil.java, ...
│       └── resources
│           ├── features/
│           │    └── request_user.feature
│           ├── data/
│           │    ├── create_user_1.json
│           │    └── update_user.json
│           ├── schemas/
│           │    └── reqres_users_schema.json
│           ├── properties/
│           │    └── config.properties
│           ├── config.properties
│           ├── log4j2.xml
│           └── extent-config.xml
├── pom.xml
└── README.txt or README.md


