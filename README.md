# 📦 RetailAI - AI-Powered E-Commerce Platform (TV Catalog Focus)

RetailAI is an enterprise-grade, AI-augmented e-commerce backend platform architected using Spring Boot microservices. It enables smart product management and intelligent customer experiences through conversational AI. The current focus is on televisions (TVs) as the primary product category.

---

## 🚀 Overall Scope

RetailAI is designed to:

- Manage a rich catalog of TVs with detailed technical specifications
- Embed AI into the shopping experience (e.g., description generation, product Q&A)
- Follow best practices in microservice design (modularity, scalability, clean architecture)
- Support both **vendor-facing features** (add/edit products) and **user-facing queries** (ask AI)

---

## 🧱 Microservices Architecture (Phase 1)

| Microservice        | Purpose |
|---------------------|---------|
| `product-service`   | Handles product CRUD, schema, TV specs |
| `ai-service`        | Provides AI-powered description generation and Q&A |
| `auth-service`      | Manages user authentication (JWT, login/register) |
| `user-service`      | Manages user/vendor profiles |
| `gateway-service` (future) | API gateway for unified entry point |
| `discovery-service` (future) | Service discovery via Eureka/Consul (optional)

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot 3.x
- Maven (multi-module)
- PostgreSQL
- Lombok
- Docker (upcoming)
- OpenAI API (via ai-service)
- Clean Architecture (controller → service → repository)
- RESTful API Design with DTOs, validations, and exception handling

---

## 📦 Product-Service Module

This microservice manages all product-related logic, focused on TVs.

### Key Features

- Full CRUD operations for TV products
- Rich attribute support: resolution, smart features, ports, audio, etc.
- Auto-generation of product descriptions (AI integrated)
- Future-ready for filtering, sorting, and semantic search

---

## 🧩 Product Data Model

| Field | Description |
|-------|-------------|
| `name` | TV model name |
| `brand` | Manufacturer |
| `price` | Price |
| `quantity` | Inventory count |
| `imageUrl` | Display image |
| `screenSize`, `resolution`, `refreshRate` | Display characteristics |
| `panelType`, `operatingSystem` | Technical specs |
| `hdmiPorts`, `usbPorts` | Connectivity |
| `wattage` | Audio output |
| `smartFeatures`, `supportedApps`, `audioFeatures` | Capabilities |
| `bluetoothSupport`, `voiceControl` | Flags |
| `releaseYear` | Model year |
| `description` | Optional text (AI generated if missing) |

---

## 🔀 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/v1/products` | Create a new TV |
| `GET`  | `/api/v1/products` | List all TVs (search/filter coming) |
| `GET`  | `/api/v1/products/{id}` | Get a TV by ID |
| `PUT`  | `/api/v1/products/{id}` | Update a TV |
| `DELETE` | `/api/v1/products/{id}` | Delete a TV |

---

## 🧠 AI Integration

The `ai-service` provides:

- **Auto-description generation** if `description` is missing
- **AI Q&A**: Users can ask queries like:
    - “Best gaming TV under ₹60K?”
    - “Which TVs support Dolby Vision and Alexa?”

The AI service uses REST to query the product-service and inject real product data into its prompts for grounded answers.

---

## 📂 Suggested Folder Structure

```
retailai/
├── product-service/
│   ├── controller/
│   ├── service/
│   ├── model/
│   ├── dto/
│   ├── repository/
│   ├── exception/
│   └── config/
├── ai-service/
├── auth-service/
├── user-service/
├── gateway-service/ (future)
└── discovery-service/ (future)
```

---

## ⚙️ Setup Instructions

1. Clone the repo
2. Navigate to the microservice folder (e.g., `product-service`)
3. Configure your database in `application.yml`
4. Build and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## 📌 Future Roadmap

- Advanced filtering and sorting
- OpenAPI documentation
- Docker Compose setup
- AI-based product recommendation engine
- Admin dashboard and basic frontend

---

## 👨‍💻 Author

Satish Mallikarjun Paraddi  
[LinkedIn](https://www.linkedin.com/in/satishmallikarjunparaddi)  
[Email](mailto:paraddi.s@northeastern.edu)

---