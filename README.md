# ✈️ Flight Management System

A Full Stack Flight Management System built with Spring Boot, React, TypeScript, and H2 Database.

## 🚀 Features

- View all flights
- Add new flights
- Edit existing flights
- Delete flights
- Search flights by destination
- REST API backend
- Responsive React frontend
- H2 in-memory database

---

## 🛠️ Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

### Frontend
- React
- TypeScript
- Axios
- Vite
- CSS

---

## 📂 Project Structure

```text
flightmanager/
│
├── src/main/java
│   ├── controller
│   ├── model
│   ├── repository
│
├── frontend/
│   ├── src
│   ├── public
│
├── pom.xml
└── README.md
```

---

## ⚙️ Backend Setup

Run the Spring Boot server:

```bash
./mvnw spring-boot:run
```

Backend will be available at:

```text
http://localhost:8080
```

H2 Console:

```text
http://localhost:8080/h2-console
```

---

## ⚙️ Frontend Setup

Navigate to frontend:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Run development server:

```bash
npm run dev
```

Frontend will be available at:

```text
http://localhost:5174
```

---

## 📡 API Endpoints

### Get All Flights

```http
GET /api/flights
```

### Get Flight By ID

```http
GET /api/flights/{id}
```

### Create Flight

```http
POST /api/flights
```

### Update Flight

```http
PUT /api/flights/{id}
```

### Delete Flight

```http
DELETE /api/flights/{id}
```

### Search Flights

```http
GET /api/flights/search?destination=Rome
```

---

## 🎯 Future Improvements

- User authentication
- PostgreSQL integration
- Flight status tracking
- Pagination
- Docker support
- Cloud deployment

---

## 👩‍💻 Author

**Linoy Kaufman**

GitHub:
https://github.com/linoyKaufman