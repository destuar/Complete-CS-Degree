## Definition

**HyperText Transfer Protocol (HTTP)** is an application-layer protocol used by web clients and web servers to exchange resources such as HTML pages, images, JSON, and video metadata.

## Core Model

- **Request/Response**: A [[Client]] sends a request, a [[Server]] returns a response.
- **Methods**: Common operations include `GET`, `POST`, `PUT`, `DELETE`, and `HEAD`.
- **Status Codes**: Responses indicate outcome (for example, `200 OK`, `404 Not Found`, `500 Internal Server Error`).
- **Headers + Body**: Metadata travels in headers; payload travels in the body.

## Transport and Versions

- **HTTP/1.1**: Text-based messages, persistent connections by default.
- **HTTP/2**: Multiplexes multiple streams over one TCP connection.
- **HTTP/3**: Runs over QUIC (UDP-based transport) to reduce latency and improve connection setup.

## Stateless Nature

HTTP is **stateless** by design: each request is independent.
State across requests is usually implemented with cookies, tokens, or session identifiers.

## Related Concepts

- [[Client]]
- [[Server]]
- [[Finite State Machine (FSM)]]
- [[4-Layer Internet Model]]

