**Behavior where values are copied when assigned, passed as parameters, or returned. (*used with primitive types*)**

- When a variable is assigned to another, its value is *copied*
- Modifying a variable does not affect others.

	`int x = 5;`
	`int y = 5;`  // x = 5, y = 5 

	`y = 17;`       // x = 5, y = 17
	`x = 8;`         // x = 8, y = 17

	`x = y;`       // x = 17, y = 17
	`y++;`           // x = 17, y = 18
	`x--;`           // x = 16, y = 17

Tags:
[[Java]]
[[Python]]
[[C++]]