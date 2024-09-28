# Spring Boot Closure Generator API

## Project Overview

This project serves as a simple introduction to Spring Boot, demonstrating how to create RESTful APIs that generate binary strings based on the concepts of positive closure and Kleene star closure. The project consists of two main APIs, each representing a different type of closure, allowing users to request binary strings of a specified maximum length.

## APIs

### 1. Positive Closure API

>[!WARNING]
> The functions are not prepared for bigger numbers, bigger numbers are not allowed, so use numbers in range of 1 - 10

- **Endpoint**: `/api/cerradura/positiva/{N}`
- **Method**: `PUT`
- **Description**: This API generates all binary strings of length up to `N`, excluding the empty string. It implements the concept of positive closure, meaning that at least one occurrence of the pattern is included in the result.

#### Request Example
```plaintext
PUT /api/cerradura/positiva/3
```

#### Response Example
```json
[
    "0",
    "1",
    "00",
    "01",
    "10",
    "11",
    "000",
    "001",
    "010",
    "011",
    "100",
    "101",
    "110",
    "111"
]
```

### 2. Kleene Star Closure API

>[!WARNING]
> The functions are not prepared for bigger numbers, bigger numbers are not allowed, so use numbers in range of 1 - 10

- **Endpoint**: `/api/cerradura/estrella/{N}`
- **Method**: `PUT`
- **Description**: This API generates all binary strings of length up to `N`, including the empty string (`λ`). It implements the concept of Kleene star closure, which allows for zero or more occurrences of the pattern.

#### Request Example
```plaintext
PUT /api/cerradura/estrella/3
```

#### Response Example
```json
[
    "λ",
    "0",
    "1",
    "00",
    "01",
    "10",
    "11",
    "000",
    "001",
    "010",
    "011",
    "100",
    "101",
    "110",
    "111"
]
```

## Code Structure

- **Controllers**:
  - `HomeController.java`: Contains the API endpoints for both positive and Kleene star closures.
  
- **Repositories**:
  - `Kleene.java`: Implements the logic for generating binary strings according to the Kleene star closure.
  - `Positive.java`: Implements the logic for generating binary strings according to the positive closure.

### Key Classes

1. **HomeController**:
   - Handles incoming requests and delegates processing to the respective closure classes.
   - Maps the APIs to the appropriate HTTP methods and endpoints.

2. **Kleene**:
   - Contains logic to generate binary strings of length up to `N`, including the empty string.
   - Uses recursion to build all possible combinations.

3. **Positive**:
   - Contains logic to generate binary strings of length up to `N`, excluding the empty string.
   - Uses a similar recursive approach to generate combinations.

## Getting Started

### Prerequisites

- Java JDK (version 11 or later)
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse) for Java development

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Testing the APIs

You can use tools like Postman or `curl` to test the APIs:

#### Example using `curl`:
```bash
# Testing the Positive Closure API
curl -X PUT http://localhost:8080/api/cerradura/positiva/3

# Testing the Kleene Star Closure API
curl -X PUT http://localhost:8080/api/cerradura/estrella/3
```
## Detected bugs

Using grater than 6 starts to append this text "* Connection #0 to host localhost left intact", but do not affect the result.


## Conclusion

This project is a practical introduction to Spring Boot and RESTful API development. It demonstrates fundamental concepts such as routing, request handling, and recursion in Java. Feel free to extend the project with additional features or improvements as you continue learning about Spring Boot and related technologies.
```

### Instructions
- Replace `<repository-url>` with the actual URL of your repository.
- Replace `<project-directory>` with the name of your project directory if applicable.
