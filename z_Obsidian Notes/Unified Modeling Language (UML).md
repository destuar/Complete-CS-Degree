# Unified Modeling Language (UML)

The **Unified Modeling Language** (UML) is a standardized visual modeling language used to specify, design, and document object-oriented systems. In database design, UML provides a graphical notation for expressing data models through diagrams that capture classes, relationships, and constraints.

## Basic Definition

UML for data modeling focuses on:

- **Classes**: Entities with attributes and methods (similar to relations)
- **Associations**: Relationships between objects of different classes
- **Structural Constraints**: Rules governing how objects relate to each other
- **Inheritance**: Hierarchical relationships through subclassing
- **Aggregation/Composition**: "Part-of" relationships between objects

## Classes

**Classes** in UML are similar to relations in the relational model and serve as templates for objects.

### **Structure**

A class consists of three main components:

1. **Class Name**: Identifier for the entity (e.g., "Student", "College")
2. **Attributes**: Properties of the class with data types
   - Primary keys are specified (often marked as PK)
   - Each attribute has a name and optionally a type
3. **Methods**: Operations on the class (often dropped in data modeling contexts)

### **Example**

**Student Class**:
- Class name: `Student`
- Attributes:
  - `student ID` (PK)
  - `student name`
  - `GPA`
- Methods: (typically omitted for data modeling)

**Visual Representation**:
```
┌──────────────┐
│   Student    │
├──────────────┤
│ student ID   │ (PK)
│ student name │
│ GPA          │
├──────────────┤
│ (methods)    │
└──────────────┘
```

### **Attributes and Primary Keys**

- **Primary Key (PK)**: Uniquely identifies each instance of the class
- **Attributes**: Define the properties stored for each object
- **Data Types**: Can be specified (integer, string, date, etc.)
- **Optional vs. Required**: Attributes can be marked as nullable or required

## Associations

**Associations** capture relationships between objects of two different classes. They represent how instances of one class are connected to instances of another class.

### **Basic Association**

- **Representation**: Line connecting two classes
- **Name**: Describes the relationship (e.g., "applies to", "enrolls in")
- **Directionality**: Can indicate the reading direction with an arrow
- **Example**: "Students apply to colleges"

### **Visual Notation**

```
┌─────────┐              ┌─────────┐
│ Student │─────────────>│ College │
└─────────┘   applies to └─────────┘
```

### **Directionality**

- **Unidirectional**: Arrow indicates reading direction (Student → College: "Student applies to College")
- **Bidirectional**: No arrow or arrows both ways (can read in either direction)
- **Named Relationships**: Association name clarifies the relationship meaning

## Multiplicity of Associations

**Multiplicity** specifies how many objects of one class can be related to objects of another class. This captures cardinality constraints in the relationship.

### **Notation**

- **M..N**: Minimum of M and maximum of N objects
- **star (*)**: Any number (zero or more)
- **1**: Exactly one
- **0..1**: Zero or one (optional)
- **1..***: One or more (at least one)

### **Common Relationship Types**

**One-to-One (1:1)**:
```
┌─────────┐ 1         1 ┌─────────┐
│ Country │─────────────│ Capital │
└─────────┘             └─────────┘
```
Each country has exactly one capital; each capital belongs to one country.

**Many-to-One (M:1)**:
```
┌──────────┐ *         1 ┌────────────┐
│ Employee │─────────────│ Department │
└──────────┘ works in    └────────────┘
```
Many employees work in one department; each department has many employees.

**Many-to-Many (M:N)**:
```
┌─────────┐ *         * ┌─────────┐
│ Student │─────────────│ Course  │
└─────────┘ enrolls in  └─────────┘
```
Many students enroll in many courses; each course has many students.

**Optional Relationships (0..*)**:
```
┌─────────┐ 0..*      * ┌─────────┐
│ Student │─────────────│ Club    │
└─────────┘ joins      └─────────┘
```
Students may join zero or more clubs; clubs have zero or more students.

### **Multiplicity Constraints**

- **Lower Bound**: Minimum number of related objects (0 means optional)
- **Upper Bound**: Maximum number of related objects (* means unlimited)
- **Participation**: Total (must participate) vs. partial (may participate)
- **Examples**: 
  - `1..3`: Between 1 and 3 objects
  - `2..*`: At least 2 objects
  - `0..1`: Optional, at most one

