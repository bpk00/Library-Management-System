##
# 📖 Library Management System - Project Overview
**The Library Management System** is a simple, Java-based application designed to manage and streamline the daily operations of a library. It enables librarians to log in using a username and password, and provides essential features for managing library resources, book inventory, and student records.

##
## ✨ Key Features:
- **User Authentication:** Login to the system using a username and password, Logout function.
- **Manage Students:** Add new student records to the system.
- **Manage Books:** Add new books to the library’s collection.
- **Issue Books:** Issue books to students.
- **Return Books:** Record the return of books by students.
- **View Records:** View the list of books issued and returned., View books and students details

##
## 💻 Technologies Used:
- **Java:** The core programming language used for the development of the system.
  - Java Swing & AWT: Used for creating the Graphical User Interface (GUI) of the application.
- **MySQL:** A relational database management system to store student and book records.
- **Maven:** A build automation tool used to manage dependencies and the project's lifecycle.
- **NetBeans IDE:** IDE used for coding, executing and testing the project.

This system aims to simplify the day-to-day tasks involved in library management, providing an easy-to-use interface for administrators to track students, books, and the status of book issues and returns.

##
## 👀 Project Preview:
![Library System Preview.](/Assets/library_system.png)

##
## 🚀 How to Run the Project
Follow these steps to set up and run the **Library Management System** on your local machine:
1. **Clone the Repository** 
2. **Install Required Technologies**
    - Ensure you have **Java (JDK 21)** installed. (`java -version`)
    - Install **Apache Maven**.
    - Use an IDE like **VS Code** with the following extensions:
      - Language Support for Java(TM) by Red Hat
      - Debugger for Java
      - Java Test Runner
      - Maven for Java
3. **Configure the Application**
    - Open the project in your IDE.
    - Locate the file `config.properties.example`
      - Add your database configuration details
      - Rename the file to `config.properties`
4. **Set Up the Database**
    - Run the provided SQL script [`SQL file`](https://github.com/bpk00/Library-Management-System/blob/main/Assets/LibrarySystem.sql)
5. **Run the Project**
    - Open [`LibraryManagementSystem`](https://github.com/bpk00/Library-Management-System/tree/main/LibraryManagementSystem) folder in terminal
    - Run these commands:
       - `mvn clean install`
       - `mvn exec:java`

##
## 🙏 Acknowledgements
Thanks to all the open-source projects and tutorials that inspired this project.
##
## 🎉 Enjoy the Project!
