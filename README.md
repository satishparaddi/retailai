# 📦 RetailAI - Product Service (TV Catalog Microservice)

RetailAI is an AI-powered e-commerce platform built with a microservices architecture. This `product-service` handles everything related to managing television products — from CRUD operations to exposing AI-relevant attributes like screen size, resolution, and smart features.

---

## 🚀 Features

- Full CRUD for TV products
- Rich TV-specific attributes (brand, resolution, panel type, etc.)
- Search & filter support (planned)
- AI integration support for:
  - Auto-generating product descriptions
  - Natural language product recommendations (via ai-service)
- Built with clean code, layered architecture, and best practices

---

## 🧱 Tech Stack

- **Spring Boot 3.x**
- **Java 17**
- **Maven**
- **PostgreSQL**
- **Lombok**
- **Docker** (planned)
- **OpenAI API** (via `ai-service`, separate microservice)

---

## 🧩 Product Data Model

The `Product` entity represents a TV and includes:

| Field | Description |
|-------|-------------|
| `name` | TV model name |
| `brand` | Manufacturer (e.g., Sony, LG) |
| `price` | Product price |
| `quantity` | Inventory count |
| `imageUrl` | Publicly viewable image link |
| `screenSize` | e.g., “55 inch” |
| `resolution` | e.g., “4K UHD” |
| `refreshRate` | e.g., “120Hz” |
| `panelType` | e.g., OLED, QLED |
| `operatingSystem` | Android TV, Tizen, etc. |
| `hdmiPorts`, `usbPorts` | Number of ports |
| `wattage` | e.g., “20W” speaker output |
| `smartFeatures` | List of TV smart features (e.g., Alexa, HDR10+) |
| `audioFeatures` | e.g., Dolby Atmos |
| `supportedApps` | e.g., Netflix, Prime Video |
| `bluetoothSupport` | true/false |
| `voiceControl` | true/false |
| `releaseYear` | e.g., 2023 |
| `description` | Optional text, can be AI-generated |

---

## 📂 Package Structure

```
product-service/
├── controller/
├── service/
├── model/
├── dto/
├── repository/
├── exception/
└── config/
```

---

## 🔀 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/v1/products` | Create product |
| `GET` | `/api/v1/products` | Get all products (filter/search planned) |
| `GET` | `/api/v1/products/{id}` | Get product by ID |
| `PUT` | `/api/v1/products/{id}` | Update product |
| `DELETE` | `/api/v1/products/{id}` | Delete product |

---

## 📦 Integration with AI

This microservice is designed to work closely with `ai-service`, which:

- Auto-generates descriptions when missing (during `POST`)
- Handles user Q&A queries and fetches matching products

---

## ⚙️ Setup

1. Clone the repo
2. Navigate to `product-service/`
3. Configure DB in `application.yml`
4. Run:
   ```bash
   mvn spring-boot:run
   ```

---

## 📌 Future Work

- Add advanced filtering and sorting (by brand, resolution, refreshRate, etc.)
- Dockerize the service
- Add OpenAPI (Swagger) documentation
- Connect with AI-service for real-time enrichment

---

## 👨‍💻 Author

Satish Mallikarjun Paraddi  
[LinkedIn](https://www.linkedin.com/in/satishmallikarjunparaddi) | [Email](mailto:paraddi.s@northeastern.edu)

---