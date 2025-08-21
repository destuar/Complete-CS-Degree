# XML Schema (XSD)

**XML Schema Definition (XSD)** is a W3C specification that provides a powerful and flexible way to define the structure, content, and semantics of XML documents. XSD serves as an alternative to DTD (Document Type Definition) and offers more sophisticated validation capabilities, including data types, constraints, and complex content models. It enables developers to create precise, machine-readable specifications for XML document validation and serves as the foundation for data exchange standards and web services.

## Basic Definition

XSD is a **schema language** that defines the rules and constraints for XML documents. Unlike DTDs, which use a non-XML syntax, XSD is written in XML itself, making it more consistent with the documents it validates. XSD provides:

- **Data Type System**: Rich set of built-in and user-defined data types
- **Content Model Validation**: Complex element and attribute constraints
- **Namespace Support**: Full integration with XML namespaces
- **Extensibility**: Inheritance and composition mechanisms
- **XML Syntax**: Self-describing schema definitions

## Core XSD Concepts

### **Schema Structure**
- **Root Element**: `<xs:schema>` containing all schema definitions
- **Namespace Declaration**: XML Schema namespace and target namespaces
- **Element Definitions**: Structure and content rules for XML elements
- **Type Definitions**: Simple and complex data types
- **Attribute Declarations**: Rules for element attributes

### **XSD vs DTD Comparison**
- **XML Syntax**: XSD uses XML syntax, DTD uses non-XML syntax
- **Data Types**: XSD has rich type system, DTD has limited types
- **Namespaces**: XSD fully supports namespaces, DTD has limited support
- **Validation**: XSD provides more precise validation rules
- **Extensibility**: XSD supports inheritance and composition

## Basic Schema Structure

### **Schema Declaration**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://example.com/library"
           xmlns="http://example.com/library"
           elementFormDefault="qualified"
           attributeFormDefault="unqualified">
    
    <!-- Schema content goes here -->
    
</xs:schema>
```

### **Namespace Attributes**
- **xmlns:xs**: XML Schema namespace prefix
- **targetNamespace**: Namespace for elements defined in this schema
- **xmlns**: Default namespace for the target namespace
- **elementFormDefault**: Whether elements must be namespace-qualified
- **attributeFormDefault**: Whether attributes must be namespace-qualified

## Element Definitions

### **Simple Element Declaration**
```xml
<!-- Basic simple element -->
<xs:element name="title" type="xs:string"/>

<!-- Element with default value -->
<xs:element name="category" type="xs:string" default="general"/>

<!-- Element with fixed value -->
<xs:element name="version" type="xs:string" fixed="1.0"/>

<!-- Element with occurrence constraints -->
<xs:element name="tag" type="xs:string" minOccurs="0" maxOccurs="unbounded"/>
```

### **Complex Element Declaration**
```xml
<xs:element name="book">
    <xs:complexType>
        <xs:sequence>
            <xs:element name="title" type="xs:string"/>
            <xs:element name="author" type="xs:string"/>
            <xs:element name="publication_year" type="xs:integer"/>
            <xs:element name="isbn" type="xs:string"/>
        </xs:sequence>
        <xs:attribute name="id" type="xs:ID" use="required"/>
        <xs:attribute name="category" type="xs:string" use="optional"/>
    </xs:complexType>
</xs:element>
```

### **Content Model Compositors**
- **xs:sequence**: Elements must appear in specified order
- **xs:choice**: Only one element from the group can appear
- **xs:all**: Elements can appear in any order (maxOccurs ≤ 1)
- **xs:group**: Reusable content model definitions

## Data Types

### **Built-in Simple Types**
```xml
<!-- String types -->
<xs:element name="name" type="xs:string"/>
<xs:element name="token" type="xs:token"/>
<xs:element name="normalizedString" type="xs:normalizedString"/>

<!-- Numeric types -->
<xs:element name="age" type="xs:integer"/>
<xs:element name="price" type="xs:decimal"/>
<xs:element name="quantity" type="xs:positiveInteger"/>
<xs:element name="rating" type="xs:float"/>

<!-- Date and time types -->
<xs:element name="birth_date" type="xs:date"/>
<xs:element name="created_time" type="xs:dateTime"/>
<xs:element name="duration" type="xs:duration"/>

