**A 2D array (also called a two-dimensional [[Array]]) is essentially an "array of arrays." It allows you to store data in a grid or matrix format, making it useful for applications like tables and matrices.**

- **Definition**:
    - A 2D array in Java is declared as `dataType[][] arrayName`.

    - Example:
        `int[][] matrix = new int[3][4]; // A 3x4 matrix (3 rows, 4 columns)`
        
- **Fixed Size**:
    - Just like 1D arrays, 2D arrays in [[Java]] are fixed in size once created. You define the number of rows and columns at the time of creation, and you cannot resize them directly.
    - However, each row can have a different length, making "jagged arrays" possible, where each row may have a different number of columns.