# Quiz App

This is a simple Quiz App built with **Spring Boot** and **H2 Database**. It allows users to start a quiz session, get random multiple-choice questions, submit answers, and track the performance of each user (correct and incorrect answers).

## Features
Use postman or any other api testing tool.
- **Start a new quiz session**: Begin a new quiz session for the user.
  ```bash
  POST /quiz/start?username=Anmol
  ```
- **Random Questions**: Get a random multiple-choice question from the database.
  ```bash
  GET /quiz/question
  ```
- **Submit Answers**: Submit answers to questions and track if the answers are correct.
   ```bash
  POST /quiz/answer?sessionId=1&questionId=1&answer=4
  ```
- **Track Performance**: View the total questions answered, with details on correct and incorrect submissions.
   ```bash
    GET /quiz/status?username=Anmol
   ```

## Setup and Installation

### 1. Clone the Repository

```bash
git clone [https://github.com/your-username/quiz-app.git](https://github.com/withwit/mockmcq.git)
cd mockmcq
```

### 2. Build the Project using Maven

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Access the H2 Console (Optional)

If you want to view or query the H2 in-memory database, you can enable the H2 console in your browser:

* Go to http://localhost:8080/h2-console
* Use the following connection details:
  ```bash
  JDBC URL: jdbc:h2:mem:questions
  Username: sa
  Password: 
  ```

