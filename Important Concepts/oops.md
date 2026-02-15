What are the four main principles of OOP?

The **four main principles of Object-Oriented Programming (OOP)** are:

1. **Encapsulation**
2. **Abstraction**
3. **Inheritance**
4. **Polymorphism**

Let’s understand each **with Java examples in simple terms**.

---

# 1. Encapsulation

### Idea:

**Wrap data (variables) and methods into a single unit (class)** and **hide internal details** from outside access.

### How in Java:

* Make variables **private**
* Provide **getters/setters** to control access

```java
class BankAccount {
    private double balance;   // hidden data

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

### Why important:

* Protects data from misuse
* Allows validation before changing values

👉 Real-life: ATM lets you withdraw money but **doesn't show internal banking system**.

---

# 2. Abstraction

### Idea:

**Show only essential features** and **hide implementation details**.

### How in Java:

Using:

* **abstract class**
* **interface**

```java
abstract class Vehicle {
    abstract void start();  // only rule, no implementation
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with key");
    }
}
```

### Why important:

* User doesn’t need to know **how** something works
* Only **what it does**

👉 Real-life: You press **TV remote button** without knowing internal circuits.

---

# 3. Inheritance

### Idea:

**One class can use properties and methods of another class**.

### How in Java:

Using **extends** keyword.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking...");
    }
}
```

Now `Dog` can use:

```java
Dog d = new Dog();
d.eat();   // from Animal
d.bark();  // its own
```

### Why important:

* **Code reuse**
* Easier maintenance
* Creates **parent–child relationship**

---

# 4. Polymorphism

### Idea:

**Same method name, different behavior**.

Two types in Java:

* **Compile-time (Method Overloading)**
* **Runtime (Method Overriding)**

### Example:

#### Method Overloading

```java
class MathUtil {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }
}
```

#### Method Overriding

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

### Why important:

* Makes code **flexible and dynamic**
* Supports **runtime decision making**

---

# Quick Memory Trick

**E → A → I → P**

* **E**ncapsulation → Data hiding
* **A**bstraction → Hide implementation
* **I**nheritance → Reuse code
* **P**olymorphism → Many forms

---

Object-Oriented Programming has four main principles: Encapsulation, Abstraction, Inheritance, and Polymorphism.

1. Encapsulation means binding data and methods together inside a class and restricting direct access to the data.
In Java, we achieve this by making variables private and providing getters and setters.
This protects the internal state of an object and ensures controlled modification.

2. Abstraction means hiding implementation details and showing only essential functionality.
In Java, this is done using abstract classes and interfaces.
The user knows what a method does, but not how it works internally, which reduces complexity and improves maintainability.

3. Inheritance allows one class to acquire properties and behavior of another class using the extends keyword.
This promotes code reuse, reduces duplication, and creates a parent–child relationship between classes.

4. Polymorphism means “many forms.”
In Java, it happens in two ways:

Method overloading at compile time

Method overriding at runtime
It allows the same method name to behave differently based on the object, making the system more flexible and scalable.

In summary:
Encapsulation secures data, Abstraction hides complexity, Inheritance enables reuse, and Polymorphism provides flexibility.
Together, these principles make Java applications modular, maintainable, and scalable, which is why OOP is widely used in enterprise development like Spring Boot systems.


Explain the concept of encapsulation with an example.

### Encapsulation — Simple Interview Explanation

**Encapsulation** is the concept of **wrapping data (variables) and methods (functions) into a single unit (class)** and **restricting direct access to the data**.

In Java, this is achieved by:

* Making variables **private**
* Providing **public getter and setter methods** to access or modify them safely

---

### Why encapsulation is important

* **Protects data** from unauthorized access
* Allows **validation before updating values**
* Improves **security and maintainability**

---

### Java Example

```java
class BankAccount {
    private double balance;   // hidden data

    // method to safely update balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // method to safely read balance
    public double getBalance() {
        return balance;
    }
}
```

### How this shows encapsulation

* `balance` is **private**, so it **cannot be changed directly** from outside the class.
* Any change must go through `deposit()`, which **validates the amount**.
* Access is controlled using `getBalance()`.

---

### One-line interview definition

**Encapsulation is the process of hiding internal data and allowing controlled access through public methods.**

---

How does inheritance work in Java?

### Inheritance in Java — Simple Explanation

**Inheritance** is the mechanism where **one class acquires the properties and behaviors of another class**.
It helps in **code reuse**, **reduces duplication**, and creates a **parent–child relationship** between classes.

