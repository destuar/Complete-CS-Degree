## Definition

**Transmission Control Protocol (TCP)** is a connection-oriented transport-layer protocol that provides reliable, ordered, byte-stream delivery between processes.

## Core Properties

- **Reliable delivery**: lost data is retransmitted.
- **Ordered delivery**: bytes are delivered in sequence.
- **Connection-oriented**: endpoints establish a connection before data transfer.
- **Full-duplex**: both sides can send and receive simultaneously.

## How TCP Works (High Level)

- Connection setup with a three-way handshake.
- Data is segmented, acknowledged, and retransmitted if needed.
- [[TCP Sliding Window]] pipelines data using `min(rwnd, cwnd)`.
- [[Flow Control]] prevents overwhelming the receiver.
- [[Congestion Control]] algorithms adapt sending behavior based on network conditions.

## Why It Matters

TCP is used when correctness and ordered data matter more than minimal latency overhead (for example web traffic and many application protocols).

## Relationship to Other Protocols

- Runs above [[Internet Protocol (IP)]] at the [[Transport]] layer.
- Commonly used by [[HTTP]] (especially HTTP/1.1 and HTTP/2).

## Related Concepts

- [[Transport]]
- [[Internet Protocol (IP)]]
- [[HTTP]]
- [[Flow Control]]
- [[Congestion Control]]
- [[TCP Sliding Window]]
- [[4-Layer Internet Model]]

