# Highway Ticket Management System

This project is a robust microservice-based backend application designed to streamline the management of highway tickets, vehicle registrations, user management, and payment processing without relying on external payment gateways. The application leverages Spring Boot and Spring Cloud technologies to ensure scalability, resilience, and seamless integration of services.

## Table of Contents

- [Business Scenario](#business-scenario)
- [Technologies Used](#technologies-used)
- [Microservices](#microservices)
- [Service Registry and Discovery](#service-registry-and-discovery)
- [Configuration Server](#configuration-server)
- [API Gateway](#api-gateway)
- [Testing](#testing)
- [Submission Guidelines](#submission-guidelines)

## Business Scenario

In today's dynamic transportation landscape, managing highway tickets efficiently is crucial for ensuring smooth traffic flow and compliance with regulations. Our objective is to develop a robust microservice-based backend application for a Highway Ticket Management System. This system will streamline the handling of ticket issuance, vehicle registration, user management, and payment processing.

## Technologies Used

- **Spring Boot**: For developing microservices.
- **Spring Cloud**: For building distributed systems.
- **Eureka**: For service discovery and registration.
- **Spring Cloud Config**: For centralized configuration management.
- **Spring Cloud Gateway**: For intelligent routing of requests.
- **Postman**: For API testing.

## Microservices

### Ticket Service

- **Business Logic**: Manages the lifecycle of tickets.
- **Functions**: Creation, status updates, and retrieval of ticket information.

### Vehicle Service

- **Business Logic**: Handles vehicle operations.
- **Functions**: Registration, updates, and retrieval of vehicle details.

### User Service

- **Business Logic**: Manages user and owner information.
- **Functions**: Registration, profile updates, and credential verification.

### Payment Service

- **Business Logic**: Facilitates secure payment processing internally.
- **Functions**: Validate payment details, update ticket statuses upon successful payment confirmation.

## Service Registry and Discovery

### Eureka

- **Purpose**: Enables microservices to register themselves and discover other services dynamically.
- **Implementation**: Each microservice registers with Eureka upon startup, facilitating communication without hardcoded dependencies.

## Configuration Server

### Spring Cloud Config

- **Purpose**: Centralizes configuration management.
- **Implementation**: Microservices fetch configurations from the Config Server, allowing updates without redeployment.

## API Gateway

### Spring Cloud Gateway

- **Purpose**: Serves as a single-entry point for client requests.
- **Implementation**: Routes requests to appropriate microservices based on URI and HTTP method, leveraging Eureka for dynamic service discovery.

## Testing

- **Tool**: Postman
- **Approach**:
  - Test all API endpoints.
  - Focus exclusively on backend functionality, excluding user interface development.
  - Ensure functionality and correctness across microservices.
  - Validate error handling and edge cases.

## Submission Guidelines

1. **GitHub Repository**:
   - Push your project to a GitHub repository.
2. **Postman Collection**:
   - Include a Postman collection JSON file in the main directory of your repository.
   - This collection should contain all API endpoints with detailed requests and responses.

---

For detailed steps and business logic explanations, please refer to the documentation within the repository.

