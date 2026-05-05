## Definition

A **state machine** (also called a **finite state machine**, **FSM**) is a model used to represent a system that moves among a **finite** set of **states** when **inputs** or **events** occur.

## Key Components

1. **States** — Distinct configurations the system can be in.
2. **Transitions** — Rules that define how the system moves from one state to another (often labeled by input/event).
3. **Inputs / events** — What triggers a transition (messages, timers, user actions).
4. **Initial state** — Where execution begins.
5. **(Optional) accepting / final states** — Used when modeling languages or “goal reached” behavior.

## Variants (Common Names)

- **Deterministic FSM (DFA-style)** — Each state + input leads to at most one next state.
- **Non-deterministic FSM** — Multiple possible next states per input (useful for modeling before refining).
- **Mealy machine** — Outputs may depend on **state and transition** (edge-labeled outputs).
- **Moore machine** — Outputs depend only on **current state**.

## Why Use Them

- Clarify allowed sequences of behavior (“what can happen next?”).
- Drive implementations (explicit states reduce ambiguous corner cases).
- Support testing (cover transitions and invalid paths).

## State Machines in Networking

Protocols and stacks are often specified or implemented as state machines:

- **TCP** connection lifecycle (OPEN, ESTABLISHED, closing states, etc.).
- **HTTP clients/servers** — request/response phases over a connection even though HTTP is stateless at the message semantics level.

For a concrete networking note with an **HTTP request** example and a diagram, see [[Finite State Machine (FSM)]].

## Related Concepts

- [[Finite State Machine (FSM)]]
- [[Transmission Control Protocol (TCP)]]
- [[HTTP]]
- [[Flow Control]]
