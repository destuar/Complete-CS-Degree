**This [[collection]] retrieves elements in the order they were added.**
- First-In, First-Out ("FIFO")
- Elements are stored in order of insertion but don't have indexes.
- Can add only to the end of a queue, and can only examine/remove the front.
- This is like a [[vector]] without the ability to index, but it saves time by not shifting any elements when removing the front element.

- Basic queue operations:
	- `enqueue`: Add an element to the back.
	- `dequeue`: Remove the front element.
	- `peek`: Examine the front element.

Example:
This is like a line of people waiting in line for something.

![[Queue Diagram.png]]

Tags:
[[C++]]