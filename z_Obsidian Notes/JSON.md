# JSON (JavaScript Object Notation)

**JSON (JavaScript Object Notation)** is a lightweight, text-based data interchange format that is easy for humans to read and write, and easy for machines to parse and generate. JSON is language-independent and serves as a universal data format for web APIs, configuration files, data storage, and inter-process communication. It provides a simple way to represent structured data using a subset of JavaScript syntax, making it ideal for data exchange between different programming languages and platforms.

## Basic Definition

JSON is a **data serialization format** that represents data in a hierarchical structure using key-value pairs, arrays, and primitive data types. Unlike XML, which uses markup tags, JSON uses a minimal syntax that closely resembles JavaScript object literals. JSON provides:

- **Simple Syntax**: Minimal punctuation and easy-to-read format
- **Language Independence**: Works across all programming languages
- **Hierarchical Structure**: Supports nested objects and arrays
- **Type Support**: Six basic data types (string, number, boolean, null, object, array)
- **No Comments**: Clean, pure data representation

## Core JSON Concepts

### **Data Types & Values**
- **String**: Text enclosed in double quotes with escape sequences
- **Number**: Integer or floating-point numbers (no leading zeros)
- **Boolean**: `true` or `false` literals
- **Null**: `null` literal representing absence of value
- **Object**: Unordered collection of key-value pairs
- **Array**: Ordered sequence of values

### **JSON vs XML Comparison**
- **Syntax**: JSON uses minimal punctuation, XML uses markup tags
- **Readability**: JSON is more compact and easier to read
- **Comments**: JSON doesn't support comments, XML does
- **Namespaces**: JSON has no namespace concept, XML supports namespaces
- **Schema**: JSON Schema is optional, XML Schema (XSD) is more formal
- **Processing**: JSON is easier to parse in JavaScript, XML has broader tool support

## JSON Syntax & Structure

### **Object Syntax**
```json
{
    "string_key": "string_value",
    "number_key": 42,
    "boolean_key": true,
    "null_key": null,
    "nested_object": {
        "inner_key": "inner_value"
    },
    "array_key": [1, 2, 3]
}
```

### **Array Syntax**
```json
[
    "first_element",
    42,
    false,
    {
        "object_in_array": "value"
    },
    [1, 2, 3]
]
```

### **String Escape Sequences**
```json
{
    "quotes": "He said \"Hello World\"",
    "newline": "Line 1\nLine 2",
    "tab": "Column1\tColumn2",
    "backslash": "Path\\to\\file",
    "unicode": "Unicode: \u0041\u0042\u0043"
}
```

## Data Type Details

### **String Values**
```json
{
    "simple": "Hello World",
    "empty": "",
    "with_quotes": "He said \"Hello\"",
    "with_newlines": "Line 1\nLine 2\tTabbed",
    "unicode": "Café résumé naïve",
    "emoji": "🚀 📚 💻"
}
```

### **Number Values**
```json
{
    "integer": 42,
    "negative": -17,
    "float": 3.14159,
    "scientific": 1.23e-4,
    "zero": 0,
    "large": 9007199254740991
}
```

### **Boolean & Null Values**
```json
{
    "true_value": true,
    "false_value": false,
    "null_value": null
}
```

### **Object Nesting**
```json
{
    "user": {
        "id": 12345,
        "profile": {
            "name": "John Doe",
            "address": {
                "street": "123 Main St",
                "city": "Anytown",
                "country": "USA"
            }
        },
        "preferences": {
            "theme": "dark",
            "notifications": true
        }
    }
}
```

### **Array Operations**
```json
{
    "numbers": [1, 2, 3, 4, 5],
    "mixed_types": ["string", 42, true, null],
    "nested_arrays": [[1, 2], [3, 4], [5, 6]],
    "objects_in_array": [
        {"id": 1, "name": "Alice"},
        {"id": 2, "name": "Bob"},
        {"id": 3, "name": "Charlie"}
    ]
}
```

## JSON Schema & Validation

