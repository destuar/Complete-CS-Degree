## Definition

**Network Address Translation (NAT)** is a router function that maps private internal IP addresses to one (or a few) public IP addresses, allowing many devices to share limited public IPv4 space.

## Why It Is Used

- Conserves public IPv4 addresses.
- Hides internal addressing structure from the external Internet.
- Common in home and enterprise edge routers.

## Common Behavior

- Outbound connection from a private host creates a mapping entry.
- Return packets are translated back to the original internal host.
- Inbound unsolicited traffic is usually blocked unless explicit port forwarding is configured.

## Networking Impact

- Breaks strict end-to-end addressing assumptions.
- Complicates peer-to-peer communication (for example, [[BitTorrent]] and legacy [[Skype]] patterns).
- Requires NAT traversal techniques such as hole punching or relay servers.

## Related Concepts

- [[BitTorrent]]
- [[Skype]]
- [[Client]]
- [[Server]]
- [[4-Layer Internet Model]]

