# Procedural Programming

**Procedural Programming** is a [programming paradigm](https://en.wikipedia.org/wiki/Procedural_programming) based on the concept of the **procedure call**. It is "verb-oriented," emphasizing a sequence of computational steps or subroutines to be performed.

## Basic Definitions
- **Procedures**: Also known as routines, subroutines, or functions (in C/C++).
- **Imperative**: Focuses on explicitly describing *how* to operate, step-by-step.
- **Side Effects**: Functions often modify state or shared data (via pointers or references) rather than just returning values.

## Key Characteristics
- **Sequence**: Code executes in a defined order (top-to-bottom).
- **Modularity**: Logic is broken into reusable procedures.
- **State Mutation**: Heavy reliance on variables and memory modification.

## Comparison to Other Paradigms
- **Vs. [[Object-Oriented Programming]]**: Procedural focuses on actions (verbs), while OOP focuses on the data objects (nouns) being acted upon.
- **Vs. [[Functional Programming]]**: Procedural allows side effects and state mutation; Functional emphasizes immutability and pure functions.

## Examples
- **Languages**: [[C++]] (in C style), C, Pascal, Fortran.
- **Structure**:
  ```c
  void processData(int* data, int size) {
      for (int i = 0; i < size; i++) {
          data[i] = data[i] * 2; // Direct state mutation
      }
  }
  ```

## Advantages & Disadvantages
- **Pros**: Efficient, close to hardware (good for systems programming), intuitive for sequential tasks.
- **Cons**: Difficult to reason about shared state in complex systems; harder to parallelize than functional code.
