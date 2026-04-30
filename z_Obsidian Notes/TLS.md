# TLS

## Definition

**TLS (Transport Layer Security)** is a cryptographic protocol that provides confidentiality, integrity, and endpoint authentication for application traffic over untrusted networks.

## What TLS Provides

- **Encryption**: protects data from passive eavesdropping.
- **Integrity**: detects tampering/modification in transit.
- **Authentication**: server identity verification via certificates (and optional client auth).

## Where It Fits

- Sits conceptually above transport and below many application protocols.
- Commonly used with [[HTTP]] to form HTTPS.
- Typically runs over [[Transmission Control Protocol (TCP)]], while modern variants can run over UDP-based transports (for example QUIC/TLS integration).

## Handshake (High Level)

- Negotiates protocol version and cipher suite.
- Authenticates server certificate chain.
- Establishes shared session keys.
- Transitions to encrypted application data exchange.

## TLS vs VPN

- [[TLS]] usually secures specific application sessions.
- [[Virtual Private Network (VPN)|VPN]] secures broader routed traffic through a tunnel.

## Related Concepts

- [[HTTP]]
- [[Transmission Control Protocol (TCP)]]
- [[Application]]
- [[Virtual Private Network (VPN)]]
- [[End-to-End Principle]]
