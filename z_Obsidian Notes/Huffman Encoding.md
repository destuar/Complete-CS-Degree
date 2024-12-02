**Uses variable lengths for different characters to take advantage of their relative frequencies.**
- Standard [[ASCII]] encoding = exactly 8 [[bit]]s (1 [[byte]]) per char.
- Some characters occur more than others. If those characters used <8 bits each, the file would be smaller.
- Other characters need >8, but that's OK; they're rare.

![[Huffman Encoding Diagram.png]]

![[Building Huffman Encoding.png]]