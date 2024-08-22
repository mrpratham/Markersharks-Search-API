# Markersharks-Search-

# Makersharks Supplier Search API

## Overview

This project is a proof of concept (POC) for a RESTful API built using Spring Boot. The API allows buyers to search for manufacturers based on their customized requirements, such as location, nature of business, and manufacturing processes. The API is designed with proper input validation, exception handling, and security best practices in mind.

## Features

- Retrieve a list of manufacturers based on location, nature of business, and manufacturing processes.
- Pagination support for large result sets.
- Input validation and sanitization to ensure data integrity and security.
- Global exception handling for consistent error responses.
- Built-in Swagger documentation for easy API exploration.

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (for in-memory testing; can be replaced with MySQL)
- **Spring Validation**

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven 2.5** or higher

## API Endpoints ##

1. /api/supplier/query [ POST ]

**Example**
Tested on Postman: 

POST /api/supplier/query?location=Pune&natureOfBusiness=SMALL_SCALE&processes=PRINTING_3D&limit=5



### Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/makersharks-supplier-search-api.git
   cd makersharks-supplier-search-api
