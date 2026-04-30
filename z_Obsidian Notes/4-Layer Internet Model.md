## Definition

The **4-Layer Internet Model** is a practical networking stack used to explain how Internet communication is organized.

## Layers (Top to Bottom)

1. **Application Layer**
   - Protocols and app logic (for example [[HTTP]], DNS, SMTP).
2. **Transport Layer**
   - End-to-end process communication (TCP/UDP), reliability, flow/congestion handling.
3. **Network Layer**
   - Logical addressing and routing between networks (IP).
4. **Link Layer**
   - Local network delivery over a specific medium (Ethernet, Wi-Fi).

## Encapsulation Idea

Each layer adds its own header information as data moves down the stack at the sender, and headers are removed in reverse order at the receiver.

## Why It Matters

- Separates concerns for protocol design.
- Enables interoperability across heterogeneous networks.
- Makes troubleshooting easier by isolating problems per layer.

## Quick Comparison

| Layer | Data Unit | Main Addressing | Typical Device/Focus |
|---|---|---|---|
| Application | Message | App-level identifiers (URL/domain) | End-host processes ([[Client]], [[Server]]) |
| Transport | Segment (TCP) / Datagram (UDP) | Port numbers | End-to-end process delivery on hosts |
| Network | Packet (IP datagram) | IP addresses | Routers and path routing across networks |
| Link | Frame | MAC addresses | NICs/switches and local-hop delivery |

## Related Concepts

- [[HTTP]]
- [[Client]]
- [[Server]]
- [[NAT]]
- [[7-Layer OSI Model]]
- [[End-to-End Principle]]
- [[Encapsulation]]
- [[Virtual Private Network (VPN)]]

