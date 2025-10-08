# Extensible Markup Language (XML)

**Extensible Markup Language (XML)** is a flexible, self-describing markup language designed to store and transport data in a hierarchical tree structure. It provides a standardized way to represent complex data, enabling data exchange between different systems and platforms.

## Basic Definition

XML is a **markup language** that uses custom tags to define data structure and meaning. Unlike HTML with predefined tags, XML allows users to create domain-specific tags.

**Key Characteristics**:
- **Hierarchical Tree Structure**: Data organized in nested parent-child relationships
- **Self-describing**: Tags indicate both structure and meaning
- **Platform-independent**: Works across different systems
- **Extensible**: Customizable for any domain or application

## Document Structure

### **Basic Components**
- **Root Element**: Single top-level element containing all other elements
- **Elements**: Data containers with opening and closing tags: `<element>content</element>`
- **Attributes**: Name-value pairs in tags: `<element attr="value">`
- **Text Content**: Data within elements
- **XML Declaration**: `<?xml version="1.0" encoding="UTF-8"?>`

### **Syntax Rules**
- **Well-formed**: Must follow strict syntax rules
- **Case-sensitive**: `<Book>` ≠ `<book>`
- **Proper nesting**: Elements must be properly nested and closed
- **Quoted attributes**: Attribute values in quotes
- **Special characters**: Use entity references (`&lt;`, `&gt;`, `&amp;`)

## Example Document

```xml
<?xml version="1.0" encoding="UTF-8"?>
<library>
    <book id="b001" category="fiction">
        <title>The Great Gatsby</title>
        <author>
            <first_name>F. Scott</first_name>
            <last_name>Fitzgerald</last_name>
        </author>
        <year>1925</year>
    </book>
</library>
```

**Tree Structure**:
- Root: `library`
- Child: `book` (with attributes `id`, `category`)
- Nested elements: `title`, `author`, `year`
- Further nesting: `first_name`, `last_name` within `author`

## XML Namespaces

Namespaces prevent element name collisions when mixing XML vocabularies.

```xml
<root xmlns:html="http://www.w3.org/1999/xhtml">
    <html:div>HTML content</html:div>
</root>
```

**Purpose**: Allow reuse of element names from different schemas without conflicts.

## Schema Validation

**XML Schema (XSD)**: Defines structure, data types, and constraints for XML documents.

```xml
<xs:element name="title" type="xs:string"/>
<xs:element name="year" type="xs:integer"/>
```

**Benefits**: Ensures data integrity, catches errors, provides documentation.

## Query & Processing

### **XPath**: Navigate XML structure
```xml
/library/book/title                    <!-- All titles -->
/library/book[@category='fiction']     <!-- Filter by attribute -->
```

### **XQuery**: Query XML data
```xml
for $book in /library/book
where $book/@category = 'fiction'
return $book/title
```

### **XSLT**: Transform XML to other formats (HTML, text, other XML)

## Special Features

**CDATA**: Include literal text without escaping special characters
```xml
<![CDATA[<b>bold</b> is not parsed as XML]]>
```

**Entity References**: Special characters
- `&lt;` = <
- `&gt;` = >
- `&amp;` = &

## Common Applications

- **Data Exchange**: Web services (SOAP, REST), system integration
- **Configuration Files**: Application settings
- **Document Formats**: Office documents, RSS feeds, SVG graphics
- **Web Technologies**: XHTML, sitemaps

## Processing Parsers

- **DOM**: Tree-based in-memory parsing
- **SAX**: Event-based streaming parser (memory efficient)
- **StAX**: Pull-based streaming parser

## Important Notes

- **Well-formedness**: Must follow strict syntax rules (proper nesting, closing tags, quoted attributes)
- **Validation**: Use XSD schemas to ensure data integrity
- **Security**: Be aware of XML injection and external entity attacks
- **Performance**: Large documents can have parsing overhead; use streaming for big files

## Related Concepts

- **[[Data Model]]**: Conceptual framework for data organization
- **[[Schema]]**: Formal specification of data structure
- **[[Relational Database]]**: Alternative tabular data storage approach
- **[[JSON]]**: Lightweight alternative for data interchange
