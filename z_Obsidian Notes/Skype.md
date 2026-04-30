## Definition

**Skype** is a real-time communication application (voice, video, chat) that historically used hybrid P2P techniques and later shifted toward more cloud-based infrastructure.

## Networking Relevance

- Demonstrates challenges of low-latency interactive traffic.
- Uses signaling plus media transport between endpoints or via relays.
- Must handle users behind home routers using [[NAT]] traversal strategies.

## Typical Requirements

- **Low latency** for conversation quality.
- **Jitter handling** and packet-loss tolerance for voice/video streams.
- **Adaptive bitrate/codecs** to fit changing network conditions.

## Architectural Insight

Skype is a useful case study in trade-offs between:
- centralized control (easier management),
- versus peer-assisted communication (better distribution efficiency).

## Related Concepts

- [[Client]]
- [[Server]]
- [[NAT]]
- [[4-Layer Internet Model]]