In Java, inheritance is implemented using the **`extends`** keyword.

---

# How inheritance works

* The **parent class** (also called *superclass*) contains common fields and methods.
* The **child class** (also called *subclass*) inherits those members and can:

  * Use them directly
  * Add new features
  * **Override** existing methods to change behavior

---

# Basic Java Example

```java
// Parent class
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Child class
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}
```

### Using the inherited behavior

```java
Dog d = new Dog();

d.eat();   // inherited from Animal
d.bark();  // defined in Dog
```

Here:

* `Dog` **inherits** the `eat()` method from `Animal`.
* So we **reuse code** without rewriting it.

---

# Method Overriding in Inheritance

A child class can **change the parent’s behavior**.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Now Java decides **at runtime** which method to call → this is **runtime polymorphism**.

---

# Types of inheritance in Java

Java supports:

* **Single** → one parent, one child
* **Multilevel** → grandparent → parent → child
* **Hierarchical** → one parent, multiple children

Java **does NOT support multiple inheritance with classes**
(but supports it using **interfaces**).

---

# One-line interview definition

**Inheritance in Java is the process by which one class acquires the properties and behavior of another class using the `extends` keyword, enabling code reuse and polymorphism.**

---

### Method Overloading vs. Method Overriding in Java

Both are forms of **polymorphism**, but they work in different ways.

---

# 1. Method Overloading (Compile-time polymorphism)

### Definition

**Method overloading** means **multiple methods with the same name in the same class**, but with **different parameters** (type, number, or order).

### Key points

* Happens **within the same class**
* **Method signature must be different**
* Decided at **compile time**
* Return type alone **cannot** differentiate methods

### Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

Here, the method name is the same (`add`), but parameters differ → **overloading**.

---

# 2. Method Overriding (Runtime polymorphism)

### Definition

**Method overriding** happens when a **child class provides its own implementation** of a method already defined in the **parent class**.

### Key points

* Requires **inheritance**
* **Same method name, same parameters**
* Decided at **runtime**
* Uses **`@Override` annotation** (recommended)
* Enables **dynamic method dispatch**

### Example

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

```java
Animal a = new Dog();
a.sound();   // Calls Dog’s version at runtime
```

This is **overriding**.

---

# Quick Difference Table

| Feature            | Method Overloading       | Method Overriding    |
| ------------------ | ------------------------ | -------------------- |
| Where it occurs    | Same class               | Parent–child classes |
| Parameters         | Must be different        | Must be same         |
| Return type        | Can differ (with params) | Same or covariant    |
| Time of decision   | Compile time             | Runtime              |
| Inheritance needed | No                       | Yes                  |

---

# One-line interview answer

**Method overloading is defining multiple methods with the same name but different parameters in the same class, while method overriding is redefining a parent class method in a child class with the same signature to provide runtime polymorphism.**

---


Can you override a static method in Java?

### Can you override a static method in Java?

**Short interview answer:**
**No, static methods cannot be overridden in Java; they can only be hidden.**

---

## Why static methods cannot be overridden

Method **overriding** depends on **runtime polymorphism** (dynamic method dispatch).
But **static methods belong to the class, not to the object**, and they are resolved at **compile time**.

So Java does **method hiding**, not overriding.

---

## Example of static method hiding

```java
class Parent {
    static void show() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    static void show() {   // This hides Parent.show(), not overrides
        System.out.println("Child static method");
    }
}
```

### Calling the methods

```java
Parent p = new Child();
p.show();   // Output: Parent static method
```

Even though the object is `Child`, the **reference type (Parent)** decides the call →
because static methods are **compile-time bound**.

---

## Key differences from overriding

| Feature               | Static Method | Overridden Method |
| --------------------- | ------------- | ----------------- |
| Binding time          | Compile time  | Runtime           |
| Belongs to            | Class         | Object            |
| Supports polymorphism | ❌ No          | ✅ Yes             |
| Concept               | Method hiding | Method overriding |

---

## One-line interview statement

**Static methods cannot be overridden because they are class-level and resolved at compile time; a subclass can only hide them, not override them.**

---

What is the difference between “is-a” and “has-a” relationships?

### Difference between **“is-a”** and **“has-a”** relationships in Java (OOP)

Both describe **relationships between classes**, but they are implemented differently.

---

# 1. “is-a” relationship → **Inheritance**

### Meaning

