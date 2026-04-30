## Definition

The **End-to-End Principle** states that functions requiring complete correctness (for example reliability, security, or application semantics) are best implemented at the communication endpoints rather than only inside the network core.

## Core Idea

- Keep the network core simple and general-purpose.
- Push application-specific correctness checks to end hosts.
- Allow lower layers to provide efficient but not fully complete guarantees.

## Why It Matters

- Improves scalability by avoiding excessive complexity in routers/network core.
- Supports innovation at the edge (new applications can evolve without changing the core network).
- Clarifies where correctness must ultimately be validated: at the application endpoints.

## Typical Examples

- A transport/network may retransmit lost packets, but the application still verifies full file integrity (hash/checksum at endpoints).
- Encryption can exist on links, but true end-to-end confidentiality is achieved when only endpoints hold decryption keys.

## Practical Trade-Offs

- Some middle-network functions (caching, firewalls, NATs, CDNs) can improve performance or policy enforcement.
- End-to-end design remains a guiding principle, not an absolute rule.

## Related Concepts

- [[4-Layer Internet Model]]
- [[Application]]
- [[Transport]]
- [[Transmission Control Protocol (TCP)]]
- [[User Datagram Protocol (UDP)]]

