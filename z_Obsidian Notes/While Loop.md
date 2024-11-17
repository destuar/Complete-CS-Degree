**TLDR: Use a [[For Loop]] when you know how many times you want a block of code repeatedly executed. Use a while loop when you don't know how many times.**

Repeatedly executes a block of code as long as a specified condition is `true`. It can be used when the repetition should depend on a condition that may change within the loop.

### Basic Syntax:

`while (condition) {     
	`// code to be executed 
`}`

1. **Condition**: This is a boolean expression evaluated before each iteration of the loop. If it’s `true`, the loop continues; if it’s `false`, the loop stops.
2. **Loop Body**: The code inside the loop that executes with each iteration.