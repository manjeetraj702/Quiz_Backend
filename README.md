

# Quiz Creation and Participation System Backend

## Overview
This Spring Boot backend enables:
- **User Authentication** with role-based access for Admins (create/manage quizzes) and Students (view/attempt quizzes).
- **Quiz Management** for Admins: Create quizzes, add questions, and set correct answers.
- **Quiz Participation** for Students: View available quizzes, attempt them, and see results.

## Key Endpoints
- **Auth**: `/api/auth/login` (POST), `/api/auth/logout` (POST)
- **Admin**: `/api/quizzes` (POST/PUT/DELETE), `/api/quizzes/{quizId}/questions` (POST)
- **Student**: `/api/quizzes` (GET), `/api/quizzes/{quizId}/attempt` (POST), `/api/quizzes/{quizId}/results` (GET)

## Features
1. **Admin Functionalities**:
    - Create, update, and delete quizzes.
    - Add multiple-choice questions and designate correct answers.

2. **Student Functionalities**:
    - View and attempt available quizzes.
    - View results and review answers after submission.

3. **Notifications**:
    - Optional quiz completion and new quiz notifications.

## Testing
Use [Swagger UI](http://localhost:8080/swagger-ui.html) for API testing and documentation.

--- 
