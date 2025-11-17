# Singleton Logging System

A complete Java implementation of a **thread-safe Singleton Logging System** designed to demonstrate mastery of the **Singleton Design Pattern** and its real-world use in software applications.

---

## 📌 Project Intent
The purpose of this project is to:

- Showcase the **Singleton design pattern** in a practical, realistic example.
- Build a custom logging solution similar to industry tools such as Log4j and SLF4J.
- Demonstrate how Singleton ensures **one shared logger instance** across an entire application.
- Provide a foundation for studying **creational design patterns** and building a portfolio-ready project.

This project also teaches:
- Thread-safe lazy initialization
- File-based logging
- Log formatting with timestamps and levels
- Encapsulation of core logging logic

---

## 🎯 Features
- **Singleton Pattern:** Only one logger instance exists.
- **Thread-safe:** Uses a static inner class for safe lazy loading.
- **Console logging:** All messages print to the terminal.
- **File logging:** Logs are saved in *application.log*.
- **Log Levels:** INFO, DEBUG, WARNING, ERROR.
- **Timestamps:** All logs include date and time.
- **Simple API:** `logger.info("Message")`.

---

## 🧱 Architecture
The project follows a clean and simple structure:

```
src/
 ├── LogLevel.java
 ├── Logger.java
 └── Main.java
```

### **LogLevel.java**
Enum defining log severity levels.

### **Logger.java**
Core Singleton class responsible for:
- formatting logs
- writing to console
- writing to file
- providing convenience methods (info, error, debug, warn)

### **Main.java**
Entry point to test the logging system.

---

## 🚀 How It Works
The Logger class:
- Has a **private constructor** so no other classes can instantiate it.
- Provides a **public static getInstance()** method to access the only instance.
- Uses a **static inner class** to create the Singleton safely and lazily.
- Writes all logs to both console and file.

---

## 🏃‍♂️ Example Usage
```java
Logger logger = Logger.getInstance();

logger.info("Application started");
logger.debug("Loading configuration");
logger.warn("Memory usage is high");
logger.error("Failed to connect to the database");
```
---

## 📦 Output Example
```
[2025-11-17 15:42:10][INFO] Application started
[2025-11-17 15:42:10][DEBUG] Loading configuration
[2025-11-17 15:42:10][WARNING] Memory usage is high
[2025-11-17 15:42:10][ERROR] Failed to connect to the database
```

---

## 🔧 Future Enhancements (Optional)
- Colored console logs
- Daily rolling log files
- Asynchronous background logging
- JSON log format support
- Log filters by level

---

## 📚 Learning Outcome
By completing this project, you will:
- Understand the **Singleton pattern** deeply and practically.
- Know how to implement thread-safe lazy initialization.
- Gain experience with file I/O in Java.
- Practice building maintainable, extensible system components.

---

## 👤 Author
Katlego Ralehlaka

Created for Java design pattern practice and mastery.