<!-- Boolean and binary types -->
<xs:element name="active" type="xs:boolean"/>
<xs:element name="image" type="xs:base64Binary"/>
<xs:element name="uuid" type="xs:hexBinary"/>
```

### **User-defined Simple Types**
```xml
<!-- Restriction of built-in types -->
<xs:simpleType name="ISBN">
    <xs:restriction base="xs:string">
        <xs:pattern value="\d{3}-\d{1}-\d{3}-\d{5}-\d{1}"/>
        <xs:length value="17"/>
    </xs:restriction>
</xs:simpleType>

<!-- Enumeration types -->
<xs:simpleType name="BookCategory">
    <xs:restriction base="xs:string">
        <xs:enumeration value="fiction"/>
        <xs:enumeration value="non-fiction"/>
        <xs:enumeration value="science-fiction"/>
        <xs:enumeration value="mystery"/>
    </xs:restriction>
</xs:simpleType>

<!-- Range restrictions -->
<xs:simpleType name="PublicationYear">
    <xs:restriction base="xs:integer">
        <xs:minInclusive value="1800"/>
        <xs:maxInclusive value="2024"/>
    </xs:restriction>
</xs:simpleType>
```

### **Complex Type Definitions**
```xml
<xs:complexType name="AuthorType">
    <xs:sequence>
        <xs:element name="first_name" type="xs:string"/>
        <xs:element name="last_name" type="xs:string"/>
        <xs:element name="email" type="xs:string" minOccurs="0"/>
        <xs:element name="biography" type="xs:string" minOccurs="0"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:ID" use="required"/>
    <xs:attribute name="nationality" type="xs:string" use="optional"/>
</xs:complexType>

<!-- Using the complex type -->
<xs:element name="author" type="AuthorType"/>
```

## Content Model Composition

### **Sequence Composition**
```xml
<xs:complexType name="BookType">
    <xs:sequence>
        <xs:element name="title" type="xs:string"/>
        <xs:element name="author" type="AuthorType"/>
        <xs:element name="publication_year" type="PublicationYear"/>
        <xs:element name="isbn" type="ISBN"/>
        <xs:element name="description" type="xs:string" minOccurs="0"/>
        <xs:element name="reviews" minOccurs="0">
            <xs:complexType>
                <xs:sequence>
                    <xs:element name="review" type="ReviewType" maxOccurs="unbounded"/>
                </xs:sequence>
            </xs:complexType>
        </xs:element>
    </xs:sequence>
    <xs:attribute name="id" type="xs:ID" use="required"/>
    <xs:attribute name="category" type="BookCategory" use="required"/>
</xs:complexType>
```

### **Choice Composition**
```xml
<xs:complexType name="ContactInfo">
    <xs:choice>
        <xs:element name="email" type="xs:string"/>
        <xs:element name="phone" type="xs:string"/>
        <xs:element name="address">
            <xs:complexType>
                <xs:sequence>
                    <xs:element name="street" type="xs:string"/>
                    <xs:element name="city" type="xs:string"/>
                    <xs:element name="postal_code" type="xs:string"/>
                </xs:sequence>
            </xs:complexType>
        </xs:element>
    </xs:choice>
</xs:complexType>
```

### **All Composition**
```xml
<xs:complexType name="Metadata">
    <xs:all>
        <xs:element name="created_date" type="xs:date"/>
        <xs:element name="modified_date" type="xs:date"/>
        <xs:element name="creator" type="xs:string"/>
        <xs:element name="version" type="xs:string"/>
    </xs:all>
</xs:complexType>
```

## Advanced Features

### **Type Inheritance & Extension**
```xml
<!-- Base type -->
<xs:complexType name="PersonType">
    <xs:sequence>
        <xs:element name="first_name" type="xs:string"/>
        <xs:element name="last_name" type="xs:string"/>
        <xs:element name="email" type="xs:string"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:ID" use="required"/>
</xs:complexType>

<!-- Extended type -->
<xs:complexType name="AuthorType">
    <xs:complexContent>
        <xs:extension base="PersonType">
            <xs:sequence>
                <xs:element name="biography" type="xs:string" minOccurs="0"/>
                <xs:element name="publications" type="xs:string" minOccurs="0"/>
            </xs:sequence>
            <xs:attribute name="genre" type="xs:string"/>
        </xs:extension>
    </xs:complexContent>
</xs:complexType>
```

### **Type Restriction**
```xml
<xs:complexType name="SimpleAuthorType">
    <xs:complexContent>
        <xs:restriction base="AuthorType">
            <xs:sequence>
                <xs:element name="first_name" type="xs:string"/>
                <xs:element name="last_name" type="xs:string"/>
                <xs:element name="email" type="xs:string"/>
            </xs:sequence>
            <xs:attribute name="id" type="xs:ID" use="required"/>
        </xs:restriction>
    </xs:complexContent>
