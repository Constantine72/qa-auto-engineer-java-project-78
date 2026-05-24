### Hexlet tests and linter status:
[![Actions Status](https://github.com/Constantine72/qa-auto-engineer-java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Constantine72/qa-auto-engineer-java-project-78/actions)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-78&metric=alert_status&token=82159494ca8d7675cd3b574f37b4e8958d3d0015)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-78)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-78&metric=bugs&token=82159494ca8d7675cd3b574f37b4e8958d3d0015)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-78)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-78&metric=code_smells&token=82159494ca8d7675cd3b574f37b4e8958d3d0015)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-78)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-78&metric=duplicated_lines_density&token=82159494ca8d7675cd3b574f37b4e8958d3d0015)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-78)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Constantine72_qa-auto-engineer-java-project-78&metric=coverage&token=82159494ca8d7675cd3b574f37b4e8958d3d0015)](https://sonarcloud.io/summary/new_code?id=Constantine72_qa-auto-engineer-java-project-78)

# Data Validator

## Description
Data Validator is a flexible data validation library written in Java. It allows you to easily validate strings, numbers, and 'Map' objects using the **Fluent Interface** design pattern.

## Features

### 1. StringSchema (String Validation)
* `required()` - the string is required (can not be empty or `null`).
* `minLength(int)` - sets the minimum allowed length for the string.
* `contains(String)` - the string must contain a specific substring.

### 2. NumberSchema (Number Validation)
* `required()` - the number can not be `null`.
* `positive()` - the number must be strictly greater than zero.
* `range(int min, int max)` - the number must fall within the specific range(inclusive).

### 3. MapSchema (Map Validation)
* `required()` - the map can not be `null`.
* `sizeof(int)` - sets the exact number of key-value pairs required in the map.
* `shape(Map<String, BaseSchema<String>>)` - allows defining individual validation rules for specific keys within the map.

---

## Technologies
* **Java 17** (or higher) 
* **JUnit 5** 
* **Gradle**  
* **Github Actions**
* **SonarCloud**

## Build and Testing

```bash
./gradlew build
./gradlew test
