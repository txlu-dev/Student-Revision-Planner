# Student Revision Planner - Tutorial

This tutorial explains how to download, set up, run and use the Student Revision Planner project.

## 1. Requirements

Before starting, make sure you have:

- Java 21
- MySQL
- Git
- Eclipse or another Java IDE (optional)

The project includes the Maven Wrapper, so you do not need to install Maven separately.

## 2. Download the Project

Open Terminal and clone the GitHub repository:

```bash
git clone https://github.com/txlu-dev/Student-Revision-Planner.git
```

Move into the project directory:

```bash
cd Student-Revision-Planner
```

## 3. Create the MySQL Database

Start MySQL:

```bash
mysql -u root -p
```

Enter your MySQL password when prompted.

Create the database:

```sql
CREATE DATABASE revision_planner;
```

Check that it was created:

```sql
SHOW DATABASES;
```

You should see:

```
revision_planner
```

Exit MySQL:

```sql
exit;
```

## 4. Configure the Database Connection

The database credentials are not included in the GitHub repository for security reasons.

Create the following file:

```
src/main/resources/application.properties
```

Add:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/revision_planner
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `YOUR_PASSWORD` with your own MySQL password.

> **Important:** `application.properties` is intentionally excluded from the repository because it contains local database credentials. Create this file on your own computer using your MySQL details.
> 
## 5. Open the Project in Eclipse

Open Eclipse and select:

**File → Import**

Choose:

**Maven → Existing Maven Projects**

Select the `Student-Revision-Planner` folder and import the project.

Wait for Eclipse to finish downloading the Maven dependencies.

## 6. Run the Application

Navigate to:

```
src/main/java/com/example/revisionplanner/RevisionplannerApplication.java
```

Right-click the file and select:

**Run As → Spring Boot App**

Wait for Spring Boot to start.

You should see:

```
Tomcat started on port 8080
```

You can also run the application from Terminal.

On macOS/Linux:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

## 7. Open the Website

Once Spring Boot is running, open a web browser and go to:

```
http://localhost:8080
```

The Student Revision Planner website should appear.

## 8. Add a Revision Task

1. Enter a revision task into the input field.

   For example:

   ```
   Revise Java OOP
   ```

2. Click **Add**.

The task will appear on the webpage and will be saved to the MySQL database.

## 9. Complete a Task

1. Find the task you want to complete.
2. Click **Complete**.

The task will be marked as completed and a visual indicator will show that it is complete.

The completed state is stored in MySQL, so it will remain completed after refreshing the webpage.

## 10. Delete a Task

Click **Delete** next to the task you want to remove.

The task will be deleted from both the webpage and the MySQL database.

## 11. Understanding the Project Structure

The main Java files are located in:

```
src/main/java/com/example/revisionplanner/
```

**`RevisionplannerApplication.java`**
The main Spring Boot application. It starts the Spring Boot application and web server.

**`RevisionTask.java`**
Represents a revision task and is connected to the MySQL database using JPA. It contains:

- `id`
- `title`
- `completed`

**`RevisionTaskRepository.java`**
Handles communication between the application and the database using Spring Data JPA.

**`RevisionTaskController.java`**
Handles requests from the frontend and provides the REST API.

The main endpoints are:

| Method | Endpoint |
|--------|----------|
| GET | `/api/tasks` |
| POST | `/api/tasks` |
| PUT | `/api/tasks/{id}/complete` |
| DELETE | `/api/tasks/{id}` |

## 12. Understanding the Frontend

The frontend files are located in:

```
src/main/resources/static/
```

They are:

- `index.html`
- `script.js`
- `style.css`

**`index.html`** — Contains the structure of the webpage.

**`style.css`** — Controls the appearance of the webpage.

**`script.js`** — Communicates with the Spring Boot REST API.

For example, when a task is added, JavaScript sends:

```
POST /api/tasks
```

When tasks are loaded, JavaScript sends:

```
GET /api/tasks
```

## 13. Understanding the Database

The project uses the MySQL database:

```
revision_planner
```

Hibernate automatically creates the `revision_task` table based on the `RevisionTask` entity.

The table contains:

```
revision_task
├── id
├── title
└── completed
```

You can view the table using MySQL:

```sql
USE revision_planner;
```

Then:

```sql
SELECT * FROM revision_task;
```

You should see the tasks stored by the application.

## 14. Testing the REST API

You can interact with the application directly through the REST API using curl.

**Get all tasks**

```bash
curl http://localhost:8080/api/tasks
```

**Create a task**

```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Revise Java OOP"}'
```

**Complete a task**

Replace `1` with the ID of the task you want to complete:

```bash
curl -X PUT http://localhost:8080/api/tasks/1/complete
```

**Delete a task**

Replace `1` with the ID of the task you want to delete:

```bash
curl -X DELETE http://localhost:8080/api/tasks/1
```

## 15. How the Application Works

The application follows this flow:

```
Web Browser
     ↓
HTML / CSS / JavaScript
     ↓
Spring Boot REST API
     ↓
RevisionTaskController
     ↓
RevisionTaskRepository
     ↓
Spring Data JPA / Hibernate
     ↓
MySQL Database
```

When a user adds a task:

1. The user enters a task on the webpage.
2. JavaScript sends a POST request to the REST API.
3. `RevisionTaskController` receives the request.
4. `RevisionTaskRepository` saves the task.
5. Hibernate sends the data to MySQL.
6. The task appears on the webpage.

## 16. Troubleshooting

### MySQL connection error

Check that:

- MySQL is running.
- The `revision_planner` database exists.
- Your MySQL username is correct.
- Your MySQL password is correct.
- `application.properties` is located in:

  ```
  src/main/resources/
  ```

### Port 8080 is already in use

If another application is using port 8080, change the port in `application.properties`:

```properties
server.port=8081
```

Then open:

```
http://localhost:8081
```

### The webpage does not load

Make sure Spring Boot is running and the console shows:

```
Tomcat started on port 8080
```

Then refresh:

```
http://localhost:8080
```

## 17. Stopping the Application

To stop the Spring Boot application in Eclipse, click the red **Terminate** button in the Console.

If you started it from Terminal, press:

```
Ctrl + C
```

The application will stop, but your tasks will remain in MySQL.

When you run the application again, your saved tasks will still be available.
