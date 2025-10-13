---

# 🧠 CompletableFuture (Easy Explanation)

`CompletableFuture` in Java is part of the **java.util.concurrent** package.
It helps run tasks **asynchronously** (in the background) and **chain** multiple actions together — just like promises in JavaScript.

---

## 🧩 Basic Idea

Normally, we use `Future` to run a task and get a result later.
But with `Future`, we can’t easily do things like:

* Run tasks **in sequence**
* Combine multiple tasks
* Handle success or failure automatically

👉 `CompletableFuture` solves all that — it lets us **chain**, **combine**, and **react** to async tasks easily.

---

## 🧪 Example 1: Basic Async Task

```java
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data...");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            return "Data from server";
        });

        // Wait and print result
        System.out.println("Result: " + future.join());
    }
}
```

### 🧠 Explanation:

* `supplyAsync()` runs in a background thread and returns a result (`String` here).
* `.join()` waits for the result (like `.get()` but simpler for examples).

🕒 Output:

```
Fetching data...
Result: Data from server
```

---

## 🔗 Example 2: Chaining with thenApply and thenAccept

```java
CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
    System.out.println("Fetching data...");
    try { Thread.sleep(2000); } catch (InterruptedException e) {}
    return "Data from server";
})
.thenApply(data -> data.toUpperCase())  // process the result
.thenAccept(result -> System.out.println("Processed: " + result)); // print it
```

### Explanation:

| Step | Method          | Description                     | Return Type                 |
| ---- | --------------- | ------------------------------- | --------------------------- |
| 1    | `supplyAsync()` | Runs async and **returns** data | `CompletableFuture<String>` |
| 2    | `thenApply()`   | **Transforms** result           | `CompletableFuture<String>` |
| 3    | `thenAccept()`  | **Consumes** result (no return) | `CompletableFuture<Void>`   |

So the final type becomes **`CompletableFuture<Void>`**,
because we only print the result — no value is returned anymore.

---

## 🔁 Example 3: Combining Tasks

```java
CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> "Hello");
CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> "World");

CompletableFuture<String> combined = task1.thenCombine(task2, (a, b) -> a + " " + b);

System.out.println(combined.join());
```

🧩 Output:

```
Hello World
```

---

## 💥 Example 4: Handling Errors

```java
CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
    if (true) throw new RuntimeException("Error fetching data");
    return "Data";
}).exceptionally(ex -> "Fallback data");

System.out.println(future.join());
```

✅ Output:

```
Fallback data
```

---

## 🧾 Summary

| Method            | Description                                                       |
| ----------------- | ----------------------------------------------------------------- |
| `supplyAsync()`   | Runs a task that **returns a result**                             |
| `runAsync()`      | Runs a task that **does not return** anything                     |
| `thenApply()`     | Transforms the result                                             |
| `thenAccept()`    | Consumes the result                                               |
| `thenRun()`       | Runs code after task finishes (no input or output)                |
| `thenCombine()`   | Combines two futures’ results                                     |
| `exceptionally()` | Handles exceptions                                                |
| `join()`          | Waits for completion and gets result (throws unchecked exception) |

---

## 🧠 Real-life Analogy

Think of it like **ordering food online**:

* `supplyAsync()` → You place the order.
* `thenApply()` → The restaurant prepares and packs it.
* `thenAccept()` → You receive it and eat it.
* `exceptionally()` → If something goes wrong, you get a refund or replacement.

---
