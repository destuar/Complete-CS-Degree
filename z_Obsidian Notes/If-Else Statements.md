Allows code to be executed conditionally based on whether a specified condition is `true` or `false`. They’re fundamental for making decisions in a program.
### Basic Syntax:

`if (condition) {     
	`// if the condition is true 
`} else {     
	`// if the condition is false 
`}`

1. **Condition**: A boolean expression evaluated by the `if` statement.
2. **If Block**: Runs only if the condition is `true`.
3. **Else Block**: (Optional) Runs only if the condition is `false`.

### `else if` Statements
You can chain multiple conditions using `else if` for more complex decision-making.

`int score = 85;  

`if (score >= 90) {     
	`System.out.println("Grade: A"); 
`} else if (score >= 80) {     
	`System.out.println("Grade: B"); 
`} else if (score >= 70) {     
	`System.out.println("Grade: C"); 
`} else {     
	`System.out.println("Grade: F"); 
`}`

### Nested `if` Statements
You can also nest `if` statements for more specific cases within broader conditions.

`int age = 20; 
`boolean hasID = true; 

`if (age >= 18) { 
	`if (hasID) { 
		`System.out.println("Enter."); 
	`} else { 
		`System.out.println("Show ID."); 
	`} 
`} else {
	`System.out.println("Not old enough."); 
`}`

Tags:
[[Java]]