**Also called De Morgan's Theorems, Morgan's Law is a method to negate [[Boolean]] tests.**

Negations distribute over logical AND (∧) and OR (∨) operations.

- **First Law (¬(A ∧ B) = ¬A ∨ ¬B)**:
    
    - When you negate an AND operation, it becomes an OR with each term negated.
    - Example in coding:  
        `if not (A and B):` is equivalent to `if (not A) or (not B):`
        
- **Second Law (¬(A ∨ B) = ¬A ∧ ¬B)**:
    
    - When you negate an OR operation, it becomes an AND with each term negated.
    - Example in coding:  
        `if not (A or B):` is equivalent to `if (not A) and (not B):`