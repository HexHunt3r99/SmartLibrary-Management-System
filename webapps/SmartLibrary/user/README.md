# SmartLibrary - User Module

## Overview
The User Module provides students and faculty with access to library services including book browsing, borrowing, reservations, and profile management.

## Pages

| File | Description |
|------|-------------|
| dashboard.html | User dashboard with stats overview |
| books.html | Browse and search library books |
| borrows.html | View currently borrowed books |
| reservations.html | View active reservations |
| fines.html | View and pay fines |
| profile.html | User profile settings |
| reports.html | Borrowing history and fine summary |
| help.html | Help and support |

## Features

### Dashboard
- Overview statistics (borrowed books, fines, reservations)
- Recently borrowed books
- Recommended books
- Notifications

### Book Management
- Search books by title, author, ISBN
- Filter by category, availability
- View book details
- Borrow available books
- Reserve unavailable books

### Borrowing
- View active borrows
- Renew books (if allowed)
- Return books
- View borrowing history

### Reservations
- View active reservations
- Queue position tracking
- Cancel reservations

### Fines
- View outstanding fines
- Fine payment history
- Pay fines online

### Reports
- Total books borrowed
- Returned on time / late returns
- Fine payment history
- Export functionality

### Profile
- Update personal information
- Change password
- View login activity

### Help
- FAQ section
- Contact support information

## Usage
Navigate through the sidebar menu to access different features. The dashboard provides quick access to all main functions.

## Design
- Clean, modern interface
- Card-based layout
- Status badges for book availability
- Responsive design for all devices

## CSS Architecture
Inline styles have been extracted to external CSS files:
- `css/dashboard.css`
- `css/books.css`
- `css/borrows.css`
- `css/reservations.css`
- `css/fines.css`
- `css/profile.css`
- `css/reports.css`
- `css/help.css`
