**A way to form new classes based on existing classes, taking on their attributes/behavior.**
- A way to group related classes and share code between them.
- One class can *extend* another, absorbing its data/behavior.

Java: `class Dog extends Animal { }`
Python: `class Dog(Animal):`
C++" `class Dog : public Animal { }`

In each of these languages, inheritance allows a [[class]] (like `Dog`) to extend or inherit from another class (like `Animal`). By doing so, `Dog` inherits all the properties (data) and [[method]]s (behaviors) of `Animal`, while still being able to add or override its own unique properties and behaviors.

Tags:
[[Java]]
[[Python]]
[[C++]]