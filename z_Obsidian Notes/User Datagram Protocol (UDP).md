## Definition

**User Datagram Protocol (UDP)** is a connectionless transport-layer protocol that sends independent datagrams with minimal protocol overhead.

## Core Properties

- **Connectionless**: no connection setup handshake before sending.
- **Best effort**: no built-in reliability, retransmission, or ordering guarantees.
- **Low overhead**: small header and simple processing.
- **Message-oriented**: preserves application datagram boundaries.

## When UDP Is Useful

- Real-time media and interactive traffic where low latency is critical.
- Protocols that implement reliability/timing logic at the application layer.
- Request/response services where simplicity and speed are prioritized.

## Trade-Off vs TCP

- Faster/simpler transport behavior than [[Transmission Control Protocol (TCP)]].
- Application must handle loss, reordering, or duplicate packets if needed.

## Relationship to Other Protocols

- Runs above [[Internet Protocol (IP)]] in the [[Transport]] layer.
- Commonly used in latency-sensitive protocols and modern transport designs.

## Related Concepts

- [[Transport]]
- [[Transmission Control Protocol (TCP)]]
- [[Internet Protocol (IP)]]
- [[Application]]
- [[4-Layer Internet Model]]