An **is-a** relationship means **one class is a type of another class**.

Example:

* Dog **is an** Animal
* Car **is a** Vehicle

### How in Java

Implemented using **`extends`** (or `implements` for interfaces).

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

class Dog extends Animal {   // Dog is-a Animal
    void bark() {
        System.out.println("Barking...");
    }
}
```

### Key idea

Child class **inherits** properties and behavior of parent.

---

# 2. “has-a” relationship → **Composition / Aggregation**

### Meaning

A **has-a** relationship means **one class contains another class as a field**.

Example:

* Car **has an** Engine
* Person **has a** Heart

### How in Java

Implemented using **object reference inside a class**.

```java
class Engine {
    void start() {
        System.out.println("Engine starts");
    }
}

class Car {
    private Engine engine = new Engine();  // Car has-a Engine

    void startCar() {
        engine.start();
    }
}
```

### Key idea

One object **uses** another object instead of inheriting from it.

---

# Quick comparison

| Feature              | is-a                     | has-a                    |
| -------------------- | ------------------------ | ------------------------ |
| Concept              | Inheritance              | Composition/Aggregation  |
| Java keyword         | `extends` / `implements` | Object reference (field) |
| Relationship meaning | “Type of”                | “Contains/uses”          |
| Code reuse           | Through inheritance      | Through delegation       |

---

# One-line interview answer

**“is-a” represents inheritance where a subclass is a type of superclass, while “has-a” represents composition where a class contains another class as a member.**

---

How is abstraction achieved in Java?

### Abstraction in Java — Simple Explanation

**Abstraction** means **hiding implementation details** and showing only the **essential functionality** to the user.
It helps reduce **complexity** and makes code easier to **maintain and extend**.

---

# How abstraction is achieved in Java

Java provides **two main ways** to achieve abstraction:

## 1. Using **abstract classes**

* Declared with the `abstract` keyword
* Can have:

  * **Abstract methods** (no body)
  * **Concrete methods** (with implementation)
* Cannot be instantiated directly
* Subclasses must **implement abstract methods**

### Example

```java
abstract class Vehicle {

    abstract void start();   // abstract method

    void fuelType() {        // concrete method
        System.out.println("Uses fuel");
    }
}

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}
```

Here:

* User only knows **Car can start**
* Internal logic is **hidden** → abstraction.

---

## 2. Using **interfaces**

* Interface contains **method declarations** (by default abstract)
* Supports **100% abstraction** (except default/static methods in modern Java)
* A class **implements** an interface and provides method bodies.

### Example

```java
interface Payment {
    void pay();   // abstract method
}

class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Paid using credit card");
    }
}
```

User interacts with **Payment**, not the internal implementation.

---

# Key difference: abstract class vs interface

| Feature     | Abstract Class             | Interface                          |
| ----------- | -------------------------- | ---------------------------------- |
| Methods     | Abstract + concrete        | Mostly abstract                    |
| Variables   | Instance variables allowed | Only public static final constants |
| Inheritance | Single inheritance         | Multiple interfaces allowed        |
| Keyword     | `extends`                  | `implements`                       |

---

# One-line interview definition

**Abstraction in Java is achieved using abstract classes and interfaces to hide implementation details and expose only essential behavior.**

---


### Role of Interfaces in OOP (Java)

An **interface** in Object-Oriented Programming defines a **contract** that classes must follow.
It specifies **what a class should do**, but **not how it should do it**.

---

# Key roles of interfaces

## 1. Achieving abstraction

Interfaces provide **100% abstraction** (conceptually), meaning:

* Only **method declarations** are exposed.
* **Implementation details are hidden** inside implementing classes.

```java
interface Payment {
    void pay();
}
```

The user only knows **payment can be made**, not the internal logic.

---

## 2. Enabling multiple inheritance

Java **does not allow multiple inheritance with classes**,
but a class can **implement multiple interfaces**.

```java
interface Camera {
    void click();
}

