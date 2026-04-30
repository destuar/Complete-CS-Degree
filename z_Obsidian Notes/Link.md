## Definition

The **Link layer** handles data transfer between directly connected nodes on the same local network segment.

## Responsibilities

- Framing: groups bits into frames.
- Local addressing: uses MAC addresses for nearby delivery.
- Error detection: commonly via checksums/[[Cyclic Redundancy Check (CRC)|CRC]] at frame level.
- Medium access: coordinates access to shared media (for example Wi-Fi contention).

## Typical Technologies

- Ethernet
- Wi-Fi (802.11)
- Switch-based LAN forwarding

## Scope

The link layer does **not** route packets across the Internet; it only manages hop-by-hop local delivery.

## Related Concepts

- [[Network]]
- [[4-Layer Internet Model]]
- [[Address Resolution Protocol (ARP)]]
- [[Cyclic Redundancy Check (CRC)]]

