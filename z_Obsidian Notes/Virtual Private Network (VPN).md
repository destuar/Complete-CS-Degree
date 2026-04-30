## Definition

A **Virtual Private Network (VPN)** creates a logical private connection over a public network by tunneling traffic between endpoints, often with encryption and authentication.

## Core Purpose

- Protect data in transit over untrusted networks.
- Extend private network access to remote users/sites.
- Hide internal addressing/topology behind tunnel endpoints.

## How It Works

- Original packet (inner packet) is wrapped inside a new outer packet.
- Tunnel endpoints add headers and (commonly) encrypt payloads.
- Traffic traverses the public Internet as encapsulated tunnel traffic.
- At the far endpoint, packets are decapsulated and forwarded internally.

## Encapsulation Flexibility

VPN design is flexible because one protocol can be encapsulated inside another based on deployment needs:

- IP-in-IP style tunneling for simple routed connectivity.
- Application-layer VPNs (for example TLS-based tunnels) over TCP/UDP.
- Site-to-site and remote-access modes with different header/transport choices.

This flexibility allows VPNs to adapt to NAT traversal constraints, firewall policy, performance needs, and compatibility requirements.

## Practical Trade-Offs

- Added headers + encryption introduce overhead and potential MTU/fragmentation issues.
- Security and key management are critical to correct operation.
- Routing policy must be designed (full tunnel vs split tunnel).

## Related Concepts

- [[Encapsulation]]
- [[Internet Protocol (IP)]]
- [[NAT]]
- [[End-to-End Principle]]
- [[Transport]]