interface MusicPlayer {
    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {
    public void click() {}
    public void playMusic() {}
}
```

This allows combining **multiple behaviors** safely.

---

## 3. Supporting loose coupling

Interfaces help write **flexible and maintainable code**.

We program to the **interface**, not the implementation:

```java
Payment p = new CreditCardPayment();
```

Later, we can switch to:

```java
Payment p = new UpiPayment();
```

No change in calling code → **easy scalability**.

---

## 4. Enabling polymorphism

Different classes can implement the **same interface** and provide **different behavior**.

```java
class CreditCardPayment implements Payment {
    public void pay() { System.out.println("Credit card payment"); }
}

class UpiPayment implements Payment {
    public void pay() { System.out.println("UPI payment"); }
}
```

At runtime, the correct implementation is used → **runtime polymorphism**.

---

# One-line interview answer

**Interfaces in OOP define a contract for classes, enabling abstraction, multiple inheritance, loose coupling, and polymorphism, which makes applications flexible and scalable.**

---

How are constructors used in OOP?

### Constructors in OOP (Java) — Simple Explanation

A **constructor** is a special method used to **initialize objects** when they are created.
It sets the **initial state** of an object.

---

# Key characteristics of constructors

* **Same name as the class**
* **No return type** (not even `void`)
* Called **automatically** when an object is created using `new`
* Can be **overloaded** (multiple constructors with different parameters)

---

# Basic example

```java
class Student {
    String name;
    int age;

    // Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }
}
```

### Object creation

```java
Student s = new Student("Indra", 22);
```

Here, the constructor:

* Runs **automatically**
* Assigns values to `name` and `age`

---

# Types of constructors in Java

## 1. Default constructor

* Provided by Java **if no constructor is written**
* Initializes values to **default values** (`null`, `0`, etc.)

```java
class Test {
}
```

---

## 2. Parameterized constructor

* Accepts **arguments** to initialize fields.

```java
class Car {
    String model;

    Car(String m) {
        model = m;
    }
}
```

---

## 3. Constructor overloading

```java
class Box {
    int length;

    Box() { length = 0; }

    Box(int l) { length = l; }
}
```

Same constructor name, **different parameters**.

---

# Why constructors are important in OOP

* Ensure objects are **properly initialized**
* Help maintain **data consistency**
* Support **encapsulation** by setting values at creation time
* Enable **dependency injection** (widely used in Spring Boot)

---

# One-line interview answer

**Constructors in OOP are special methods used to initialize an object’s state at the time of creation, ensuring the object starts with valid data.**

---

What is the difference between abstract classes and interfaces?
### Abstract Class vs Interface (Java) — Brief

**Abstract Class**

* Can have **abstract + concrete methods**
* Supports **instance variables and constructors**
* Allows **single inheritance** (`extends`)
* Used when classes share **common state and behavior**

**Interface**

* Mostly **abstract methods** (plus default/static in modern Java)
* Only **public static final constants**, no instance state
* Supports **multiple inheritance** (`implements` multiple interfaces)
* Used to define a **contract or capability**

**One-line difference:**
An **abstract class provides partial implementation with shared state**, while an **interface defines a contract for behavior with multiple inheritance support**.


Can you instantiate an abstract class?
**Short answer:**
❌ **No, you cannot instantiate an abstract class in Java.**

---

### Why not?

An **abstract class may contain abstract methods** (methods without implementation).
Since the object would not have complete behavior, Java **prevents direct instantiation**.

```java
abstract class Animal {
    abstract void sound();
}

// Animal a = new Animal();  // ❌ Compile-time error
```

---

### How it is used instead

You create a **subclass** that provides implementations, then instantiate the subclass.

```java
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

Animal a = new Dog();  // ✅ Valid
```

---

### One-line interview answer

**Abstract classes cannot be instantiated directly; they must be subclassed and implemented before creating objects.**


What is the use of the super keyword?
### Use of the `super` keyword in Java — Simple Explanation

The **`super`** keyword is used to refer to the **immediate parent class object**.
It helps access **parent class constructors, methods, and variables** when working with inheritance.

---

# Main uses of `super`

## 1. Access parent class variables

Used when **child and parent have variables with the same name**.

```java
class Animal {
    String name = "Animal";
}

class Dog extends Animal {
    String name = "Dog";

