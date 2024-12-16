# Book Library Management System

---

## Table of Contents
1. [Description](#description)
2. [Project Requirements List](#project-requirements-list)
3. [Team Members List](#team-members-list)
4. [Roles of Group Members](#roles-of-group-members)
5. [Screenshots](#screenshots)
6. [Sample Data](#sample-data)
7. [UML Class Diagram](#uml-class-diagram)
8. [Weekly Meeting Documentation](#weekly-meeting-documentation)
9. [Unit Test Cases](#unit-test-cases)
10. [Presentation](#presentation)

---

## Description

The **Book Library Management System** is a web-based application designed to facilitate the management of books in a library. This system allows users to easily manage books by adding, editing, deleting, and searching them by various criteria (e.g., title, author, genre). It also includes category filters for organizing books. The application uses a database to store information about books, users, and genres. Implemented using the **Model-View-Controller (MVC)** design pattern, the system ensures clear separation between the application logic, user interface, and data handling.


## Project Requirements List

Here are the key functionalities required for the successful completion of the **Library Management System**:

1. **User Authentication**: Secure login for both administrators and users.
2. **Book Management**: Add, update, and delete books using the `BookDAO` methods.
3. **Category Navigation**: Browse books by category.
4. **Search Functionality**: Users can search books by name, author, or title.
5. **Book Details and Loading**: Display detailed book information (description, images, price).
6. **Top-Selling and Popular Books**: Display the most popular and most liked books.
7. **Sales Management**: Track book sales and calculate total sales.
8. **Image Management**: Manage and display book images.
9. **Category Management**: View and filter books by categories.
10. **Data Storage and Connectivity**: Efficiently handle data storage and retrieval via the `DatabaseConnection`.

---

## Team Members List

- **Usenova Aminat**
- **Makkambay Malika**
- **Tokobaeva Burulai**

---

## Roles of Group Members

- **Usenova Aminat**: Responsible for designing the database structure, maintaining data integrity, and implementing CRUD operations for tables like Books, Users, and Genres.
- **Makkambay Malika**: Responsible for implementing project logic, backend coding, and developing the user interface using JavaFX and FXML.
- **Tokobaeva Burulai**: Responsible for creating detailed project documentation, including the README file, UML diagrams, weekly meeting summaries, and coordinating project activities.

---

## Screenshots

Below are key screenshots showcasing the application:

![Screenshot 1](https://github.com/user-attachments/assets/fdc87a4e-8134-44de-9a86-9e6fe5e53400)
![Screenshot 2](https://github.com/user-attachments/assets/34089d79-d317-4d58-9e4e-b7434f72fa60)
![Screenshot 3](https://github.com/user-attachments/assets/8daf7cfa-3e59-4977-ab38-cd246a60d503)
![Screenshot 4](https://github.com/user-attachments/assets/adee006c-e49d-4f13-9650-d153f883084a)
![Screenshot 5](https://github.com/user-attachments/assets/d38565d1-6731-4af2-a3d0-a05e06b16195)
![Screenshot 6](https://github.com/user-attachments/assets/09ac6bf7-909e-4819-9432-0a7021647a47)
![Screenshot 7](https://github.com/user-attachments/assets/28fd562b-2d51-44c6-a1fc-4c4a3ba73d4c)

---
## Database
![photo_2024-12-16_11-41-40](https://github.com/user-attachments/assets/4f1b2c3e-acdb-404d-84bb-80d607b183ec)
![photo_2024-12-16_11-49-28](https://github.com/user-attachments/assets/f2ad7a4b-50d7-445d-9aee-7099c4661d55)
![photo_2024-12-16_11-50-20](https://github.com/user-attachments/assets/8d111ea7-9dca-42a4-87a4-504e6f807147)
![photo_2024-12-16_11-50-24](https://github.com/user-attachments/assets/1de2791d-e08b-4d1f-8c4f-e753d4265c07)

---

## UML Class Diagram

The UML class diagram provides a visual representation of the system’s structure, detailing the classes, attributes, methods, and their relationships.

![image](https://github.com/user-attachments/assets/3d7c0923-00a6-4c50-94db-7614f7f87bb2)

### Diagram Description (Shorter Version):  
1. **Library**: Contains general book-related properties.  
2. **Book**: Extends `Library`, adding attributes like `id`, `title`, `author`, `isbn`, `likes`, and `sales` for managing book details.  
3. **Controllers**: Handle UI interactions such as switching views, searching books, and loading book details.  
4. **DAO**: Manages database operations, including adding books, updating sales/likes, and retrieving categories, images, and book records.  
5. **Model**: Defines the `Book` structure with attributes for detailed book management.


---

## Weekly Meeting Documentation

A https://docs.google.com/document/d/1BGBq9v5xVMb6bIMrR2ei8fpZdAquErZK_3GYMSyOXFw/edit?tab=t.5xpo8bbn673s summarizing our weekly meetings, including discussions, decisions, and action items, can be found here.

---

## Unit Test Cases

Unit test cases for the project will be included to ensure the proper functionality of all key components. Details of the tests will be added as development progresses.

---

## Presentation

[A presentation summarizing the project, its features, and its progress will be provided to stakeholders.](https://www.canva.com/design/DAGZRj6AOIg/VqhCkkI5PhZrAzIpBSGyCQ/edit?utm_content=DAGZRj6AOIg&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

---
