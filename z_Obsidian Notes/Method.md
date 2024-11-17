A block of code within a class that performs a specific task. Methods are used to define the behavior of objects and encapsulate functionality that can be reused throughout a program. A method can accept inputs (parameters), perform actions, and optionally return a result.
### Basic Syntax:

`returnType methodName(pType pName) { 
	`return someValue;  
`}`

### Example:

`public int add(int a, int b) { 
	`return a + b; 
`}`

In this example, the `add` method takes two integer parameters, adds them, and returns the result as an integer.

**Key Points**:

- **Return Type**: Specifies the type of value the method will return. If it doesn’t return anything, the return type is `void`.
- **Method Name**: The identifier used to call the method.
- **Parameters**: Optional inputs for the method to use.
- **Method Body**: The code that defines what the method does.