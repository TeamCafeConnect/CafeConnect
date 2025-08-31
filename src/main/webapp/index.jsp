<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cafe Connect - Where Coffee Meets Community</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        /* 🎨 Reuse theme variables */
        :root {
            --primary-color: #8B4513;
            --secondary-color: #D2691E;
            --cream: #FFF8DC;
        }
        body {
            font-family: 'Poppins', sans-serif;
        }
        .navbar {
            background: rgba(255, 255, 255, 0.95) !important;
            box-shadow: 0 2px 20px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand {
            font-weight: 700;
            font-size: 1.8rem;
            color: var(--primary-color) !important;
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .coffee-icon {
            width: 40px; height: 40px;
            background: linear-gradient(45deg, var(--primary-color), var(--secondary-color));
            border-radius: 50%;
            display: flex; align-items: center; justify-content: center;
            color: white;
        }
        .hero-section {
            min-height: 100vh;
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            color: white;
            display: flex; align-items: center;
        }
        .hero-title {
            font-size: 3.5rem; font-weight: 700;
        }
        .btn-custom {
            padding: 12px 30px; border-radius: 50px;
            font-weight: 600; text-transform: uppercase;
        }
        .btn-primary-custom {
            background: #fff; color: var(--primary-color);
        }
        .btn-outline-custom {
            border: 2px solid white; color: white;
        }
        .btn-outline-custom:hover {
            background: rgba(255,255,255,0.2);
        }
    </style>
</head>
<body>

<!-- 🌟 Navbar -->
<nav class="navbar navbar-expand-lg fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <div class="coffee-icon"><i class="fas fa-coffee"></i></div>
            Cafe Connect
        </a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#features">Features</a></li>
                <li class="nav-item">
                    <a href="login.jsp" class="btn btn-outline-custom btn-sm ms-2">
                        <i class="fas fa-sign-in-alt"></i> Login
                    </a>
                </li>
                <li class="nav-item">
                    <a href="register.jsp" class="btn btn-primary-custom btn-sm ms-2">
                        <i class="fas fa-user-plus"></i> Sign Up
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- 🌟 Hero Section -->
<section class="hero-section">
    <div class="container text-center">
        <h1 class="hero-title">Cafe Connect</h1>
        <p class="lead">Where Coffee Meets Community ☕</p>
        <a href="register.jsp" class="btn btn-primary-custom btn-custom me-2">
            <i class="fas fa-rocket"></i> Get Started
        </a>
        <a href="login.jsp" class="btn btn-outline-custom btn-custom">
            <i class="fas fa-sign-in-alt"></i> Login
        </a>
    </div>
</section>

<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
