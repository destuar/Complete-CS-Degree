## Definition

**BitTorrent** is a peer-to-peer (P2P) file distribution protocol where participants download and upload file pieces to each other instead of relying on one central server.

## How It Works

- A large file is split into many small **pieces**.
- Peers in a **swarm** exchange pieces concurrently.
- A **.torrent file** or magnet link provides metadata and peer discovery info.
- A **tracker** (or DHT-based discovery) helps peers find one another.

## Peer Roles

- **Seeder**: Has the full file and uploads pieces.
- **Leecher**: Downloads pieces (often uploads while downloading).

## Why It Scales Well

- Upload bandwidth comes from many peers, not only one server.
- More demand can increase total available upload capacity.
- Popular files become easier to distribute due to larger swarms.

## Related Concepts

- [[Client]]
- [[Server]]
- [[NAT]]
- [[4-Layer Internet Model]]