    void printName() {
        System.out.println(super.name); // refers to parent variable
    }
}
```

---

## 2. Call parent class methods

Used when a **child overrides a method** but still wants to use the parent’s version.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        super.sound();          // call parent method
        System.out.println("Dog barks");
    }
}
```

---

## 3. Call parent class constructor

Used to **initialize parent class fields** when creating a child object.
`super()` must be the **first statement** in the constructor.

```java
class Animal {
    Animal(String type) {
        System.out.println(type);
    }
}

class Dog extends Animal {
    Dog() {
        super("Mammal"); // calls parent constructor
    }
}
```

---

# One-line interview answer

**The `super` keyword in Java is used to refer to the immediate parent class, allowing access to its variables, methods, and constructors within a subclass.**


### How Java supports multiple inheritance

**Short interview answer:**
Java **does not support multiple inheritance with classes**, but it **achieves it using interfaces**.

---

### Why not multiple inheritance with classes?

If Java allowed:

```java
class A { void show() {} }
class B { void show() {} }
class C extends A, B {}   // ❌ Not allowed
```

It would create the **Diamond Problem**
(Java wouldn’t know which `show()` to call).

---

### How Java solves this → Using interfaces

A class can **implement multiple interfaces**:

```java
interface A {
    void show();
}

interface B {
    void display();
}

class C implements A, B {
    public void show() {
        System.out.println("From A");
    }

    public void display() {
        System.out.println("From B");
    }
}
```

This provides **multiple inheritance of behavior** safely.

---

### What about default methods conflict? (Java 8+)

If two interfaces have the **same default method**,
the class **must override it** to remove ambiguity.

---

### One-line interview answer

**Java supports multiple inheritance through interfaces, allowing a class to implement multiple behaviors while avoiding the diamond problem of class inheritance. if multiple interfaces define the same abstract method, the class implements it once, and if they define the same default method, the class must override it to resolve ambiguity.**


What is a final class and when would you use it?
### Final class in Java — Brief explanation

A **final class** is a class that **cannot be extended (inherited)** by any other class.
It is declared using the `final` keyword.

```java
final class Utility {
    void show() {
        System.out.println("Final class method");
    }
}

// class Test extends Utility {}  ❌ Compile-time error
```

---

### When would you use a final class?

* **To prevent inheritance** for security or design reasons
* **To make the class immutable** (e.g., `String` in Java)
* **To protect implementation** from being modified or overridden
* **For utility/helper classes** that shouldn’t be subclassed

---

### One-line interview answer

**A final class in Java cannot be inherited, and it is used to prevent extension, ensure immutability, and protect implementation details.**


How does access control support encapsulation in Java?
### How access control supports encapsulation in Java

**Encapsulation** means **hiding internal data** and allowing **controlled access**.
Java achieves this using **access modifiers**.

---

# Access modifiers in Java

| Modifier               | Visibility                | Use in encapsulation          |
| ---------------------- | ------------------------- | ----------------------------- |
| `private`              | Only inside same class    | **Hide data completely**      |
| `default` (no keyword) | Same package              | Limited access                |
| `protected`            | Same package + subclasses | Controlled inheritance access |
| `public`               | Everywhere                | Expose safe methods           |

---

# How this enables encapsulation

* **Fields are kept `private`** → prevents direct modification.
* **Public getters/setters provide controlled access** → validation can be added.
* **Implementation details remain hidden** → improves security and maintainability.

---

# Example

```java
class BankAccount {
    private double balance;   // hidden data

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;   // controlled update
        }
    }

    public double getBalance() {
        return balance;   // controlled read
    }
}
```

Here:

* `balance` is **not directly accessible** from outside.
* Access happens **only through methods** → this is **encapsulation using access control**.

---

# One-line interview answer

**Access control supports encapsulation in Java by restricting direct access to data using private fields and exposing controlled interaction through public or protected methods.**


What are inner classes and how do they relate to OOP?

### Inner Classes in Java and their relation to OOP

**Inner classes** are classes defined **inside another class**.
They help logically group classes that are **closely related** and improve **encapsulation and abstraction** in OOP.

---

# Types of inner classes in Java

### 1. Member (non-static) inner class

* Defined inside a class, **outside methods**
* Can access **all members of the outer class**, even `private`.

```java
class Outer {
    private int x = 10;

    class Inner {
        void show() {
            System.out.println(x); // access outer private data
        }
    }
}
```

**OOP relation:**
Improves **encapsulation** by hiding helper classes inside the main class.

---

### 2. Static nested class

* Declared with `static`
* Cannot access **non-static members** of outer class directly.

```java
class Outer {
    static class Nested {
        void display() {
            System.out.println("Static nested class");
        }
    }
}
```

**OOP relation:**
Used for **logical grouping** without needing an outer object.

---

### 3. Local inner class

* Defined **inside a method**
* Accessible only within that method.

```java
class Test {
    void method() {
        class Local {
            void msg() { System.out.println("Local inner class"); }
        }
        new Local().msg();
    }
}
```

**OOP relation:**
Supports **abstraction** by limiting scope.

---

### 4. Anonymous inner class

* **No class name**
* Used for **one-time implementation**, often with interfaces or abstract classes.

```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Running");
    }
};
```

**OOP relation:**
Enables **polymorphism and abstraction** with concise code.

---

# One-line interview answer

**Inner classes are classes defined within another class that improve encapsulation, abstraction, and logical grouping of related functionality in OOP.**

---

How does the instanceof keyword work?
### `instanceof` in Java — Simple Explanation

The **`instanceof`** keyword is used to **check whether an object belongs to a specific class or interface type**.
It returns a **boolean value** (`true` or `false`).

---

# Basic syntax

```java
object instanceof ClassName
```

* **true** → object is of that type (or subclass / implemented interface)
* **false** → object is not of that type

---

# Example with inheritance

```java
class Animal {}
class Dog extends Animal {}

Animal a = new Dog();

System.out.println(a instanceof Dog);    // true
System.out.println(a instanceof Animal); // true
```

Because:

* `Dog` **is-a** `Animal`
* So both checks return **true**.

---

# Example with interface

```java
interface Pet {}
class Dog implements Pet {}

Dog d = new Dog();

System.out.println(d instanceof Pet); // true
```

---

# Important notes

* Works only with **objects**, not primitives.
* If reference is **null**, result is **false**.
* Often used before **type casting** to avoid `ClassCastException`.

```java
if (a instanceof Dog) {
    Dog d = (Dog) a;  // safe casting
}
```

---

# One-line interview answer

**The `instanceof` keyword checks at runtime whether an object is an instance of a specified class, subclass, or interface, returning true or false.**