### **Basic Schema Structure**
```json
{
    "$schema": "http://json-schema.org/draft-07/schema#",
    "title": "User Profile",
    "description": "A user profile schema",
    "type": "object",
    "properties": {
        "id": {
            "type": "integer",
            "minimum": 1,
            "description": "Unique user identifier"
        },
        "username": {
            "type": "string",
            "minLength": 3,
            "maxLength": 20,
            "pattern": "^[a-zA-Z0-9_]+$"
        },
        "email": {
            "type": "string",
            "format": "email"
        },
        "age": {
            "type": "integer",
            "minimum": 13,
            "maximum": 120
        }
    },
    "required": ["id", "username", "email"],
    "additionalProperties": false
}
```

### **Schema Validation Rules**
- **Type Constraints**: Specify allowed data types
- **Range Validation**: Minimum/maximum values for numbers
- **Length Constraints**: String and array length limits
- **Pattern Matching**: Regular expression validation
- **Required Fields**: Mandatory properties
- **Enumeration**: Allowed value lists
- **Format Validation**: Email, URI, date-time formats

## Programming Language Integration

### **JavaScript (Native Support)**
```javascript
// Parsing JSON string to object
const jsonString = '{"name": "John", "age": 30}';
const obj = JSON.parse(jsonString);

// Converting object to JSON string
const data = {name: "Jane", age: 25};
const jsonOutput = JSON.stringify(data, null, 2);

// Error handling
try {
    const parsed = JSON.parse(invalidJson);
} catch (error) {
    console.error('Invalid JSON:', error.message);
}
```

### **Python Integration**
```python
import json

# Parsing JSON
json_string = '{"name": "John", "age": 30}'
data = json.loads(json_string)

# Converting to JSON
data = {"name": "Jane", "age": 25}
json_output = json.dumps(data, indent=2)

# File operations
with open('data.json', 'r') as f:
    data = json.load(f)

with open('output.json', 'w') as f:
    json.dump(data, f, indent=2)
```

### **Java Integration**
```java
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper mapper = new ObjectMapper();

// Parse JSON string
String jsonString = "{\"name\": \"John\", \"age\": 30}";
User user = mapper.readValue(jsonString, User.class);

// Convert object to JSON
User user = new User("Jane", 25);
String jsonOutput = mapper.writeValueAsString(user);

// Pretty printing
String prettyJson = mapper.writerWithDefaultPrettyPrinter()
                         .writeValueAsString(user);
```

## Advanced JSON Features

### **Circular Reference Handling**
```javascript
// Problem: Circular references cause errors
const obj1 = {name: "Object 1"};
const obj2 = {name: "Object 2", ref: obj1};
obj1.ref = obj2; // Circular reference

// Solution: Custom replacer function
const jsonString = JSON.stringify(obj1, (key, value) => {
    if (key === 'ref' && value === obj1) {
        return '[Circular Reference]';
    }
    return value;
});
```

### **Custom Serialization**
```javascript
// Custom toJSON method
const user = {
    name: "John Doe",
    password: "secret123",
    toJSON: function() {
        return {
            name: this.name,
            // Exclude password from serialization
            timestamp: new Date().toISOString()
        };
    }
};

const json = JSON.stringify(user);
// Result: {"name":"John Doe","timestamp":"2024-01-01T00:00:00.000Z"}
```

### **Reviver Function for Parsing**
```javascript
// Custom reviver function
const jsonString = '{"name": "John", "birthDate": "1990-01-01"}';
const obj = JSON.parse(jsonString, (key, value) => {
    if (key === 'birthDate') {
        return new Date(value);
    }
    return value;
});
```

## Performance & Optimization

### **Parsing Performance**
- **Streaming Parsers**: Process large JSON files incrementally
- **Memory Efficiency**: Avoid loading entire document into memory
- **Lazy Evaluation**: Parse only required sections
- **Caching**: Cache parsed results for repeated access

### **Size Optimization**
```json
// Verbose format
{
    "user_identification_number": 12345,
    "user_full_name": "John Michael Doe",
    "user_email_address": "john.doe@example.com"
}

// Optimized format
{
    "id": 12345,
    "name": "John Michael Doe",
    "email": "john.doe@example.com"
}
```

### **Compression Techniques**
- **Gzip**: Standard compression for JSON over HTTP
- **Brotli**: Modern compression with better ratios
- **Binary Formats**: BSON, MessagePack for performance-critical applications
- **Schema-based**: Remove redundant structure information

## Security Considerations