</xs:complexType>
```

### **Abstract Types & Substitution Groups**
```xml
<!-- Abstract base type -->
<xs:element name="person" type="PersonType" abstract="true"/>

<!-- Substitution group members -->
<xs:element name="author" type="AuthorType" substitutionGroup="person"/>
<xs:element name="editor" type="EditorType" substitutionGroup="person"/>

<!-- Using substitution group -->
<xs:element name="staff">
    <xs:complexType>
        <xs:sequence>
            <xs:element ref="person" maxOccurs="unbounded"/>
        </xs:sequence>
    </xs:complexType>
</xs:element>
```

## Schema Organization

### **Import & Include**
```xml
<!-- Include schema from same namespace -->
<xs:include schemaLocation="common-types.xsd"/>

<!-- Import schema from different namespace -->
<xs:import namespace="http://example.com/common"
            schemaLocation="common.xsd"/>

<!-- Redefine schema components -->
<xs:redefine schemaLocation="base-schema.xsd">
    <xs:complexType name="ExtendedType">
        <xs:complexContent>
            <xs:extension base="BaseType">
                <xs:element name="additional_field" type="xs:string"/>
            </xs:extension>
        </xs:complexContent>
    </xs:complexType>
</xs:redefine>
```

### **Group & Attribute Group Definitions**
```xml
<!-- Element group -->
<xs:group name="BookElements">
    <xs:sequence>
        <xs:element name="title" type="xs:string"/>
        <xs:element name="author" type="AuthorType"/>
        <xs:element name="publication_year" type="PublicationYear"/>
    </xs:sequence>
</xs:group>

<!-- Attribute group -->
<xs:attributeGroup name="CommonAttributes">
    <xs:attribute name="id" type="xs:ID" use="required"/>
    <xs:attribute name="created_date" type="xs:date"/>
    <xs:attribute name="modified_date" type="xs:date"/>
</xs:attributeGroup>

<!-- Using groups -->
<xs:complexType name="BookType">
    <xs:group ref="BookElements"/>
    <xs:attributeGroup ref="CommonAttributes"/>
</xs:complexType>
```

## Validation & Constraints

### **Facets & Constraints**
```xml
<xs:simpleType name="StrictISBN">
    <xs:restriction base="xs:string">
        <!-- Pattern constraint -->
        <xs:pattern value="\d{3}-\d{1}-\d{3}-\d{5}-\d{1}"/>
        
        <!-- Length constraints -->
        <xs:length value="17"/>
        <xs:minLength value="17"/>
        <xs:maxLength value="17"/>
        
        <!-- White space handling -->
        <xs:whiteSpace value="collapse"/>
    </xs:restriction>
</xs:simpleType>

<xs:simpleType name="AgeRange">
    <xs:restriction base="xs:integer">
        <!-- Range constraints -->
        <xs:minInclusive value="0"/>
        <xs:maxInclusive value="150"/>
        
        <!-- Total digits constraint -->
        <xs:totalDigits value="3"/>
    </xs:restriction>
</xs:simpleType>
```

### **Assertion Constraints**
```xml
<xs:complexType name="ValidBook">
    <xs:sequence>
        <xs:element name="title" type="xs:string"/>
        <xs:element name="publication_year" type="xs:integer"/>
        <xs:element name="isbn" type="xs:string"/>
    </xs:sequence>
    <xs:assert test="publication_year >= 1800 and publication_year <= 2024"/>
    <xs:assert test="string-length(isbn) = 17"/>
