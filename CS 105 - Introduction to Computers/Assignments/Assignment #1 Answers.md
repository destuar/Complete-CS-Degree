(This starts from Question 5)

Q5:
With one bit we have two combinations (0 and 1) giving us a range of numbers between 0 and 1.  With two bits, we have four possible bit combinations (00, 01, 10, and 11) giving us a range of numbers between 0 and 3.  With three bits we have eight possible bit combinations (000, 001, 010, 011, 100, 101, 110, and 111) which can be used to represent numbers from 0 to 7.

Write out a similar list, in order, of all the possible combinations that can be represented in four bits.  What is the equivalent range of numbers in decimal?

A: ```0001, 0010, 0011, 0100, 0101, 0110, 0111, 1000, 1001, 1010, 1100, 1101, 1110, 1111```

Q6:
Since three bits can be used to represent numbers between 0 and 7, we could use three bits to store the size of most families.  Three bits wouldn’t be sufficient to store the number of students in a typical discussion section as they run anywhere from 15 to 25 students and three bits can only store numbers from 0 to 7.

How many binary digits would we need to set aside in order to store the number of high school students taking CS105 across the nation (we have 220 high school students in total)? 

Show your work here: 

A: ```let n = number of binary digits. If 2^n gives us the total number of combinations for that amount of bits, then we will need 8 bits (1 byte) to store all high school students taking this course.2^7 bits would be too small, only up to 128, so we need at least 8 bits to store 256 high school students, which 220 can fit into (plus we have a surplus).```

Q7: (Final answer for Q6)

A: ```8```

Q8: 
How many binary digits would we need to set aside in order to store the number of students in a 270-person dorm? 

Show your work here: 

A: ```going off from the previous answer, 2^9 is the next possible amount of bits we can use, and it gives us 512 numbers which is more than enough to store 270.```

Q9: (Final answer for Q8)

A: ```9```

Q10:
How many binary digits would we need to store the total number of undergrads at Stanford (currently there are 6,366 undergrads)?

Show your work here: 

A: ```2^9 = 512,2^10 = 1024,2^11 = 2048,2^12 = 4096,2^13 = 8192,so we'd need 13 bits to store the number 6,366```

Q11: (Final answer for Q10)

A: ```13 bits```

Q12:
Given that CD music is sampled at 44.1kHz (kilohertz) at 16 bits and is stereo, how many bytes would a 3 minute song take?  (Don’t forget there are 8 bits per byte).

A: Convert 3 min to seconds:


Duration (seconds)=3minutes*60seconds/minute=180seconds

file size = bitrate * seconds


bitrate = 44100 (samples, hz) * 16 (bits)  * 2 (channels)


so


filesize = 44100 (samples, hz) * 16 (bits)  * 2 (channels) * 180 (seconds) = 25,344,000 bits


25,344,000 /8 = 3,168,000 bytes


Answer = 3,168,000 bytes

Q13:
How many bytes would the same song take if we converted it to an MP3 file using an encoding rate of 128 kilobits/second?

Remember, The encoding rate for MP3s takes into account that the signal is stereo.  So while you do need to account for separate left and right channels when calculating CD audio file size, you do not when calculating MP3 size.

A:
File Size (bytes)=16kilobytes/second×180 (seconds)

File Size (bytes)=16kilobytes/second*180seconds *1024bytes/kilobyte

File Size (bytes)=2,764,800bytes

Answer: 2,764,800bytes

Q14:
DVD-Audio provides higher quality recording than CD music. On DVD-Audio a variety of different settings are available.  The highest quality provides stereo sampling at 192kHz with 24-bit samples.  Assuming no compression is used (i.e., we don’t perform a frequency transformation and psychoacoustic analysis as with MP3 files) how much space would a 3 minute song take using the highest quality DVD-Audio format?

For the purposes of this problem, assume 2-channel (left and right) stereo, although the standard is capable of supporting fancier formats including 5.1 surround sound (with 5 speakers plus a subwoofer).

A:
Duration (seconds)=3minutes*60seconds/minute=180seconds

File Size =192 kHz* 24 bits*2 channels*180 seconds
File Size =192kHz* 24bits* 2 channels*180seconds

File Size =192,000 Hz* 24 bits*2 *180 seconds
File Size (bytes)=192,000Hz* 24bits* 2*180seconds

File Size =192,000 Hz* 24 bits*2 *180 s=86,400,000 bits
File Size =192,000Hz* 24bits* 2*180s=86,400,000bits

(Q15 and Q16 are skipped, but I will tell you how to get the answer for Q15)

## Windows

* on the bottom left, click on the search bar
* type in ```cmd``` and wait until you see "Command Prompt" listed on the results
* click on Command Prompt, this will bring up a text-interface
* on the text interface, type in ```ipconfig /all```, be sure to account for correct spacing and case
* look for "IPv4 address:" this is your IP address
* look for "Physical address:" this is your MAC address
