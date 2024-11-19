**A template for a new type of [[Object]]s.**

For example, a class might be the blueprints for how to build an object.

A **class** can contain-
`public class BankAcc {`

**fields** = data stored in each object
	`private String name;`
	`private double balance;`
	
**constructors** = initializes new objects
	`public BankAcc(String nm, double bal) {
		`name = nm;`
		`balance = bal;`
	`}`
	
**[[method]]s** = behavior in each object
	`public void withdraw(double amount) {`
		`if(amount > 0.00 && amount <= balance) {`
			`balance -= amount;`
		`}`
	`}`
`}`

Tags:
[[Java]]
[[Python]]
[[C++]]

