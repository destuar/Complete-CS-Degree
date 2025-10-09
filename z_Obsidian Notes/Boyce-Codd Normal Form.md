# Boyce-Codd Normal Form

**Boyce-Codd Normal Form** (BCNF) is a stringent normal form in relational database design that eliminates all anomalies based on functional dependencies. BCNF is stricter than Third Normal Form (3NF) and requires that every determinant in a non-trivial functional dependency must be a superkey.

## Definition

A relation $R$ is in **Boyce-Codd Normal Form** if for every non-trivial functional dependency $X \rightarrow Y$:
$$X \text{ is a superkey of } R$$

**Alternative Statement**: Every determinant must be a candidate key or superkey.

## Key Properties

### **Requirements**

1. **Must satisfy 1NF, 2NF, and 3NF** (typically)
2. **Superkey Constraint**: For all non-trivial FDs $X \rightarrow Y$, $X$ must be a superkey
3. **No Exceptions**: Unlike 3NF, there are no exceptions even for prime attributes

### **Difference from 3NF**

**3NF allows**: $X \rightarrow Y$ where $Y$ is part of a candidate key (prime attribute), even if $X$ is not a superkey

**BCNF requires**: $X$ must always be a superkey - no exceptions

**Consequence**: BCNF is stricter than 3NF; all BCNF relations are in 3NF, but not all 3NF relations are in BCNF

## Example

**CourseSchedule**(Student, Time, Room, Instructor)

**Functional Dependencies:**
- Student, Time $\rightarrow$ Room, Instructor (candidate key)
- Instructor $\rightarrow$ Room (instructor always uses same room)

**BCNF Violation**: 
- The FD Instructor $\rightarrow$ Room violates BCNF
- Instructor is NOT a superkey (doesn't determine all attributes)
- Causes redundancy: Room is repeated for each class the instructor teaches

**BCNF Decomposition:**
1. **InstructorRooms**(Instructor, Room)
   - Instructor $\rightarrow$ Room, where Instructor is the key ✓
2. **Schedule**(Student, Time, Instructor)
   - Student, Time $\rightarrow$ Instructor, where {Student, Time} is the key ✓

## Testing for BCNF

**Algorithm:**
```
For each non-trivial FD X → Y:
   Compute X+ (closure of X)
   If X+ ≠ all attributes:
      R is not in BCNF
      X → Y violates BCNF
Return "R is in BCNF"
```

## Decomposition Algorithm

```
BCNF_Decompose(R, F):
   If R is in BCNF:
      Return {R}
   
   Find X → Y that violates BCNF (X is not a superkey)
   
   Compute X+
   
   Decompose into:
   - R1 = X+
   - R2 = X ∪ (R - X+)
   
   Recursively decompose R1 and R2
   
   Return union of results
```

## Properties of BCNF

### **Guarantees**

- **Lossless Join**: BCNF decomposition always preserves lossless join property
- **Anomaly Elimination**: Completely eliminates update, insertion, and deletion anomalies based on functional dependencies
- **No Redundancy**: Eliminates all FD-based redundancy

### **Trade-offs**

- **Dependency Preservation**: May be lost - some functional dependencies might require joins to check
- **More Relations**: May require more decomposition than 3NF, resulting in more tables
- **Query Complexity**: More joins may be needed for certain queries

## When to Use BCNF

**Prefer BCNF when:**
- Data integrity is critical
- Update anomalies must be completely eliminated
- Storage efficiency is important
- Dependency preservation can be sacrificed or enforced through application logic

**Consider 3NF instead when:**
- Dependency preservation is required
- Some redundancy is acceptable for query performance
- Application can handle constraint checking
- Simpler schema structure is desired

## Problems Solved by BCNF

1. **Update Anomalies**: Eliminates need to update multiple tuples when one fact changes
2. **Insertion Anomalies**: Prevents inability to store certain facts without unrelated data
3. **Deletion Anomalies**: Avoids unintended loss of information when deleting tuples
4. **Redundancy**: Removes all FD-based data duplication

## Important Notes

- BCNF is the highest normal form based solely on functional dependencies
- Fourth Normal Form (4NF) extends BCNF to handle multivalued dependencies
- Not all databases need BCNF - the appropriate level depends on requirements
- BCNF decomposition is algorithmic and deterministic
- Some real-world designs intentionally denormalize from BCNF for performance

## Related Concepts

- **[[Functional Dependencies]]**: Foundation of BCNF; defines deterministic relationships between attributes
- **[[Normal Form]]**: BCNF is one level in the progressive hierarchy of normal forms
- **[[Relational Design]]**: BCNF guides the overall database design process
- **[[Decomposition]]**: Technique used to achieve BCNF
- **[[Multivalued Dependencies]]**: Basis for extending beyond BCNF to 4NF
- **[[Relation]]**: The structure being normalized to BCNF
- **[[Schema]]**: The formal specification that should satisfy BCNF constraints