## Association Classes

**Association Classes** generalize associations by allowing attributes to be attached directly to the association itself, rather than to either participating class.

### **Purpose**

- **Relationship Attributes**: Properties that belong to the relationship, not to either entity
- **Complex Relationships**: When the association itself has meaningful data
- **Avoid Redundancy**: Prevents storing relationship data in either participating class

### **Example**

**Student-College Application**:

```
┌─────────┐ *         * ┌─────────┐
│ Student │─────────────│ College │
└─────────┘             └─────────┘
              │
              │ Applied
              │
        ┌─────────────┐
        │   Applied   │
        ├─────────────┤
        │ date        │
        │ decision    │
        │ major       │
        └─────────────┘
```

**Attributes**:
- `date`: When the application was submitted
- `decision`: Accepted, rejected, pending
- `major`: Major applied for

### **When to Use Association Classes**

- **M:N Relationships with Attributes**: The relationship itself has properties
- **Temporal Data**: Recording when or how the relationship exists
- **Relationship-Specific Details**: Information that doesn't belong to either entity alone
- **Examples**: 
  - Enrollment (Student-Course) with grade, semester
  - Employment (Person-Company) with start date, salary, title
  - Purchase (Customer-Product) with quantity, price, date

## Subclasses (Inheritance)

**Subclasses** in UML support hierarchical relationships where a superclass (generalization) can have subclasses (specializations) that inherit attributes and can define their own specific attributes.

### **Inheritance Hierarchy**

- **Superclass (Generalization)**: Parent class with common attributes
- **Subclass (Specialization)**: Child class inheriting from superclass
- **Inheritance**: Subclasses automatically have all superclass attributes
- **Additional Attributes**: Subclasses can add their own specific attributes

### **Visual Notation**

```
        ┌─────────┐
        │ Student │
        ├─────────┤
        │ ID      │
        │ name    │
        └────△────┘
             │
      ┌──────┴──────┐
      │             │
┌─────────┐   ┌───────────┐
│ Domestic│   │ Foreign   │
├─────────┤   ├───────────┤
│ state   │   │ country   │
│ SSN     │   │ visa_type │
└─────────┘   └───────────┘
```

The triangle (△) indicates the inheritance relationship, pointing to the superclass.

### **Completeness**

**Complete (Total Specialization)**:
- Every superclass object must belong to at least one subclass
- No superclass instances exist without being in a subclass
- Example: Every student is either domestic or foreign
- **Notation**: Often marked with "complete" or filled constraint

**Incomplete/Partial**:
- Superclass objects may exist without belonging to any subclass
- Some instances are only in the superclass, not specialized
- Example: Some employees are managers, but many are just employees
- **Notation**: Often marked with "incomplete" or "partial"

### **Overlap**

**Disjoint (Exclusive)**:
- An object can be in at most one subclass
- Subclasses are mutually exclusive
- Example: A student is either undergraduate OR graduate, not both
- **Notation**: Often marked with "disjoint" or {disjoint}

**Overlapping (Inclusive)**:
- An object can belong to multiple subclasses simultaneously
- Subclasses are not mutually exclusive
- Example: A person can be both an employee AND a student
- **Notation**: Often marked with "overlapping" or {overlapping}

### **Constraint Combinations**

- **Complete + Disjoint**: Every object in exactly one subclass (partition)
- **Complete + Overlapping**: Every object in at least one subclass, possibly multiple
- **Incomplete + Disjoint**: Some objects in zero or one subclass
- **Incomplete + Overlapping**: Some objects in any number of subclasses (most flexible)

### **Example Scenarios**

**Complete & Disjoint** (Student → Undergraduate, Graduate):
```
Every student is exactly one of: undergraduate or graduate
```

**Incomplete & Overlapping** (Person → Student, Employee):
```
A person might be:
- Neither student nor employee
- A student only
- An employee only  
- Both a student and an employee
```

## Composition and Aggregation

Both composition and aggregation represent "part-of" or "belongs to" relationships, but with different strengths of ownership and lifecycle dependency.

### **Composition (Strong Ownership)**

