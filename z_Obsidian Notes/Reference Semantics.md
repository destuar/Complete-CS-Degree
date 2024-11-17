**Behavior where variables actually store the address of an object in memory. (*used with arrays/objects*)

- When a variable is assigned to another, both refer to the *same* object.
- Modifying the value of one variable *will* affect the others.

	`int[] a1 = {4, 15, 8};`
	`int[] a2 = a1;`       // *(a1/a2 both changed)*
	
	**`a2[0] = 7;`**
	**`println(arrays.toString(a1));`** // *[7, 15, 8]*

Tags:
[[Java]]
[[Python]]
[[C++]]
[[Array]]