## Definition

The **7-Layer OSI Model** (Open Systems Interconnection) is a conceptual framework that separates network communication into seven abstraction layers.

## Layers (Top to Bottom)

1. **Application (L7)**  
   User-facing network services and application protocols.
2. **Presentation (L6)**  
   Data representation, translation, compression, and encryption format concerns.
3. **Session (L5)**  
   Session setup, management, and teardown between communicating applications.
4. **Transport (L4)**  
   End-to-end process communication, reliability, and flow behavior.
5. **Network (L3)**  
   Logical addressing and routing across networks.
6. **Data Link (L2)**  
   Framing and local-hop delivery on the same link.
7. **Physical (L1)**  
   Transmission of raw bits over physical media.

## Why It Is Useful

- Provides a detailed teaching model for protocol responsibilities.
- Helps troubleshoot by isolating issues to a specific layer.
- Standardizes communication when discussing network architecture.

## OSI vs Internet (4-Layer) Model

- OSI has more granularity (7 layers) than the Internet model (4 layers).
- OSI Session + Presentation responsibilities are often folded into application behavior in the Internet model.
- OSI Data Link + Physical are often grouped as Link in the Internet model.

## Related Concepts

- [[4-Layer Internet Model]]
- [[Application]]
- [[Transport]]
- [[Network]]
- [[Link]]

