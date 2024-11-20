In [[C++]], a LinkedList is a [[collection]] that provides the same functionality as a [[Vector]], but instead of being stored as an [[array]], it is made up of *nodes*, each storing a value and a link to the 'next' node. These links are called [[Pointers]].

- Internally, the list knows its *front* node only (sometimes *back* node too), but can go to 'next' repeatedly to reach other nodes.

![[LinkedList Diagram.png]]