## Definition

**Address Resolution Protocol (ARP)** maps an IPv4 address to a link-layer MAC address on a local network segment.

## Why ARP Is Needed

- IP forwarding decides *which host/interface* should receive a packet next.
- Link-layer transmission still needs a destination MAC address to build the frame.
- ARP bridges that gap for local-hop delivery in IPv4 networks.

## How It Works

- Sender checks local ARP cache for known IP-to-MAC mapping.
- If missing, sender broadcasts an ARP request on the local LAN.
- Target host replies with its MAC address (ARP reply).
- Sender caches the mapping temporarily and sends frames to that MAC.

## Scope and Limits

- ARP works within the local broadcast domain (same subnet/L2 segment).
- For remote destinations, hosts ARP for the default gateway's MAC, not the remote host directly.
- ARP is primarily associated with [[IPv4]]; IPv6 uses neighbor discovery mechanisms instead.

## Security Note

ARP has no built-in authentication, so networks can be vulnerable to ARP spoofing/poisoning without additional protections.

## Related Concepts

- [[Link]]
- [[Internet Protocol (IP)]]
- [[IPv4]]
- [[Network]]
- [[CIDR]]

