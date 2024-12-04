package org.example.librarymanagementsystem.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.librarymanagementsystem.Models.Book;
import org.example.librarymanagementsystem.HelloApplication;
import org.example.librarymanagementsystem.dao.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibraryController {

    @FXML
    private GridPane booksContainer;

    @FXML
    private ImageView bannerImageView;

    @FXML
    private GridPane booksGrid;

    @FXML
    private VBox searchResultsBox;

    @FXML
    private Button bestsellerButton;

    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    @FXML
    private TextField searchField;

    @FXML
    private VBox contentBox; // Контейнер для отображения результатов

    private ObservableList<Book> filteredList = FXCollections.observableArrayList();

    @FXML
    private Button searchButton; // Кнопка-кружок

    @FXML
    private void onSearchButtonClick() {
        System.out.println("Кнопка нажата");
        String searchText = searchField.getText().trim();
        System.out.println("Текст поиска: " + searchText);

        if (!searchText.isEmpty()) {
            Book foundBook = searchBookByName(searchText);
            if (foundBook != null) {
                System.out.println("Книга найдена: " + foundBook.getName());
                displaySearchResult(foundBook);
            } else {
                System.out.println("Книга не найдена");
                displayNoResult();
            }
        } else {
            System.out.println("Поле поиска пустое");
            displayDefaultContent();
        }
    }

    @FXML
    public void initialize() {
        categoryChoiceBox.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");

        // Добавляем категории
        categoryChoiceBox.getItems().addAll("Romance novel", "Fantasy", "Adventure fiction", "Horror");

        // Устанавливаем начальное значение
        categoryChoiceBox.setValue("Category");

        // Добавляем обработчик выбора
        categoryChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switchToCategoryPage(newValue);
            }
        });

        // Обработка нажатия Enter в поле поиска
        searchField.setOnAction(event -> onSearch());

        // Слушатель изменений в поле поиска
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                // Если поле поиска пустое, восстанавливаем GridPane
                displayDefaultContent();
            } else {
                // Если идет ввод, выполняем поиск
                booksContainer.setVisible(false); // Скрываем GridPane
                onSearch(); // Запускаем поиск
            }
        });
    }

    private void switchToCategoryPage(String category) {
        try {
            Stage stage = (Stage) categoryChoiceBox.getScene().getWindow();

            // Загружаем FXML-файл для выбранной категории
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/librarymanagementsystem/view/Fantasy.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 1000);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void switchToBestseller() throws IOException {
        Stage stage = (Stage) bestsellerButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/librarymanagementsystem/view/bestseller-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 1000);
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

    @FXML
    private Button blogbutton;

    @FXML
    void switchToBlog() throws IOException {
        Stage stage = (Stage) blogbutton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/librarymanagementsystem/view/blog.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 800, 1000);
            stage.setTitle("Hello!");
            stage.setScene(scene);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    private Button HomeButton;

    @FXML
    void switchToHome() throws IOException {
        Stage stage = (Stage) HomeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/org/example/librarymanagementsystem/view/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 1000);
        stage.setTitle("Hello!");
        stage.setScene(scene);
    }

    // Метод поиска
    private void onSearch() {
        String searchText = searchField.getText().trim();
        if (searchText.isEmpty()) {
            displayDefaultContent(); // Вернуть содержимое по умолчанию
            return;
        }
        Book foundBook = searchBookByName(searchText);
        if (foundBook != null) {
            displaySearchResult(foundBook);
        } else {
            displayNoResult();
        }
    }

    private void displayNoResult() {
        // Скрыть GridPane
        booksGrid.setVisible(false);
        booksGrid.setManaged(false);

        // Показать VBox с сообщением о результате
        searchResultsBox.setVisible(true);
        searchResultsBox.setManaged(true);

        searchResultsBox.getChildren().clear();
        Label noResultLabel = new Label("Книга не найдена.");
        noResultLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: red;");
        searchResultsBox.getChildren().add(noResultLabel);
    }

    // Запрос к базе данных для поиска книги
    private Book searchBookByName(String name) {
        String query = "SELECT name, author FROM public.book WHERE name ILIKE ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String bookName = resultSet.getString("name");
                String author = resultSet.getString("author");
                return new Book(bookName, author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    private void displayDefaultContent() {
//        // Показать GridPane с популярными книгами
//        booksGrid.setVisible(true);
//        booksGrid.setManaged(true);
//
//        // Скрыть VBox с результатами поиска
//        searchResultsBox.setVisible(false);
//        searchResultsBox.setManaged(false);
//    }

    // Метод для отображения результатов поиска
    private void displaySearchResult(Book book) {
        // Скрыть GridPane с популярными книгами
        booksGrid.setVisible(false);
        booksGrid.setManaged(false);

        // Показать VBox с результатами поиска
        searchResultsBox.setVisible(true);
        searchResultsBox.setManaged(true);

        // Очистить старые результаты
        searchResultsBox.getChildren().clear();

        // Создаем элементы для отображения результатов
        Label nameLabel = new Label("Название: " + book.getName());
        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label authorLabel = new Label("Автор: " + book.getAuthor());
        authorLabel.setStyle("-fx-font-size: 16px;");

        // Добавляем обработчик клика
        nameLabel.setOnMouseClicked(event -> openBookDetailsPage(book));

        // Добавляем элементы в VBox
        searchResultsBox.getChildren().addAll(nameLabel, authorLabel);
    }

    private void openBookDetailsPage(Book book) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/librarymanagementsystem/view/BookDetails.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));

            // Получаем контроллер новой страницы
            BookDetailsController1 controller = loader.getController();
            controller.setBookDetails(book.getName(), book.getAuthor(), "Здесь будет описание книги.");

            // Передаем текущую сцену как предыдущую
            controller.setPreviousStage((Stage) searchResultsBox.getScene().getWindow());

            // Показываем новую сцену
            stage.show();

            // Скрываем текущую сцену (не закрываем)
            searchResultsBox.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void displayDefaultContent() {
        // Включаем видимость GridPane
        booksContainer.setVisible(true);

        // Если нужно, можете добавить код для очистки и перезагрузки данных
        // например, booksContainer.getChildren().clear();
        // и последующего заполнения элементами.
    }
}