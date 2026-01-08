# XML Processing

**XML Processing** involves parsing and manipulating **Extensible Markup Language** (XML) data.

## Approaches
1.  **DOM (Document Object Model)**: Loads the entire XML tree into memory. Good for random access, bad for large files.
2.  **SAX (Simple API for XML)**: Event-driven parsing. Reads sequentially and triggers events (e.g., "start tag found"). Efficient for large files.

## In Python
- Libraries like `xml.sax` or `ElementTree` make processing XML significantly easier than in C.

## Relevance
- Demonstrates the power of scripting languages ([[Python]]) for string-heavy tasks compared to raw C.
