## Definition

**Internet Control Message Protocol (ICMP)** is a network-layer companion protocol used with [[Internet Protocol (IP)|IP]] to report errors, exchange diagnostic information, and support simple reachability testing.

## Role

- IP is **best effort**; ICMP reports what went wrong when forwarding fails or limits are hit.
- ICMP messages are carried **inside IP datagrams** as the payload (IP protocol number indicates ICMP).
- ICMP is **not** used for regular application data delivery like TCP or UDP.

## Common Message Types

- **Echo Request / Echo Reply**: used by tools like `ping` for reachability and round-trip measurement.
- **Destination Unreachable**: no route, port unreachable (often combined with UDP), administratively prohibited, etc.
- **Time Exceeded**: TTL reached zero (often seen with `traceroute`-style probing).
- **Redirect**: router hints about a better next hop (less common in modern setups).

## ICMP vs ICMPv6

- **ICMPv4** pairs with [[IPv4]].
- **ICMPv6** pairs with [[IPv6]] and also carries roles overlapping neighbor discovery (replacing parts of what [[Address Resolution Protocol (ARP)|ARP]] does in IPv4).

## Security and Filtering

- ICMP is useful for troubleshooting but can be abused for scanning or denial-of-service if misconfigured.
- Many networks rate-limit or selectively filter ICMP while still allowing essentials.

## Related Concepts

- [[Internet Protocol (IP)]]
- [[IPv4]]
- [[IPv6]]
- [[Network]]
- [[Packet Switching]]

