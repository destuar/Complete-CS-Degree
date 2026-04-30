## Definition

**CIDR (Classless Inter-Domain Routing)** is an IP addressing and routing method that represents network prefixes using slash notation (for example `192.168.1.0/24`).

## Core Idea

- Replaces rigid class-based addressing (Class A/B/C) with variable-length prefixes.
- Uses a prefix length (`/n`) to indicate how many leading bits identify the network.
- Remaining bits identify host addresses within that network.

## Why It Matters

- Improves address allocation efficiency.
- Enables route aggregation (supernetting), reducing global routing table size.
- Supports subnetting designs tailored to real network sizes.

## Quick Examples

- `10.0.0.0/8` -> large private address block
- `192.168.1.0/24` -> common LAN-sized subnet
- `172.16.8.0/21` -> aggregated range across multiple /24-sized blocks

## Relationship to IPv4 and IPv6

- Widely used in [[IPv4]] subnetting and routing policies.
- Also applies in [[IPv6]] prefix notation (for example `/64` subnets).

## Related Concepts

- [[Internet Protocol (IP)]]
- [[IPv4]]
- [[IPv6]]
- [[Network]]
- [[NAT]]

