# SmartLibrary - Admin Module

## Overview
The Admin Module provides librarians and administrators with comprehensive tools to manage the entire library system.

## Pages

| File | Description |
|------|-------------|
| dashboard.html | Admin dashboard with analytics |
| books.html | Manage library book inventory |
| users.html | Manage user accounts |
| borrows.html | Manage all borrowings |
| reservations.html | Manage reservations |
| fines.html | Manage fines |

## Features

### Dashboard
- Library statistics overview
- Total books, users, active borrows
- Borrowing Trends chart
- Category Distribution chart
- Recent activities
- Quick action buttons

### Book Management
- Add new books
- Edit book details
- Delete books
- Bulk import/export
- Category management

### User Management
- View all users
- Add new users
- Edit user details
- Deactivate/activate accounts
- View user borrowing history

### Borrowing Management
- View all active borrows
- Manual borrow/return
- Overdue notifications
- Extend borrowing periods

### Reservation Management
- View all reservations
- Approve/cancel reservations
- Manage queue positions

### Fine Management
- View all fines
- Waive fines
- Payment tracking
- Generate fine reports

## Design
- Professional admin interface
- Data tables with sorting/filtering
- Charts and graphs for analytics
- Quick action modals
- Responsive layout

## CSS/JS Architecture
Inline styles have been extracted to external CSS files:
- `css/dashboard.css`
- `css/books.css`
- `css/users.css`
- `css/borrows.css`
- `css/reservations.css`
- `css/fines.css`

Inline JavaScript has been extracted to external JS files:
- `js/dashboard.js`

## Usage
Access through the admin sidebar. Use the dashboard for quick overview and navigation to specific management sections.
