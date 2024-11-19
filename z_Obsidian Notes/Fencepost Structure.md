The **fencepost structure** (or **off-by-one error**) is a programming pattern used when iterating through a sequence where you need to include boundary elements or control separators.

This idea relates to building a fence- if you have 5 sections, you’ll need 6 posts: **one more post than sections**. This "extra" post represents boundary conditions in programming, often requiring an adjustment to avoid leaving out the first or last element.

**Adding Separators Between Items**: Example... printing a list of items separated by commas, without a trailing comma after the last item.
    
    **Example**:  
    `int[] num = {1, 2, 3, 4};
    `for (int i = 0; i < num.length; i++) {
		`System.out.print(numbers[i]);
		`if (i < num.length - 1) { 
		    `System.out.print(", ");
		``} 
	`}`

Tags:
[[Java]]
[[Object-Oriented Programming]]