</xs:complexType>
```

## Practical Examples

### **Complete Library Schema**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
           targetNamespace="http://example.com/library"
           xmlns="http://example.com/library"
           elementFormDefault="qualified">

    <!-- Simple type definitions -->
    <xs:simpleType name="ISBN">
        <xs:restriction base="xs:string">
            <xs:pattern value="\d{3}-\d{1}-\d{3}-\d{5}-\d{1}"/>
        </xs:restriction>
    </xs:simpleType>

    <xs:simpleType name="BookCategory">
        <xs:restriction base="xs:string">
            <xs:enumeration value="fiction"/>
            <xs:enumeration value="non-fiction"/>
            <xs:enumeration value="science-fiction"/>
        </xs:restriction>
    </xs:simpleType>

    <!-- Complex type definitions -->
    <xs:complexType name="AuthorType">
        <xs:sequence>
            <xs:element name="first_name" type="xs:string"/>
            <xs:element name="last_name" type="xs:string"/>
            <xs:element name="email" type="xs:string" minOccurs="0"/>
        </xs:sequence>
        <xs:attribute name="id" type="xs:ID" use="required"/>
    </xs:complexType>

    <xs:complexType name="BookType">
        <xs:sequence>
            <xs:element name="title" type="xs:string"/>
            <xs:element name="author" type="AuthorType"/>
            <xs:element name="publication_year" type="xs:integer"/>
            <xs:element name="isbn" type="ISBN"/>
            <xs:element name="description" type="xs:string" minOccurs="0"/>
        </xs:sequence>
        <xs:attribute name="id" type="xs:ID" use="required"/>
        <xs:attribute name="category" type="BookCategory" use="required"/>
    </xs:complexType>

    <!-- Root element -->
    <xs:element name="library">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="book" type="BookType" maxOccurs="unbounded"/>
            </xs:sequence>
        </xs:complexType>
    </xs:element>

</xs:schema>
```

## Best Practices

### **Schema Design Principles**
- **Modularity**: Break large schemas into smaller, reusable components
- **Consistency**: Use consistent naming conventions and structure
- **Documentation**: Include annotations and documentation
- **Validation**: Test schemas with sample XML documents
- **Performance**: Optimize for validation performance

### **Common Patterns**
- **Choice for Optional Content**: Use choice when content is mutually exclusive
- **Sequence for Ordered Content**: Use sequence when order matters
- **All for Unordered Content**: Use all when order doesn't matter
- **Extension for Inheritance**: Extend types rather than duplicating
- **Groups for Reusability**: Define common patterns as groups

## Tools & Technologies

### **Schema Development Tools**
- **XML Editors**: Visual schema creation and editing
- **Validation Tools**: Test XML documents against schemas
- **Documentation Generators**: Create human-readable schema documentation
- **Code Generators**: Generate code from schema definitions
- **Testing Frameworks**: Automated schema validation testing

### **Programming Language Support**
- **Java**: JAXB, Xerces, Apache XMLBeans
- **Python**: lxml, xmlschema libraries
- **C#/.NET**: System.Xml.Schema, LINQ to XSD
- **JavaScript**: xmldom, libxmljs
- **PHP**: DOMDocument, XMLReader

## Applications & Use Cases

### **Data Validation**
- **API Contracts**: Define data exchange formats
- **Configuration Files**: Validate application settings
- **Data Import**: Ensure imported data meets requirements
- **Form Validation**: Validate user input in web applications
- **Integration**: Standardize data exchange between systems

### **Documentation & Standards**
- **Industry Standards**: Define data formats for specific domains
- **API Documentation**: Generate documentation from schemas
- **Data Contracts**: Establish agreements between systems
- **Compliance**: Ensure data meets regulatory requirements
- **Training**: Use schemas to teach data structure concepts

## Key Features

### **Rich Type System**
- **Built-in Types**: Comprehensive set of primitive data types
- **User-defined Types**: Custom types with constraints and validation
- **Type Inheritance**: Extend and restrict existing types
- **Facets**: Fine-grained control over data validation
- **Assertions**: Complex validation rules and business logic

### **Content Model Control**
- **Sequence**: Ordered element sequences
- **Choice**: Alternative element selection
- **All**: Unordered element groups
- **Occurrence**: Control element frequency
- **Groups**: Reusable content model components

### **Namespace Integration**
- **Target Namespaces**: Define schema scope
- **Import/Include**: Modular schema organization
- **Redefine**: Override imported components
- **Substitution Groups**: Polymorphic element handling
- **Qualified Elements**: Control namespace qualification

## Important Notes

- **Validation Performance**: Complex schemas can impact validation speed
- **Schema Evolution**: Plan for backward compatibility when evolving schemas
- **Tool Support**: Ensure chosen tools support all XSD features
- **Testing**: Validate schemas with diverse XML documents
- **Documentation**: Maintain clear documentation for complex schemas

## Related Concepts

- **[[Extensible Markup Language (XML)]]**: Language that XSD validates
- **[[Schema]]**: Formal specification of data structure and organization
- **[[Relational Database]]**: Alternative data validation approach
- **[[Data Model]]**: Conceptual framework for data organization
- **[[Collection]]**: Abstract data type for grouping data items
