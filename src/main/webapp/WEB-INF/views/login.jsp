<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cafe Connect - Login</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #8B4513;
            --secondary-color: #D2691E;
            --cream: #FFF8DC;
        }
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            min-height: 100vh;
            display: flex; align-items: center; justify-content: center;
        }
        .card {
            border-radius: 20px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.2);
        }
        .btn-custom {
            padding: 12px 30px; border-radius: 50px;
            font-weight: 600; text-transform: uppercase;
        }
        .btn-primary-custom {
            background: linear-gradient(45deg, var(--primary-color), var(--secondary-color));
            color: #fff; border: none;
        }
        .btn-primary-custom:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card p-4" style="max-width: 450px; margin: auto;">
        <h3 class="text-center mb-4">
            <i class="fas fa-coffee me-2"></i> Cafe Connect Login
        </h3>

        <!-- Show error -->
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center">${error}</div>
        </c:if>

        <form action="login" method="post">
            <div class="mb-3">
                <label for="email" class="form-label"><i class="fas fa-envelope me-1"></i>Email</label>
                <input type="email" class="form-control" id="email" name="username" placeholder="Enter email" required>
            </div>

            <div class="mb-4">
                <label for="password" class="form-label"><i class="fas fa-lock me-1"></i>Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
            </div>

            <div class="d-grid mb-3">
                <button type="submit" class="btn btn-primary-custom btn-custom">
                    <i class="fas fa-sign-in-alt me-1"></i> Login
                </button>
            </div>

            <div class="text-center">
                <p class="mb-0">New here? <a href="register.jsp" style="color: var(--primary-color); font-weight: 600;">Create Account</a></p>
            </div>
        </form>
    </div>
</div>

</body>
</html>
