## Definition

**Congestion control** is a set of mechanisms that limit how aggressively hosts send traffic so the **network** (routers, links, queues) is not overloaded—avoiding widespread delay, loss, and collapse.

## Core Goal

- Keep aggregate load near what the path can carry.
- React to congestion signals (queue buildup, packet drops, delay increases).
- Share bottleneck capacity fairly enough among competing flows.

## Congestion Control vs Flow Control

- **Congestion control** protects **the network path** and shared queues.
- [[Flow Control]] protects **the receiver** from being overrun.

TCP applies **both**; effective send rate is limited by the tighter constraint (see [[TCP Sliding Window]]).

## TCP Congestion Control (Conceptual)

- Sender maintains a **congestion window** limiting bytes in flight (alongside receiver window).
- **Probe / increase** when the path seems healthy (throughput rises toward fair share).
- **Back off / decrease** when congestion is inferred (often loss or ECN signals).
- Algorithms evolve across TCP variants (Reno, CUBIC, BBR, etc.), but the pattern is: infer congestion → reduce rate → probe again.

## UDP and Congestion

- [[User Datagram Protocol (UDP)|UDP]] has **no built-in** congestion control.
- Applications using UDP heavily often implement their own pacing/rate control—or rely on lower utilization—to avoid harming cross-traffic.

## Why It Matters

- Critical for Internet stability when many flows share links.
- Explains latency spikes (“bufferbloat”) and throughput swings during contention.

## Related Concepts

- [[Flow Control]]
- [[TCP Sliding Window]]
- [[Transmission Control Protocol (TCP)]]
- [[Transport]]
- [[Packet Switching]]
- [[Internet Protocol (IP)]]
