<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cafe Connect - Where Coffee Meets Community</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #8B4513;
            --secondary-color: #D2691E;
            --cream: #FFF8DC;
            --dark-brown: #5D2C04;
            --light-brown: #CD853F;
            --accent-orange: #FF6B35;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            line-height: 1.6;
            color: #333;
        }

        /* Navbar Styling */
        .navbar {
            background: rgba(255, 255, 255, 0.97) !important;
            backdrop-filter: blur(10px);
            box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease;
            padding: 1rem 0;
        }

        .navbar-brand {
            font-weight: 800;
            font-size: 2rem;
            color: var(--primary-color) !important;
            display: flex;
            align-items: center;
            gap: 12px;
        }

        .coffee-icon {
            width: 45px;
            height: 45px;
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            box-shadow: 0 4px 15px rgba(139, 69, 19, 0.3);
        }

        .nav-link {
            font-weight: 500;
            color: var(--dark-brown) !important;
            margin: 0 0.5rem;
            transition: color 0.3s ease;
        }

        .nav-link:hover {
            color: var(--secondary-color) !important;
        }

        /* Hero Section */
        .hero-section {
            min-height: 100vh;
            background: linear-gradient(135deg, var(--primary-color) 0%, var(--secondary-color) 50%, var(--accent-orange) 100%);
            color: white;
            display: flex;
            align-items: center;
            position: relative;
            overflow: hidden;
        }

        .hero-section::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: url('data:image/svg+xml,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100"><circle cx="20" cy="20" r="2" fill="rgba(255,255,255,0.1)"/><circle cx="80" cy="40" r="1.5" fill="rgba(255,255,255,0.1)"/><circle cx="40" cy="80" r="1" fill="rgba(255,255,255,0.1)"/></svg>');
            animation: float 20s infinite linear;
        }

        @keyframes float {
            0% { transform: translateY(0) rotate(0deg); }
            100% { transform: translateY(-100vh) rotate(360deg); }
        }

        .hero-content {
            z-index: 2;
            position: relative;
        }

        .hero-title {
            font-size: 4rem;
            font-weight: 800;
            margin-bottom: 1rem;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
        }

        .hero-subtitle {
            font-size: 1.5rem;
            font-weight: 300;
            margin-bottom: 2rem;
            opacity: 0.9;
        }

        .btn-custom {
            padding: 15px 35px;
            border-radius: 50px;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: all 0.3s ease;
            border: none;
            text-decoration: none;
            display: inline-block;
        }

        .btn-primary-custom {
            background: #fff;
            color: var(--primary-color);
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
        }

        .btn-primary-custom:hover {
            transform: translateY(-3px);
            box-shadow: 0 12px 35px rgba(0,0,0,0.3);
            color: var(--primary-color);
        }

        .btn-outline-custom {
            border: 3px solid white;
            color: white;
            background: transparent;
        }

        .btn-outline-custom:hover {
            background: rgba(255,255,255,0.2);
            transform: translateY(-3px);
            color: white;
        }

        /* Features Section */
        .features-section {
            padding: 100px 0;
            background: var(--cream);
        }

        .section-title {
            font-size: 2.5rem;
            font-weight: 700;
            color: var(--primary-color);
            text-align: center;
            margin-bottom: 3rem;
        }

        .feature-card {
            background: white;
            border-radius: 20px;
            padding: 2rem;
            text-align: center;
            box-shadow: 0 10px 30px rgba(0,0,0,0.1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            height: 100%;
            border: none;
        }

        .feature-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 20px 40px rgba(0,0,0,0.15);
        }

        .feature-icon {
            width: 80px;
            height: 80px;
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 1.5rem;
            color: white;
            font-size: 2rem;
        }

        /* Partners Section */
        .partners-section {
            padding: 80px 0;
            background: white;
        }

        .partner-logo {
            height: 100px;
            background: white;
            border-radius: 15px;
            display: flex;
            align-items: center;
            justify-content: center;
            box-shadow: 0 5px 20px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
            margin: 1rem;
            padding: 1rem;
            border: 2px solid #f8f9fa;
        }

        .partner-logo:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 30px rgba(0,0,0,0.15);
        }

        .partner-logo img {
            max-height: 60px;
            max-width: 120px;
            object-fit: contain;
        }

        .partner-text {
            font-weight: 600;
            color: var(--primary-color);
            font-size: 1.2rem;
        }

        /* Stats Section */
        .stats-section {
            padding: 80px 0;
            background: linear-gradient(135deg, var(--dark-brown), var(--primary-color));
            color: white;
        }

        .stat-item {
            text-align: center;
            margin-bottom: 2rem;
        }

        .stat-number {
            font-size: 3rem;
            font-weight: 800;
            display: block;
            color: var(--cream);
        }

        .stat-label {
            font-size: 1.1rem;
            font-weight: 300;
            opacity: 0.9;
        }

        /* About Section */
        .about-section {
            padding: 100px 0;
            background: #f8f9fa;
        }

        .about-text {
            font-size: 1.1rem;
            line-height: 1.8;
            color: #666;
        }

        /* CTA Section */
        .cta-section {
            padding: 80px 0;
            background: linear-gradient(135deg, var(--secondary-color), var(--accent-orange));
            color: white;
            text-align: center;
        }

        .cta-title {
            font-size: 2.5rem;
            font-weight: 700;
            margin-bottom: 1rem;
        }

        /* Footer */
        .footer {
            background: var(--dark-brown);
            color: white;
            padding: 50px 0 30px;
        }

        .footer-brand {
            font-size: 1.5rem;
            font-weight: 700;
            margin-bottom: 1rem;
        }

        .footer-links {
            list-style: none;
            padding: 0;
        }

        .footer-links li {
            margin-bottom: 0.5rem;
        }

        .footer-links a {
            color: rgba(255,255,255,0.8);
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .footer-links a:hover {
            color: var(--cream);
        }

        .social-icons a {
            color: white;
            font-size: 1.5rem;
            margin: 0 10px;
            transition: color 0.3s ease;
        }

        .social-icons a:hover {
            color: var(--cream);
        }

        /* Animations */
        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .animate-fadeInUp {
            animation: fadeInUp 0.8s ease-out;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .hero-title {
                font-size: 2.5rem;
            }
            .hero-subtitle {
                font-size: 1.2rem;
            }
            .feature-card {
                margin-bottom: 2rem;
            }
        }

        /* Powered by section */
        .powered-by {
            background: var(--cream);
            padding: 40px 0;
            text-align: center;
            border-top: 3px solid var(--secondary-color);
        }

        .powered-text {
            font-size: 1.1rem;
            font-weight: 600;
            color: var(--primary-color);
            margin-bottom: 1rem;
        }

        .tech-badge {
            background: linear-gradient(135deg, var(--primary-color), var(--secondary-color));
            color: white;
            padding: 8px 20px;
            border-radius: 25px;
            font-weight: 600;
            display: inline-block;
            margin: 0 5px;
            box-shadow: 0 4px 15px rgba(139, 69, 19, 0.3);
        }
    </style>
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <div class="coffee-icon">
                <i class="fas fa-coffee"></i>
            </div>
            Cafe Connect
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#features">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#partners">Partners</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#about">About</a>
                </li>
                <li class="nav-item">
                    <a href="/login" class="btn btn-outline-custom btn-sm ms-2">
                        <i class="fas fa-sign-in-alt"></i> Login
                    </a>
                </li>
                <li class="nav-item">
                    <a href="/register" class="btn btn-primary-custom btn-sm ms-2">
                        <i class="fas fa-user-plus"></i> Sign Up
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Hero Section -->
<section class="hero-section" id="home">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 hero-content">
                <h1 class="hero-title animate-fadeInUp">Cafe Connect</h1>
                <p class="hero-subtitle animate-fadeInUp">Where Coffee Meets Community ☕</p>
                <p class="lead mb-4 animate-fadeInUp">
                    Discover amazing cafes, connect with fellow coffee lovers, and experience the perfect blend of technology and taste.
                </p>
                <div class="animate-fadeInUp">
                    <a href="/register" class="btn btn-primary-custom btn-custom me-3">
                        <i class="fas fa-rocket"></i> Get Started
                    </a>
                    <a href="/login" class="btn btn-outline-custom btn-custom">
                        <i class="fas fa-sign-in-alt"></i> Login
                    </a>
                </div>
            </div>
            <div class="col-lg-6 text-center">
                <div style="font-size: 15rem; opacity: 0.3;">
                    <i class="fas fa-coffee"></i>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Features Section -->
<section class="features-section" id="features">
    <div class="container">
        <h2 class="section-title">Why Choose Cafe Connect?</h2>
        <div class="row">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="feature-card">
                    <div class="feature-icon">
                        <i class="fas fa-map-marker-alt"></i>
                    </div>
                    <h4>Find Nearby Cafes</h4>
                    <p>Discover the best coffee spots in your area with our smart location-based recommendations.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="feature-card">
                    <div class="feature-icon">
                        <i class="fas fa-users"></i>
                    </div>
                    <h4>Community Reviews</h4>
                    <p>Read authentic reviews from fellow coffee enthusiasts and share your own experiences.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="feature-card">
                    <div class="feature-icon">
                        <i class="fas fa-mobile-alt"></i>
                    </div>
                    <h4>Easy Ordering</h4>
                    <p>Order ahead and skip the line with our seamless mobile ordering system.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="feature-card">
                    <div class="feature-icon">
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>Loyalty Rewards</h4>
                    <p>Earn points with every purchase and unlock exclusive rewards and discounts.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="feature-card">
                    <div class="feature-icon">
                        <i class="fas fa-calendar-alt"></i>
                    </div>
                    <h4>Events & Meetups</h4>
                    <p>Join coffee tastings, workshops, and community events happening near you.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="feature-card">
                    <div class="feature-icon">
                        <i class="fas fa-heart"></i>
                    </div>
                    <h4>Personalized Experience</h4>
                    <p>Get recommendations tailored to your taste preferences and coffee habits.</p>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Stats Section -->
<section class="stats-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="stat-item">
                    <span class="stat-number">50K+</span>
                    <span class="stat-label">Happy Customers</span>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="stat-item">
                    <span class="stat-number">200+</span>
                    <span class="stat-label">Partner Cafes</span>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="stat-item">
                    <span class="stat-number">1M+</span>
                    <span class="stat-label">Orders Delivered</span>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="stat-item">
                    <span class="stat-number">4.9★</span>
                    <span class="stat-label">Average Rating</span>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Partners Section -->
<section class="partners-section" id="partners">
    <div class="container">
        <h2 class="section-title">Our Trusted Partners</h2>
        <p class="text-center mb-5 text-muted">Working with the best in the industry to bring you exceptional service</p>
        <div class="row justify-content-center align-items-center">
            <div class="col-lg-2 col-md-4 col-6">
                <div class="partner-logo">
                    <div class="partner-text">
                        <i class="fas fa-utensils"></i><br>
                        <small>Ajay Canteen</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-6">
                <div class="partner-logo">
                    <div class="partner-text">
                        <i class="fas fa-fire"></i><br>
                        <small>Mayuri Kitchen</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-6">
                <div class="partner-logo">
                    <div class="partner-text" style="color: #FF6600;">
                        <i class="fas fa-motorcycle"></i><br>
                        <small>Swiggy</small>
                    </div>
                </div>
            </div>
            <div class="col-lg-2 col-md-4 col-6">
                <div class="partner-logo">
                    <div class="partner-text" style="color: #E23744;">
                        <i class="fas fa-hamburger"></i><br>
                        <small>Zomato</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- About Section -->
<section class="about-section" id="about">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6">
                <h2 class="section-title text-start">About Cafe Connect</h2>
                <p class="about-text">
                    Cafe Connect is more than just a platform – it's a revolution in how people discover, experience, and connect through coffee. We bridge the gap between coffee lovers and exceptional cafes, creating a vibrant community where every cup tells a story.
                </p>
                <p class="about-text">
                    Our mission is to transform the coffee experience by leveraging cutting-edge technology to connect passionate coffee enthusiasts with their perfect brew, while supporting local businesses and fostering meaningful community connections.
                </p>
                <div class="mt-4">
                    <a href="/register" class="btn btn-primary-custom btn-custom">
                        <i class="fas fa-arrow-right"></i> Join Our Community
                    </a>
                </div>
            </div>
            <div class="col-lg-6 text-center">
                <div style="font-size: 12rem; color: var(--secondary-color); opacity: 0.7;">
                    <i class="fas fa-users"></i>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Call to Action Section -->
<section class="cta-section">
    <div class="container text-center">
        <h2 class="cta-title">Ready to Start Your Coffee Journey?</h2>
        <p class="lead mb-4">Join thousands of coffee lovers who have already discovered their perfect cup.</p>
        <a href="/register" class="btn btn-primary-custom btn-custom me-3">
            <i class="fas fa-rocket"></i> Get Started Now
        </a>
        <a href="/login" class="btn btn-outline-custom btn-custom">
            <i class="fas fa-sign-in-alt"></i> Sign In
        </a>
    </div>
</section>

<!-- Powered By Section -->
<section class="powered-by">
    <div class="container">
        <p class="powered-text">Powered By</p>
        <div>
            <span class="tech-badge">
                <i class="fas fa-code"></i> Yash Technology
            </span>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 mb-4">
                <div class="footer-brand">
                    <i class="fas fa-coffee me-2"></i>
                    Cafe Connect
                </div>
                <p class="text-light">Connecting coffee lovers with exceptional experiences, one cup at a time.</p>
                <div class="social-icons mt-3">
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-linkedin"></i></a>
                </div>
            </div>
            <div class="col-lg-2 col-md-6 mb-4">
                <h5>Quick Links</h5>
                <ul class="footer-links">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="#features">Features</a></li>
                    <li><a href="#partners">Partners</a></li>
                    <li><a href="#about">About</a></li>
                </ul>
            </div>
            <div class="col-lg-2 col-md-6 mb-4">
                <h5>Account</h5>
                <ul class="footer-links">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Sign Up</a></li>
                </ul>
            </div>
            <div class="col-lg-2 col-md-6 mb-4">
                <h5>Support</h5>
                <ul class="footer-links">
                    <li><a href="help.jsp">Help Center</a></li>
                    <li><a href="contact.jsp">Contact Us</a></li>
                    <li><a href="faq.jsp">FAQ</a></li>
                    <li><a href="/feedback">Feedback</a></li>
                </ul>
            </div>
            <div class="col-lg-2 col-md-6 mb-4">
                <h5>Legal</h5>
                <ul class="footer-links">
                    <li><a href="privacy.jsp">Privacy Policy</a></li>
                    <li><a href="terms.jsp">Terms of Service</a></li>
                </ul>
            </div>
        </div>
        <hr class="my-4" style="border-color: rgba(255,255,255,0.3);">
        <div class="row align-items-center">
            <div class="col-md-6">
                <p class="mb-0">&copy; 2025 Cafe Connect. All rights reserved.</p>
            </div>
            <div class="col-md-6 text-md-end">
                <p class="mb-0">
                    <i class="fas fa-code"></i> Developed with ❤️ by Yash Technology
                </p>
            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>

<!-- Custom JavaScript -->
<script>
    // Smooth scrolling for navigation links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });

    // Navbar background change on scroll
    window.addEventListener('scroll', function() {
        const navbar = document.querySelector('.navbar');
        if (window.scrollY > 50) {
            navbar.style.background = 'rgba(255, 255, 255, 0.98)';
            navbar.style.boxShadow = '0 4px 30px rgba(0, 0, 0, 0.15)';
        } else {
            navbar.style.background = 'rgba(255, 255, 255, 0.97)';
            navbar.style.boxShadow = '0 2px 20px rgba(0, 0, 0, 0.1)';
        }
    });

    // Animate stats on scroll
    function animateStats() {
        const statNumbers = document.querySelectorAll('.stat-number');
        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const target = entry.target;
                    const finalValue = target.textContent;
                    const numericValue = parseInt(finalValue.replace(/[^\d]/g, ''));

                    if (!isNaN(numericValue)) {
                        let current = 0;
                        const increment = numericValue / 50;
                        const timer = setInterval(() => {
                            current += increment;
                            if (current >= numericValue) {
                                target.textContent = finalValue;
                                clearInterval(timer);
                            } else {
                                target.textContent = Math.floor(current) + (finalValue.includes('K') ? 'K+' : finalValue.includes('M') ? 'M+' : finalValue.includes('★') ? '★' : '+');
                            }
                        }, 50);
                    }
                    observer.unobserve(target);
                }
            });
        });

        statNumbers.forEach(stat => observer.observe(stat));
    }

    // Initialize animations when DOM is loaded
    document.addEventListener('DOMContentLoaded', function() {
        animateStats();

        // Add fade-in animation to feature cards
        const observerOptions = {
            threshold: 0.1,
            rootMargin: '0px 0px -50px 0px'
        };

        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.style.opacity = '1';
                    entry.target.style.transform = 'translateY(0)';
                }
            });
        }, observerOptions);

        document.querySelectorAll('.feature-card').forEach(card => {
            card.style.opacity = '0';
            card.style.transform = 'translateY(20px)';
            card.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
            observer.observe(card);
        });
    });
</script>

</body>
</html>