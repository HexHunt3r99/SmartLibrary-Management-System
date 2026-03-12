-- USERS TABLE
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    role VARCHAR(20) DEFAULT 'user',
    status VARCHAR(20) DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- INSERT INTO users (username, password, email, full_name, phone, role) VALUES ('admin', 'admin123', 'admin@smartlibrary.com', 'Administrator', '1234567890', 'admin');

-- BOOKS TABLE
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    isbn VARCHAR(20) UNIQUE,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100) NOT NULL,
    publisher VARCHAR(100),
    publish_year INTEGER,
    category VARCHAR(50),
    description TEXT,
    quantity INTEGER DEFAULT 1,
    available INTEGER DEFAULT 1,
    cover_image VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- INSERT INTO books (isbn, title, author, publisher, publish_year, category, quantity, available) VALUES ('978-0-13-468599-1', 'The Great Gatsby', 'F. Scott Fitzgerald', 'Scribner', 1925, 'Fiction', 5, 5);

-- BORROWS TABLE
CREATE TABLE borrows (
    borrow_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE,
    book_id INTEGER REFERENCES books(book_id) ON DELETE CASCADE,
    borrow_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    due_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP,
    status VARCHAR(20) DEFAULT 'borrowed',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- INSERT INTO borrows (user_id, book_id, due_date, status) VALUES (1, 1, CURRENT_TIMESTAMP + INTERVAL '14 days', 'borrowed');

-- RESERVATIONS TABLE
CREATE TABLE reservations (
    reservation_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE,
    book_id INTEGER REFERENCES books(book_id) ON DELETE CASCADE,
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expiration_date TIMESTAMP NOT NULL,
    status VARCHAR(20) DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- INSERT INTO reservations (user_id, book_id, expiration_date, status) VALUES (1, 1, CURRENT_TIMESTAMP + INTERVAL '3 days', 'active');

-- FINES TABLE
CREATE TABLE fines (
    fine_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(user_id) ON DELETE CASCADE,
    borrow_id INTEGER REFERENCES borrows(borrow_id) ON DELETE CASCADE,
    amount DECIMAL(10,2) NOT NULL,
    reason VARCHAR(255),
    status VARCHAR(20) DEFAULT 'unpaid',
    paid_date TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- INSERT INTO fines (user_id, borrow_id, amount, reason, status) VALUES (1, 1, 5.00, 'Late return', 'unpaid');

-- CATEGORIES TABLE
CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- INSERT INTO categories (name, description) VALUES ('Fiction', 'Fiction books');

-- STATS TABLE
CREATE TABLE stats (
    stat_id SERIAL PRIMARY KEY,
    total_books INTEGER DEFAULT 0,
    total_users INTEGER DEFAULT 0,
    total_borrows INTEGER DEFAULT 0,
    total_fines DECIMAL(10,2) DEFAULT 0,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- INSERT INTO stats (total_books, total_users, total_borrows, total_fines) VALUES (0, 0, 0, 0);