**Definition**: A strong "belongs to" relationship where parts are intrinsically owned by the whole and cannot exist independently.

**Characteristics**:
- **Strong Ownership**: Parts belong to exactly one whole
- **Lifecycle Dependency**: Parts are created and destroyed with the whole
- **Exclusive Membership**: A part cannot belong to multiple wholes
- **Cascading Delete**: Deleting the whole deletes all parts

**Visual Notation**: Filled (solid) diamond on the association line at the whole end
```
┌──────────┐ ◆────────── ┌──────┐
│  House   │             │ Room │
└──────────┘  contains   └──────┘
```

**Examples**:
- House and Rooms (rooms are part of the house)
- Car and Engine (engine belongs to the car)
- Document and Paragraphs (paragraphs are part of the document)
- Order and Order Lines (order lines exist only within an order)

### **Aggregation (Weak Ownership)**

**Definition**: A weaker "belongs to" relationship where parts can exist independently of the whole and may be shared.

**Characteristics**:
- **Weak Ownership**: Parts may exist independently
- **Independent Lifecycle**: Parts can outlive the whole
- **Shared Membership**: A part can belong to multiple wholes
- **No Cascading Delete**: Deleting the whole doesn't delete parts

**Visual Notation**: Open (hollow) diamond on the association line at the whole end
```
┌────────────┐ ◇────────── ┌─────────┐
│ Department │             │ Faculty │
└────────────┘  has        └─────────┘
```

**Examples**:
- Department and Faculty (faculty can exist without department)
- Library and Books (books exist independently)
- Team and Players (players can switch teams or exist without one)
- Playlist and Songs (songs exist independently of playlists)

### **Composition vs. Aggregation Comparison**

| Aspect | Composition | Aggregation |
|--------|-------------|-------------|
| **Diamond** | Filled (◆) | Open (◇) |
| **Ownership** | Strong | Weak |
| **Lifecycle** | Dependent | Independent |
| **Exclusivity** | Exclusive | Shared |
| **Delete Cascade** | Yes | No |
| **Example** | House-Room | Department-Faculty |

### **When to Use Each**

**Use Composition when**:
- Parts cannot exist without the whole
- Parts have no independent identity
- Deleting the whole should delete the parts
- Parts belong exclusively to one whole

**Use Aggregation when**:
- Parts can exist independently
- Parts have their own identity
- Parts may be shared among multiple wholes
- Deleting the whole should preserve the parts

## UML for Database Design

### **Mapping to Relational Model**

**Classes → Relations (Tables)**:
- Each class becomes a table
- Attributes become columns
- Primary keys identify unique instances

**Associations → Foreign Keys**:
- One-to-many: Foreign key in the "many" side
- Many-to-many: Junction/bridge table with foreign keys from both sides
- One-to-one: Foreign key in either table (or both with uniqueness constraint)

**Subclasses → Tables**:
- **Single Table**: All subclass attributes in one table with discriminator column
- **Table Per Class**: Separate tables for superclass and each subclass
- **Table Per Concrete Class**: Only subclass tables with inherited attributes duplicated

**Association Classes → Tables**:
- Separate table with foreign keys to both participating classes
- Association attributes become columns in this table

## Important Notes

- **Data Modeling Focus**: Methods are typically omitted when using UML for database design
- **Multiplicity Matters**: Correctly specifying cardinality constraints is crucial for proper database design
- **Normalization**: UML diagrams should reflect normalized designs to avoid redundancy
- **Translation Challenges**: Some UML constructs map more cleanly to relational models than others
- **Tool Support**: Many CASE tools support UML-to-database code generation

## Related Concepts

- **[[Data Model]]**: UML is a visual notation for expressing data models
- **[[Relational Database]]**: Target implementation for UML class diagrams
- **[[Schema]]**: UML diagrams specify database schemas
- **[[Class]]**: Core concept in UML representing entities
- **[[Relation]]**: Relational equivalent of UML classes
- **[[Object-Oriented Programming]]**: UML originates from OOP design
- **[[Relational Design]]**: Process of creating well-structured relational schemas
- **[[Functional Dependencies]]**: Constraints that guide normalization of UML designs
- **[[Normal Form]]**: Design goals for eliminating redundancy in UML models

