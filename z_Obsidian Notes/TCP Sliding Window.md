## Definition

**TCP sliding window** is the mechanism that lets a TCP sender transmit multiple unacknowledged bytes in flight while advancing the window as ACKs arrive—combining reliability with high throughput.

## Core Idea

- Bytes are numbered on the connection.
- The sender maintains a **window** of sequence numbers it may still transmit.
- Each ACK moves the left edge forward (“slides” the window).
- Data outside the window must wait (or be retransmitted if lost).

## Two Windows in TCP

TCP’s effective send limit is shaped by **both**:

| Window | Role | Driven by |
|---|---|---|
| **Receiver window (`rwnd`)** | [[Flow Control]] — don’t overrun receiver buffers | Receiver advertisements |
| **Congestion window (`cwnd`)** | [[Congestion Control]] — don’t overload the network | Sender congestion algorithm |

**Effective window** ≈ `min(rwnd, cwnd)` — the sender sends only what both constraints allow.

## How Sliding Works (Sender View)

1. Track **last acknowledged** sequence number.
2. Track **last sent** and **allowed to send** (window edge).
3. Send new segments while `bytes_in_flight < effective_window`.
4. On ACK: slide window forward; send more if allowed.
5. On loss/timeout: retransmit; congestion logic may shrink `cwnd`.

## Why It Matters

- Avoids stop-and-wait inefficiency on high-latency links.
- Pipelines data while still providing ordered, reliable delivery.
- Central to how TCP balances speed, fairness, and stability.

## Related Concepts

- [[Transmission Control Protocol (TCP)]]
- [[Flow Control]]
- [[Congestion Control]]
- [[Transport]]
