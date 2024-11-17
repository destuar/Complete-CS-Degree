**No code sharing, but there is [[Polymorphism]].**

**A list of methods that a class can promise to implement.**

- [[Inheritance]] gives you an is-a relationship *and* code sharing.
	- A `Lawyer` can be treated as an `Employee` and inherits its code.

Example:
`class Employee { 
    `void work() { System.out.println("Working"); } 
`}
`class Lawyer extends Employee { }
`
- Interfaces give you an is-a relationship *without* code sharing.
	- A `Rectangle` object can be treated as a `Shape` but inherits no code. 

Example:
`interface Shape {
    `double area();
`}
`class Rectangle implements Shape {
    `public double area() { return width * height; }
`}

*The class promises to contain each method in that interface (otherwise it will fail to compile).

Tags:
[[Java]]
[[Python]]
[[C++]]
