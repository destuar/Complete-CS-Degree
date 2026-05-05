## Definition

**Flow control** is a mechanism that prevents a fast sender from overwhelming a slow receiver by limiting how much unacknowledged data can be in flight.

## Core Goal

- Match sender transmission rate to receiver processing/buffer capacity.
- Avoid receiver buffer overflow and packet drops due to endpoint saturation.

## TCP Flow Control (Main Example)

- [[Transmission Control Protocol (TCP)|TCP]] uses a receiver-advertised window (`rwnd`).
- Receiver tells sender how much additional data it can accept.
- Sender keeps outstanding unacknowledged bytes within that window.
- Window updates dynamically as the receiver consumes buffered data.

## Common Flow Control Types

### Stop-and-Wait

- Sender transmits one frame/segment, then waits for ACK before sending the next.
- Very simple but low link utilization on high-latency paths.
- Useful for understanding fundamentals and in simple protocols.

### Sliding Window

- Sender may transmit multiple units before receiving ACKs.
- ACKs "slide" the window forward, allowing new data to be sent.
- Much better throughput than stop-and-wait, especially with long RTTs.

### Go-Back-N (ARQ family)

- Sender can have a window of outstanding packets.
- On loss/error, retransmits from the first missing packet onward.
- Simpler receiver logic, potentially more redundant retransmissions.

### Selective Repeat (ARQ family)

- Receiver can accept and buffer out-of-order packets.
- Sender retransmits only missing/lost packets.
- More efficient than Go-Back-N, but higher protocol complexity.

## Flow Control vs Congestion Control

- **Flow control** protects the receiver endpoint.
- **Congestion control** protects the network path/routers from overload.
- TCP uses both, and effective sending rate is constrained by both limits.

## Why It Matters

- Improves reliability and throughput stability.
- Reduces retransmissions caused by receiver overload.
- Essential for robust end-to-end transport behavior.

## Related Concepts

- [[Transmission Control Protocol (TCP)]]
- [[Transport]]
- [[Finite State Machine (FSM)]]
- [[Packet Switching]]
- [[User Datagram Protocol (UDP)]]
