package org.example.librarymanagementsystem.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BookDetailsController1 {

    @FXML
    private Label bookTitleLabel;

    @FXML
    private Label bookAuthorLabel;

    @FXML
    private Label bookDescriptionLabel;

    private Stage previousStage;

    // Устанавливаем данные о книге
    public void setBookDetails(String title, String author, String description) {
        bookTitleLabel.setText("Название: " + title);
        bookAuthorLabel.setText("Автор: " + author);
        bookDescriptionLabel.setText("Описание: " + description);
    }

    // Обработка кнопки "Back"
    @FXML
    private void goBack() {
        System.out.println("Кнопка 'Back' нажата");

        // Закрываем текущее окно
        Stage currentStage = (Stage) bookTitleLabel.getScene().getWindow();
        currentStage.close();

        // Отображаем предыдущую сцену
        if (previousStage != null) {
            System.out.println("Возвращаемся к предыдущей сцене");
            previousStage.show();
        } else {
            System.out.println("Предыдущая сцена отсутствует");
        }
    }

    public void setPreviousStage(Stage stage) {
        this.previousStage = stage;
        System.out.println("Previous stage установлен: " + stage);
    }
}
