## Definition

**Internet Protocol (IP)** is the network-layer protocol that provides logical addressing and best-effort packet delivery across interconnected networks.

## Core Responsibilities

- Defines IP packet format and addressing.
- Enables routing across multiple hops/networks.
- Supports forwarding decisions at routers.
- Provides a common internetworking layer above local link technologies.

## Key Characteristics

- **Connectionless**: packets are handled independently.
- **Best effort**: no built-in guarantee of delivery, order, or timing.
- **Scalable addressing**: identifies source and destination hosts/interfaces.

## IPv4 and IPv6

- [[IPv4]]: 32-bit addressing (limited address space).
- [[IPv6]]: 128-bit addressing (vastly larger address space and modernized header design).

## Relationship to Other Layers

- Works below [[Transport]] (TCP/UDP/QUIC usage patterns).
- Runs above [[Link]] technologies (Ethernet, Wi-Fi).
- Uses [[Internet Control Message Protocol (ICMP)|ICMP]] for control and error reporting alongside IP forwarding.
- Is central to the [[4-Layer Internet Model]] and [[Network]] layer behavior.

## Related Concepts

- [[Network]]
- [[NAT]]
- [[Link]]
- [[Transport]]
- [[4-Layer Internet Model]]
- [[IPv4]]
- [[IPv6]]
- [[CIDR]]
- [[Address Resolution Protocol (ARP)]]
- [[Internet Control Message Protocol (ICMP)]]

