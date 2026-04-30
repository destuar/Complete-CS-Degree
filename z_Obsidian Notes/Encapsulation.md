## Definition

In networking, **encapsulation** is the process of wrapping higher-layer data with lower-layer protocol headers (and sometimes trailers) as data moves down the stack.

## How It Works

- Application data becomes a transport segment/datagram.
- Transport data is wrapped into a network-layer IP packet.
- IP packet is wrapped into a link-layer frame for local transmission.
- Receiver removes wrappers in reverse order (decapsulation).

## Why It Matters

- Separates layer responsibilities cleanly.
- Enables protocol interoperability across heterogeneous networks.
- Allows tunneling designs such as VPNs (encapsulating one packet inside another).

## Related Concepts

- [[4-Layer Internet Model]]
- [[Internet Protocol (IP)]]
- [[Transport]]
- [[Link]]
- [[Virtual Private Network (VPN)]]

