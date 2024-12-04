package org.example.librarymanagementsystem.dao;

import org.example.librarymanagementsystem.Models.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    // Метод для получения всех книг из базы данных
    public Book searchBookByName(String name) {
        String query = "SELECT name, author FROM public.book WHERE name ILIKE ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String bookName = resultSet.getString("name");
                String author = resultSet.getString("author");
                return new Book(bookName, author); // Убедитесь, что здесь используется ваш класс Book
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}