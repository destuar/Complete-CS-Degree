## Definition

**Cyclic Redundancy Check (CRC)** is an error-detection method that treats data as a polynomial over binary values and computes a short remainder used to detect corruption.

## How It Works (High Level)

- Sender computes a CRC value from the frame/data bits.
- Sender appends the CRC field to the transmitted unit.
- Receiver recomputes the CRC and compares with the received value.
- Mismatch indicates likely bit errors.

## Why CRC Is Strong

- Better burst-error detection than simple additive checksums.
- Very efficient in hardware and common at the link layer.
- Detects many common corruption patterns with low overhead.

## Where It Appears

- Common in link-layer frames (for example Ethernet FCS).
- Typically used for detection only, not correction.
- Retransmission/recovery is handled by higher-layer or link protocols.

## CRC vs Checksum

- CRC uses polynomial division and usually has stronger error-detection properties.
- A [[Checksum]] is simpler and often used at transport/network headers.

## Related Concepts

- [[Checksum]]
- [[Link]]
- [[Encapsulation]]
- [[Packet Switching]]
