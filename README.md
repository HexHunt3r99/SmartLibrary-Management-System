# Smart Library Management System

A comprehensive web-based library management system built with Java Servlet/JSP, PostgreSQL, and HTML/CSS/JavaScript.

## Features

### Admin Features
- Dashboard with statistics overview
- Book management (add, edit, delete, search)
- User management
- Borrow records management
- Reservation management
- Fine management
- Reports generation

### User Features
- User dashboard
- Book search and browsing
- Borrow books
- Return books
- Make reservations
- View fine history
- Profile management

## Technology Stack

- **Backend**: Java Servlet/JSP
- **Database**: PostgreSQL
- **Frontend**: HTML, CSS, JavaScript
- **Server**: Apache Tomcat

## Database Setup

1. Create database named `demoo` in PostgreSQL
2. Configure DBConnection.java with your credentials:
   - URL: `jdbc:postgresql://localhost:5432/demoo`
   - Username: `postgres`
   - Password: `admin`
3. Run schema from `webapps/SmartLibrary/database/schema.sql`

## Default Credentials

- **Admin**: `admin` / `admin123`
- Run `AdminCreator.java` to create admin account

## Project Structure

```
SmartLibrary-Management-System/
├── src/main/java/com/smartlibrary/
│   ├── controller/          # Servlet controllers
│   │   ├── LoginServlet.java
│   │   ├── RegisterServlet.java
│   │   └── BookServlet.java
│   ├── model/              # Data models
│   │   ├── Book.java
│   │   ├── User.java
│   │   └── BorrowRecord.java
│   └── util/               # Utility classes
│       ├── DBConnection.java
│       └── AdminCreator.java
├── webapps/SmartLibrary/   # Web application
│   ├── admin/              # Admin pages
│   ├── user/               # User pages
│   ├── js/                 # JavaScript files
│   ├── css/                # Stylesheets
│   └── WEB-INF/            # Configuration
│       ├── web.xml
│       └── classes/
└── lib/                    # Libraries
```

## Compile & Run

```bash
# Compile servlets
javac -cp "lib/servlet-api.jar;lib/postgresql-jdbc.jar" -d webapps/SmartLibrary/WEB-INF/classes src/main/java/com/smartlibrary/util/DBConnection.java src/main/java/com/smartlibrary/controller/*.java

# Run AdminCreator to create admin
javac -cp "lib/postgresql-jdbc.jar;src/main/java" src/main/java/com/smartlibrary/util/AdminCreator.java
java -cp "lib/postgresql-jdbc.jar;src/main/java" com.smartlibrary.util.AdminCreator

# Test DB Connection
java -cp "lib/postgresql-jdbc.jar;src/main/java" com.smartlibrary.util.DBConnection
```

## Access Application

```
http://localhost:8080/SmartLibrary/
```

## License

This project is for educational purposes.
