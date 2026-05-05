## Definition

A **Message Authentication Code (MAC)** is a short cryptographic tag computed from a message and a shared secret key to provide integrity and authenticity.

## What It Guarantees

- Detects message tampering in transit.
- Confirms the sender knows the shared secret key.
- Does **not** provide confidentiality by itself.

## How It Works (High Level)

- Sender computes MAC tag = `MAC(key, message)`.
- Sender transmits message + tag.
- Receiver recomputes tag with same key and verifies match.

## MAC vs Checksum/CRC

- [[Checksum]] and [[Cyclic Redundancy Check (CRC)|CRC]] detect random corruption.
- A cryptographic MAC protects against active attackers who can modify packets.
- MAC requires secret-key knowledge; checksum/CRC do not.

## MAC in TLS

- Earlier TLS cipher suites used HMAC-style message authentication.
- Modern TLS AEAD modes combine encryption + integrity protection in one construction.
- The core idea remains: data must be authenticated, not just encrypted.

## Related Concepts

- [[TLS]]
- [[Checksum]]
- [[Cyclic Redundancy Check (CRC)]]
- [[Encapsulation]]
