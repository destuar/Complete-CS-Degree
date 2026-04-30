# Checksum

## Definition

A **checksum** is an error-detection value computed from data and transmitted with it so the receiver can detect accidental corruption.

## Core Idea

- Sender computes checksum over selected header/payload fields.
- Receiver recomputes checksum and compares.
- Mismatch indicates corruption in transit/storage.

## Checksum in IP

- In [[Internet Protocol (IP)]], IPv4 includes a header checksum for the IP header only.
- This helps detect header corruption at each hop.
- Payload integrity is handled by upper layers (for example TCP/UDP/application).

## Checksum in TCP

- [[Transmission Control Protocol (TCP)|TCP]] checksum covers TCP header and payload, plus an IP pseudo-header.
- Detects corruption for end-to-end transport data delivery.
- Works with retransmission logic for reliability when corrupted/lost segments are detected.

## Why It Matters

- Lightweight integrity check against random bit errors.
- Not a cryptographic authenticity mechanism (unlike TLS MAC/AEAD protections).

## Related Concepts

- [[Internet Protocol (IP)]]
- [[Transmission Control Protocol (TCP)]]
- [[User Datagram Protocol (UDP)]]
- [[Encapsulation]]`r`n- [[Cyclic Redundancy Check (CRC)]]
