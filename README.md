# Simple CRUD Spring Boot Application

This repository contains a Spring Boot application for managing students. The application provides RESTful endpoints to perform CRUD operations on student data.

## Endpoints

### Get All Students
- **URL:** `/api/v1/student`
- **Method:** `GET`
- **Description:** Retrieves a list of all students.

### Register New Student
- **URL:** `/api/v1/student`
- **Method:** `POST`
- **Description:** Registers a new student.
- **Request Body:** `Student` object

### Get Student by ID
- **URL:** `/api/v1/student/{studentID}`
- **Method:** `GET`
- **Description:** Retrieves a student by their ID.
- **Path Variable:** `studentID` (Long)

### Delete Student by ID
- **URL:** `/api/v1/student/{studentID}`
- **Method:** `DELETE`
- **Description:** Deletes a student by their ID.
- **Path Variable:** `studentID` (Long)

### Update Student by ID
- **URL:** `/api/v1/student/{studentID}`
- **Method:** `PUT`
- **Description:** Updates a student's name and/or email by their ID.
- **Path Variable:** `studentID` (Long)
- **Request Parameters:**
    - `name` (String, optional)
    - `email` (String, optional)

## How to Build

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd <repository-directory>
   ```

2. **Build the project using Maven:**
   ```sh
   mvn install
   ```

3. **Navigate to the target directory:**
   ```sh
   cd target
   ```

4. **Run the application:**
   ```sh
   java -jar <your-jar-file>.jar --server.port=<port-number>
   ```
