
# Java Basics Q\&A

## 1. Is Java Platform Independent if then how?

✅ Yes, Java is a platform independent language.

* The `javac` compiler generates the **bytecode** or `.class` file which can be executed on any machine irrespective of the underlying OS.
* The generated file needs **JVM** installed in the operating system for further execution.
* Although, JVM is platform dependent, the bytecode can be created in any system and can be executed on any other system.

---

## 2. What are the top Java Features?

* Simple
* Platform Independent
* Interpreted
* Robust
* Object-Oriented
* Secured
* High Performance
* Multithreaded

---

## 3. What happens when we run a Java program ?

1. We write the code as `Hello.java`.
2. We compile it using `javac Hello.java`. It turns the source code into bytecode and generates `.class` file.
3. When we run `java Hello`, JVM starts! It loads the `.class` file into the memory. It creates the main thread for executing main.
4. JVM checks the code and makes sure that the bytecode is safe and correct.
5. JVM looks for `public static void main(String[] args)`.
6. JVM starts running the code line by line and frequently used code is converted into Machine Code by **JIT** for speed.
7. JVM automatically manages the memory, unused objects are cleaned up by the Garbage Collector.
8. When `main` finishes and no important threads are running, JVM shuts down.

---

## 4. What is JIT ?

* JIT stands for **Just-In-Time compiler** which is a part of Java Runtime Environment (**JRE**).

### Process:

1. Source code is compiled into bytecode by `javac` compiler.
2. Bytecode is further passed to JVM.
3. JIT (part of JVM) compiles frequently used bytecode into **native machine code** at runtime.

👉 Its job is to make Java program run faster. Instead of interpreting bytecode line by line forever, JIT converts frequently used bytecodes into machine code.

### Example

```java
for(int i = 0; i < 1000000; i++) {
    System.out.println(i);
}
```

At first JVM interprets line by line. After noticing this loop runs many times, JIT compiles it into **native code**.
Now the loop runs much faster because CPU executes it directly.

---

## 5. What is Runtime Constant Pool ?

* Every Java `.class` file has a section called **constant pool**.
* It stores constants and references used in the program such as:

  * *String Literals*
  * *Numeric Constants*
  * *Class Name*
  * *Method Name and Signature*
  * *Field Names*

When `.class` is loaded into JVM, this constant pool becomes part of **Runtime Constant Pool**.

* JVM uses it as a **lookup table** for everything.
* Example:
  If code says `System.out.println("Hello")`,

  * The string `"Hello"` and method `println` are not directly stored in bytecode.
  * They are references in the constant pool.
  * At runtime, JVM resolves them from the runtime constant pool.

### Advantage

```java
class Test {
    public static void main(String[] args) {
        System.out.println("Hi");
        System.out.println("Hi");
    }
}
```

* The string constant `"Hi"` is stored **once** in the constant pool of the class file.
* Both `println("Hi")` statements in bytecode just point to the **same entry** (say `#3`).

✅ This saves memory, makes lookup faster, and ensures consistency.

---

## 6. What are Memory Storages available with JVM?

JVM consists of a few memory storages:

1. **Class (Method) Area**

   * Stores class-level data of every class such as runtime constant pool, field, and method data, and the code for methods.

2. **Heap**

   * Objects are created or stored here.
   * Used to allocate memory to objects during runtime.

3. **Stack**

   * Stores data and partial results which are needed while returning values for a method.

4. **Program Counter Register**

   * Stores address of the JVM instruction currently being executed.

5. **Native Method Stack**

   * Stores all the **native methods** used in the application.
   * A native method is declared in Java but implemented in another language (e.g., C/C++).
   * Actual code resides in compiled libraries (`.dll` on Windows, `.so` on Linux).

---

## 7. What is ClassLoader ?

* Classloader is part of the **JRE**.
* During execution of the `.class` file, classloader is responsible for dynamically loading the Java classes and interfaces into JVM.
* Because of classloaders, Java runtime system does not need to know about files and file systems.

---

## 8. JDK, JVM, JRE, JIT

### 🔹 JVM (Java Virtual Machine)

* The engine that runs Java programs.
* Reads **bytecode** (`.class` files) and executes it.
* Manages memory, garbage collection, and security.
  👉 Think of it as the **runtime engine**.

---

### 🔹 JRE (Java Runtime Environment)

* Provides everything needed to **run** Java applications.
* Contains:

  * JVM
  * Core Java libraries (`java.lang`, `java.util`, etc.)
  * Supporting files
* ❌ No compiler, no development tools.
  👉 Used by **end-users** to run Java apps.

---

### 🔹 JDK (Java Development Kit)

* Full package for **developers**.
* Contains:

  * JRE (so it can also run programs)
  * Compiler (`javac`)
  * Tools (`jdb`, `jar`, `javadoc`, etc.)
    👉 Used by developers to write + compile + run Java apps.

---

### 🔹 JIT (Just-In-Time Compiler)

* A part of the **JVM** (inside the execution engine).
* Purpose: make Java run faster.
* Converts frequently used bytecode into **native machine code** at runtime.
* Next time the code runs → it executes directly on CPU (no interpretation).
  👉 Makes Java programs almost as fast as C/C++.

---

### Visual Summary

```
JDK = JRE + Development Tools
JRE = JVM + Libraries
JVM = Runs bytecode
JIT = Part of JVM that speeds execution by converting bytecode → native code
```

👉 In short:

* **JDK** → Develop + Compile + Run
* **JRE** → Run only
* **JVM** → Executes bytecode
* **JIT** → Optimizes JVM execution

