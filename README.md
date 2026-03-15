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

## Database Schema

The system uses the following main tables:
- `users` - User accounts (admin and regular users)
- `books` - Book inventory
- `borrows` - Borrow records
- `reservations` - Book reservations
- `fines` - Fine records
- `categories` - Book categories
- `stats` - System statistics

## Installation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Tomcat 9+
- PostgreSQL 13+

### Database Setup

1. Create a PostgreSQL database named `smartlibrary`
2. Run the schema SQL file located at:
   ```
   webapps/SmartLibrary/database/schema.sql
   ```
3. Configure database connection in:
   ```
   webapps/SmartLibrary/WEB-INF/classes/db.properties
   ```

### Deployment

1. Build the project or use the pre-built WAR file
2. Deploy to Apache Tomcat webapps directory
3. Start Tomcat server
4. Access the application at `http://localhost:8080/SmartLibrary/`

## Default Credentials

- **Admin**: `admin` / `admin123`
- **Librarian**: Create through admin panel

## Project Structure

```
SmartLibrary-Management-System/
├── src/main/java/com/smartlibrary/     # Java source files
│   ├── Login.java
│   ├── Register.java
│   ├── Dashboard.java
│   ├── Book.java
│   ├── User.java
│   ├── Member.java
│   ├── Librarian.java
│   ├── AddBook.java
│   ├── RemoveBook.java
│   ├── SearchBook.java
│   ├── BorrowBook.java
│   ├── ReturnBook.java
│   └── BorrowRecord.java
├── webapps/SmartLibrary/               # Web application
│   ├── admin/                          # Admin pages
│   ├── user/                           # User pages
│   ├── database/                       # SQL scripts
│   ├── WEB-INF/                        # Configuration
│   └── css/, js/                       # Static resources
└── conf/                               # Tomcat configuration
```

## Configuration

### Database Configuration

Edit `webapps/SmartLibrary/WEB-INF/classes/db.properties`:
```properties
db.url=jdbc:postgresql://localhost:5432/smartlibrary
db.username=postgres
db.password=yourpassword
```

### Tomcat Configuration

Edit `conf/server.xml` to modify port settings (default: 8080).

## Usage

1. **Login**: Access the login page and enter credentials
2. **Admin**: Manage books, users, and view reports
3. **Users**: Search books, borrow/return, manage reservations

## License

This project is for educational purposes.