 What are design patterns and how do they relate to OOP?

### Design Patterns in OOP — Simple Explanation

**Design patterns** are **reusable, proven solutions** to common problems that occur during **object-oriented software design**.
They are **not code**, but **best-practice templates** for structuring classes and objects.

---

# How design patterns relate to OOP

Design patterns are built using **core OOP principles**:

* **Encapsulation** → hides internal details (e.g., Singleton)
* **Inheritance & Polymorphism** → allow flexible behavior (e.g., Strategy, Template Method)
* **Abstraction** → separates interface from implementation (e.g., Factory, Observer)

So, **design patterns are practical applications of OOP concepts** to make systems:

* **Reusable**
* **Maintainable**
* **Scalable**
* **Loosely coupled**

---

# Common categories of design patterns

### 1. Creational patterns

Deal with **object creation**.
Examples: **Singleton, Factory, Builder**

### 2. Structural patterns

Deal with **class/object composition**.
Examples: **Adapter, Decorator, Facade**

### 3. Behavioral patterns

Deal with **object interaction and responsibility**.
Examples: **Observer, Strategy, Command**

---

# One-line interview answer

**Design patterns are reusable solutions to common software design problems, built on OOP principles like abstraction, encapsulation, inheritance, and polymorphism to create flexible and maintainable systems.**

---

What’s the difference between composition and inheritance?

### Composition vs Inheritance in OOP (Java)

Both are ways to achieve **code reuse and relationships between classes**, but they work differently.

---

# Inheritance (“is-a” relationship)

* One class **extends** another class.
* Child **inherits fields and methods** of the parent.
* Creates a **tight coupling** between classes.
* Decided at **compile time**.

```java
class Animal {
    void eat() {}
}

class Dog extends Animal {   // Dog is-a Animal
}
```

**Use when:**
There is a clear **hierarchical relationship** and shared behavior.

---

# Composition (“has-a” relationship)

* A class **contains another class as a field**.
* Reuse happens by **delegating work** to the contained object.
* Creates **loose coupling** and more flexibility.
* Can change behavior at **runtime**.

```java
class Engine {
    void start() {}
}

class Car {
    private Engine engine = new Engine();  // Car has-a Engine
}
```

**Use when:**
You want **flexibility, modularity, and easier maintenance**.

---

# Key differences

| Feature           | Inheritance       | Composition        |
| ----------------- | ----------------- | ------------------ |
| Relationship      | is-a              | has-a              |
| Coupling          | Tight             | Loose              |
| Reusability       | Through hierarchy | Through delegation |
| Flexibility       | Less              | More               |
| Change at runtime | Hard              | Easier             |

---

# One-line interview answer

**Inheritance models an “is-a” hierarchy for sharing behavior, while composition models a “has-a” relationship that promotes loose coupling and greater flexibility—so composition is generally preferred over inheritance.**







