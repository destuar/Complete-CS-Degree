# Functional Programming

**Functional Programming** is a programming paradigm that treats computation as the evaluation of **mathematical functions** and avoids changing-state and mutable data.

## Basic Definitions
- **Pure Functions**: Functions that always produce the same output for the same input and have no side effects (e.g., they do not modify global variables or input arguments).
- **Immutability**: Data cannot be changed once created. Instead of modifying objects, new objects are created.

## Key Concepts
- **First-Class Functions**: Functions can be passed as arguments to other functions, returned as values, and assigned to variables.
- **Higher-Order Functions**: Functions that take other functions as input or return them as output (e.g., `map`, `filter`, `reduce`).
- **Recursion**: Used as a primary control structure instead of loops.

## Relations to Other Paradigms
- **Vs. [[Procedural Programming]]**: Functional programming minimizes side effects, whereas procedural programming relies on them.
- **Vs. [[Object-Oriented Programming]]**: Functional programming emphasizes verbs (functions) and data transformation, while OOP encapsulates state within objects.

## Applications
- **Concurrency**: Easir to parallelize due to lack of shared mutable state.
- **Mathematical Modeling**: Closer to mathematical logic (Lambda Calculus).

## Examples
- **Languages**: Lisp, Scheme, Haskell, Erlang. (Also supported in Python, JavaScript, [[C++]]).
