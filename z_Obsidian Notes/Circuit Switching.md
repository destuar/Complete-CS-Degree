## Definition

**Circuit switching** is a networking approach where a dedicated **end-to-end communication path** is established between two endpoints before data transfer and **held for the duration** of the session.

## How It Works

- **Setup phase**: resources (links, time slots, frequency bands) are allocated along a route.
- **Data transfer**: bits flow continuously along the reserved path with predictable channel behavior.
- **Teardown**: resources are released when the session ends.

## Characteristics

- **Dedicated resources** per active circuit while the call/session lasts.
- Often provides **steady throughput** and **low jitter** for the reserved path.
- **Idle time** on that circuit still consumes allocated capacity (possible under-utilization).

## Classic Examples

- Traditional telephone networks (voice circuits).
- Time-division or frequency-division channels reserved for a conversation.

## Circuit Switching vs Packet Switching

- **Circuit switching**: reserve path first; good for steady streams; waste when idle.
- **Packet switching**: share links dynamically; better for bursty data (basis of the Internet).

See [[Packet Switching]] for the contrasting model.

## Related Concepts

- [[Packet Switching]]
- [[Network]]
- [[Link]]
- [[End-to-End Principle]]
