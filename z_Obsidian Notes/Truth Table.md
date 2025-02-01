A **truth table** is a tabular representation of the output of a logical expression for all possible combinations of its inputs. It is commonly used in Boolean algebra, logic circuits, and propositional logic.

#### **Structure of a Truth Table**

- **Columns** represent the input variables and their possible values.
- **Rows** list all possible combinations of inputs.
- **Final column(s)** show the output of the logical expression.

#### **Basic Truth Tables**

1. **Negation ($¬P$)**
    
    `| P | ¬P | 
    `|---|----| 
    `| T |  F | 
    `| F |  T | `
    
    - If $P$ is **true**, then $¬P$ is false, and vice versa.

2. **Conjunction ($P∧Q$)** (AND)
    
    `| P | Q | P ∧ Q| 
    `|---|---|------| 
    `| T | T |  T   | 
    `| T | F |  F   | 
    `| F | T |  F   | 
    `| F | F |  F   | `
    
    - The output is **true** only if both $P$ and $Q$ are true.

3. **Disjunction ($P∨Q$)** (OR)
    
    `| P | Q | P ∨ Q| 
    `|---|---|------| 
    `| T | T |  T   | 
    `| T | F |  T   | 
    `| F | T |  T   | 
    `| F | F |  F   |`
    
    - The output is **true** if at least one of $P$ or $Q$ is true.

4. **Exclusive OR ($P⊕Q$)** (XOR)
    
    `| P | Q |P ⊕ Q| 
    `|---|---|------| 
    `| T | T |  F   | 
    `| T | F |  T   | 
    `| F | T |  T   | 
    `| F | F |  F   |`
    
    - The output is **true** only if exactly one of $P$ or $Q$ is true.

5. **Implication ($P→Q$)**
    
    `| P | Q | P → Q| 
    `|---|---|------| 
    `| T | T |  T   | 
    `| T | F |  F   | 
    `| F | T |  T   | 
    `| F | F |  T   |`
    
    - The output is **false** only when $P$ is true and $Q$ is false.

6. **Biconditional ($P↔Q$)** (If and only if, IFF)
    
    `| P | Q | P ↔ Q| 
    `|---|---|------| 
    `| T | T |  T   | 
    `| T | F |  F   | 
    `| F | T |  F   | 
    `| F | F |  T   |`
    
    - The output is **true** if both $P$ and $Q$ are either true or false.