### **JSON Injection Prevention**
```javascript
// Dangerous: Direct concatenation
const userInput = '{"name": "John", "script": "<script>alert(\'xss\')</script>"}';
const data = JSON.parse(userInput);

// Safe: Input validation and sanitization
function safeJsonParse(input) {
    try {
        const parsed = JSON.parse(input);
        // Validate structure and content
        if (typeof parsed === 'object' && parsed !== null) {
            return parsed;
        }
        throw new Error('Invalid object structure');
    } catch (error) {
        throw new Error('Invalid JSON format');
    }
}
```

### **External Entity Attacks**
- **JSONP Vulnerabilities**: Avoid dynamic script injection
- **Content Validation**: Validate JSON structure before processing
- **Input Sanitization**: Remove potentially dangerous content
- **Output Encoding**: Properly encode JSON output

## Best Practices

### **Schema Design**
- **Consistent Naming**: Use consistent naming conventions
- **Type Consistency**: Maintain consistent data types
- **Documentation**: Include field descriptions and examples
- **Versioning**: Plan for schema evolution and backward compatibility

### **Performance Guidelines**
- **Minimize Nesting**: Avoid deeply nested structures
- **Array Sizing**: Use appropriate array sizes for the use case
- **Property Order**: Keep frequently accessed properties at the top level
- **Caching Strategy**: Implement appropriate caching for repeated access

### **Error Handling**
```javascript
function robustJsonParse(jsonString, fallback = {}) {
    try {
        return JSON.parse(jsonString);
    } catch (error) {
        console.warn('JSON parsing failed:', error.message);
        return fallback;
    }
}

// Usage
const data = robustJsonParse(invalidJson, {error: 'Invalid data'});
```

## Applications & Use Cases

### **Web APIs & Services**
- **REST APIs**: Standard data exchange format
- **GraphQL**: Alternative to REST with JSON responses
- **WebSockets**: Real-time data transmission
- **Server-Sent Events**: Streaming data updates

### **Configuration & Storage**
- **Application Config**: Settings and preferences
- **User Preferences**: Stored user settings
- **Cache Data**: Temporary data storage
- **Log Files**: Structured logging information

### **Data Exchange**
- **Database Export**: Data migration and backup
- **Inter-process Communication**: Message passing between processes
- **Microservices**: Service-to-service communication
- **Mobile Apps**: Client-server data synchronization

## Tools & Technologies

### **Development Tools**
- **JSON Validators**: Online and offline validation tools
- **Schema Generators**: Create schemas from sample data
- **Formatters**: Pretty-print and minify JSON
- **Diff Tools**: Compare JSON documents

### **Programming Libraries**
- **JavaScript**: Built-in JSON object
- **Python**: json module, jsonschema for validation
- **Java**: Jackson, Gson, org.json
- **C#**: System.Text.Json, Newtonsoft.Json
- **Go**: encoding/json package

## Key Features

### **Simplicity & Readability**
- **Minimal Syntax**: Easy to read and write
- **Language Independence**: Works across all platforms
- **Human-Friendly**: Natural representation of data structures
- **Self-Documenting**: Structure reveals data organization

### **Performance & Efficiency**
- **Fast Parsing**: Efficient parsing algorithms
- **Compact Format**: Minimal overhead compared to XML
- **Streaming Support**: Process large documents incrementally
- **Memory Efficient**: Low memory footprint during processing

### **Interoperability & Standards**
- **RFC 7159**: Official JSON specification
- **Wide Support**: Available in all major programming languages
- **Tool Ecosystem**: Rich set of development and validation tools
- **Industry Adoption**: Standard format for web APIs and data exchange

## Important Notes

- **No Comments**: JSON doesn't support comments, use external documentation
- **No Trailing Commas**: Last element in objects/arrays cannot have trailing comma
- **String Keys Only**: Object keys must be strings (not numbers or booleans)
- **No Functions**: Cannot serialize functions or methods
- **Encoding**: Always use UTF-8 encoding for proper Unicode support

## Related Concepts

- **[[Array]]**: Ordered sequence data structure
- **[[Collection]]**: Abstract data type for grouping data items
- **[[Data Model]]**: Conceptual framework for data organization
- **[[Extensible Markup Language (XML)]]**: Alternative data format with markup
- **[[Schema]]**: Formal specification of data structure and organization
