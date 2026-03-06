# SmartLibrary - Web Application

## Overview
SmartLibrary is a comprehensive library management system designed for educational institutions. It provides a modern, intuitive platform for managing books, user accounts, borrowing/returning, reservations, and fines.

## Technology Stack
- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **Backend**: Java Servlet/JSP
- **Database**: PostgreSQL
- **Server**: Apache Tomcat

## Project Structure
```
SmartLibrary/
├── index.html          # Landing page
├── login.html          # User login
├── register.html       # User registration
├── css/                # External CSS files
│   ├── index.css
│   ├── login.css
│   └── register.css
├── user/               # User module
│   ├── dashboard.html
│   ├── books.html
│   ├── borrows.html
│   ├── reservations.html
│   ├── fines.html
│   ├── profile.html
│   ├── reports.html
│   ├── help.html
│   ├── css/            # User CSS files
│   └── js/             # User JS files (if needed)
├── admin/              # Admin module
│   ├── dashboard.html
│   ├── books.html
│   ├── users.html
│   ├── borrows.html
│   ├── reservations.html
│   ├── fines.html
│   ├── css/            # Admin CSS files
│   └── js/             # Admin JS files
├── WEB-INF/
│   ├── classes/        # Java servlets & db.properties
│   └── lib/            # Libraries (PostgreSQL JDBC driver)
```

## Features

### Landing Page (index.html)
- Animated counter showing 10,000+ books, 5,000+ users, 50,000+ borrows
- Smooth scroll navigation
- Hero section with CTA buttons
- Features section with hover effects
- How It Works (3-step flow)
- Call to action section
- Footer with contact info

### User Features
- Browse and search books
- Borrow and return books
- Reserve unavailable books
- View and pay fines
- Track borrowing history (reports)
- Profile management
- Help section

### Admin Features
- Full book inventory management
- User account management
- Borrowing/returning oversight
- Reservation management
- Fine management
- Reports and analytics

## Running the Application

1. Deploy to Apache Tomcat:
   - Copy the SmartLibrary folder to `webapps/` directory
   - Start Tomcat server

2. Access the application:
   - Landing page: `http://localhost:8080/SmartLibrary/`
   - User login: `http://localhost:8080/SmartLibrary/login.html`

## Database Configuration

Database connection is configured in `WEB-INF/classes/db.properties`:
- **Database**: PostgreSQL
- **URL**: `jdbc:postgresql://localhost:5432/smartlibrary`
- **JDBC Driver**: `postgresql-42.7.1.jar` (in `WEB-INF/lib/`)

## Design System
- **Primary Color**: Blue (#2563EB → #1D4ED8)
- **Font**: Inter (Google Fonts)
- **Border Radius**: 10-16px
- **Layout**: Sidebar navigation (260px), main content area
- **Responsive**: Mobile-friendly breakpoints

## CSS/JS Architecture
All inline styles and scripts have been extracted to external files:
- Root pages: `css/*.css`
- Admin pages: `admin/css/*.css`, `admin/js/*.js`
- User pages: `user/css/*.css`, `user/js/*.js`

## License
© 2026 SmartLibrary. All rights reserved.
