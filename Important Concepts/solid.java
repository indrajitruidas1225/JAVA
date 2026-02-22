## SOLID Principles in Java (with simple examples)

SOLID is a set of five design principles that help you write clean, maintainable, scalable, and testable object-oriented code.

---

# 1. **S — Single Responsibility Principle (SRP)**

**A class should have only one reason to change.**

If a class handles multiple responsibilities, changing one behavior may accidentally break another.

### ❌ Violating SRP

```java
class Invoice {
    void calculateTotal() {
        // calculation logic
    }

    void printInvoice() {
        // printing logic
    }

    void saveToDatabase() {
        // database logic
    }
}
```

This class:

* Calculates
* Prints
* Saves to DB

It has multiple responsibilities.

### ✅ Following SRP

```java
class Invoice {
    void calculateTotal() {
        // calculation logic
    }
}

class InvoicePrinter {
    void print(Invoice invoice) {
        // printing logic
    }
}

class InvoiceRepository {
    void save(Invoice invoice) {
        // database logic
    }
}
```

Now:

* Each class has one responsibility.
* Easier to test and modify.

---

# 2. **O — Open/Closed Principle (OCP)**

**Software entities should be open for extension but closed for modification.**

You should add new behavior without modifying existing code.

### ❌ Violating OCP

```java
class PaymentService {
    void pay(String type) {
        if (type.equals("credit")) {
            // credit card logic
        } else if (type.equals("paypal")) {
            // paypal logic
        }
    }
}
```

If a new payment method comes, you must modify this class.

### ✅ Following OCP

```java
interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Paying with credit card");
    }
}

class PayPalPayment implements Payment {
    public void pay() {
        System.out.println("Paying with PayPal");
    }
}

class PaymentService {
    void processPayment(Payment payment) {
        payment.pay();
    }
}
```

Now:

* Add `UPIPayment` without changing `PaymentService`.
* We extend behavior, not modify existing code.

---

# 3. **L — Liskov Substitution Principle (LSP)**

**Subtypes must be substitutable for their base types.**

If class B extends class A, you should be able to use B wherever A is expected.

### ❌ Violating LSP

```java
class Bird {
    void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
```

Penguin is a Bird, but it cannot fly. That breaks substitutability.

### ✅ Following LSP

```java
class Bird {
}

interface Flyable {
    void fly();
}

class Sparrow extends Bird implements Flyable {
    public void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {
}
```

Now:

* Only flying birds implement `Flyable`.
* No unexpected runtime exceptions.

---

# 4. **I — Interface Segregation Principle (ISP)**

**Clients should not be forced to depend on interfaces they do not use.**

Avoid large "fat" interfaces.

### ❌ Violating ISP

```java
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        System.out.println("Robot working");
    }

    public void eat() {
        // Robots don't eat
        throw new UnsupportedOperationException();
    }
}
```

Robot is forced to implement `eat()`.

### ✅ Following ISP

```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human working");
    }

    public void eat() {
        System.out.println("Human eating");
    }
}

class Robot implements Workable {
    public void work() {
        System.out.println("Robot working");
    }
}
```

Now:

* Classes implement only what they need.

---

# 5. **D — Dependency Inversion Principle (DIP)**

**High-level modules should not depend on low-level modules. Both should depend on abstractions.**

Also:

* Do not depend on concrete classes.
* Depend on interfaces.

### ❌ Violating DIP

```java
class MySQLDatabase {
    void connect() {
        System.out.println("Connecting to MySQL");
    }
}

class UserService {
    private MySQLDatabase db = new MySQLDatabase();

    void saveUser() {
        db.connect();
    }
}
```

UserService tightly depends on MySQLDatabase.

### ✅ Following DIP

```java
interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connecting to MySQL");
    }
}

class UserService {
    private Database database;

    UserService(Database database) {
        this.database = database;
    }

    void saveUser() {
        database.connect();
    }
}
```

Now:

* UserService depends on `Database` abstraction.
* Easily switch to `PostgreSQLDatabase`.
* Enables dependency injection (used heavily in Spring).

---

# Quick Summary

| Principle | Meaning                        | Goal            |
| --------- | ------------------------------ | --------------- |
| SRP       | One responsibility per class   | Maintainability |
| OCP       | Extend without modifying       | Scalability     |
| LSP       | Subtypes must behave correctly | Reliability     |
| ISP       | Small, focused interfaces      | Flexibility     |
| DIP       | Depend on abstractions         | Loose coupling  |

---

# Why SOLID is Important (Especially in Enterprise Java / Spring)

In real-world projects:

* You add new features frequently.
* Requirements change.
* Teams grow.
* Codebase becomes large.

Without SOLID:

* Code becomes tightly coupled.
* Bugs increase.
* Refactoring becomes risky.

With SOLID:

* Code becomes modular.
* Testing becomes easier.
* Spring’s dependency injection works naturally.
* Microservices design becomes cleaner.
