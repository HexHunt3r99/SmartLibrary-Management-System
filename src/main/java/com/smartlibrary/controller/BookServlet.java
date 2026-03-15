package com.smartlibrary;

import com.smartlibrary.util.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";
        }
        
        switch (action) {
            case "search":
                searchBooks(request, response);
                break;
            case "view":
                viewBook(request, response);
                break;
            case "list":
            default:
                listBooks(request, response);
                break;
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            response.sendRedirect("books");
            return;
        }
        
        switch (action) {
            case "add":
                addBook(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            default:
                response.sendRedirect("books");
                break;
        }
    }
    
    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sql = "SELECT * FROM books ORDER BY title";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            request.setAttribute("books", rs);
            request.getRequestDispatcher("/admin/books.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("error", "Error loading books: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    private void searchBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchTerm = request.getParameter("query");
        String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR isbn LIKE ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            String term = "%" + searchTerm + "%";
            stmt.setString(1, term);
            stmt.setString(2, term);
            stmt.setString(3, term);
            
            try (ResultSet rs = stmt.executeQuery()) {
                request.setAttribute("books", rs);
                request.setAttribute("searchTerm", searchTerm);
                request.getRequestDispatcher("/user/books.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Error searching books: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    private void viewBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        String sql = "SELECT * FROM books WHERE book_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, bookId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    request.setAttribute("book", rs);
                    request.getRequestDispatcher("/book-details.jsp").forward(request, response);
                } else {
                    response.sendRedirect("books?error=notfound");
                }
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Error loading book: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
    
    private void addBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            response.sendRedirect("login");
            return;
        }
        
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        int publishYear = Integer.parseInt(request.getParameter("publish_year"));
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        String sql = "INSERT INTO books (isbn, title, author, publisher, publish_year, category, description, quantity, available) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, isbn);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, publisher);
            stmt.setInt(5, publishYear);
            stmt.setString(6, category);
            stmt.setString(7, description);
            stmt.setInt(8, quantity);
            stmt.setInt(9, quantity);
            
            stmt.executeUpdate();
            response.sendRedirect("books?success=added");
        } catch (SQLException e) {
            request.setAttribute("error", "Error adding book: " + e.getMessage());
            request.getRequestDispatcher("/admin/add-book.jsp").forward(request, response);
        }
    }
    
    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            response.sendRedirect("login");
            return;
        }
        
        int bookId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        int publishYear = Integer.parseInt(request.getParameter("publish_year"));
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, publish_year = ?, category = ?, description = ?, quantity = ?, updated_at = CURRENT_TIMESTAMP WHERE book_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, publisher);
            stmt.setInt(4, publishYear);
            stmt.setString(5, category);
            stmt.setString(6, description);
            stmt.setInt(7, quantity);
            stmt.setInt(8, bookId);
            
            stmt.executeUpdate();
            response.sendRedirect("books?success=updated");
        } catch (SQLException e) {
            request.setAttribute("error", "Error updating book: " + e.getMessage());
            response.sendRedirect("books?error=updatefailed");
        }
    }
    
    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String role = (String) session.getAttribute("role");
        if (role == null || !role.equals("admin")) {
            response.sendRedirect("login");
            return;
        }
        
        int bookId = Integer.parseInt(request.getParameter("id"));
        String sql = "DELETE FROM books WHERE book_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, bookId);
            stmt.executeUpdate();
            response.sendRedirect("books?success=deleted");
        } catch (SQLException e) {
            request.setAttribute("error", "Error deleting book: " + e.getMessage());
            response.sendRedirect("books?error=deletefailed");
        }
    }
}
