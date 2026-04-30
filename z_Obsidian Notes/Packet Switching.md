## Definition

**Packet switching** is a networking approach where data is split into small packets that are forwarded independently through the network and reassembled at the destination.

## How It Works

- A message is segmented into packets.
- Each packet carries header information (source/destination, control fields).
- Routers forward packets hop-by-hop based on routing tables.
- Packets may take different paths and arrive out of order.

## Why It Is Effective

- Efficient sharing of network links among many users.
- Better utilization than dedicating fixed circuits for each conversation.
- Supports bursty traffic patterns common on the Internet.

## Trade-Offs

- Variable delay (queueing and congestion effects).
- Potential packet loss and reordering.
- End systems/transport protocols (like TCP) often handle recovery and ordering.

## Packet Switching vs Circuit Switching

- **Packet switching**: dynamic resource sharing, flexible routing, no fixed path reservation.
- **Circuit switching**: dedicated end-to-end path for the duration of a session.

## Related Concepts

- [[Network]]
- [[Internet Protocol (IP)]]
- [[Transmission Control Protocol (TCP)]]
- [[User Datagram Protocol (UDP)]]
- [[End-to-End Principle]]

