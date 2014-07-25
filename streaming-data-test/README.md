## Problem 1 Missing Letters ##
 
The sentence "A quick brown fox jumps over the lazy dog" contains every single letter in the alphabet. Such sentences are called pangrams. 

You are to write a method getMissingLetters, which takes as input a string containing a sentence and returns all the letters not present at all in the sentence (i.e., the letters that prevent it from being a pangram). 

You should ignore the case of the letters in sentence, and your return should be all lower case letters, in alphabetical order. You should also ignore all non-alphabet characters as well as all non-US-ASCII characters.
Imagine that the method you write will be called many thousands of times in rapid succession on strings with length ranging from 0 to 50. 

Accordingly, you should try to write code that runs as quickly as possible. Also, imagine the case when the input string is quite large (e.g., tens of megabytes). See if you can develop an algorithm that handles this case efficiently while still running very quickly on smaller inputs.

###Examples:###
(Note that in the examples below, the double quotes should not be considered part of the input or output strings.)

|Input Text|Output|
|-----------|------|
|"A quick brown fox jumps over the lazy dog"|""|
|"A slow yellow fox crawls under the proactive dog"|"bjkmqz"|
|"Lions, and tigers, and bears, oh my!"|"cfjkpquvwxz"|
| ""|"abcdefghijklmnopqrstuvwxyz"|


## Problem 2 Test Automation ##
A collection of particles is contained in a linear chamber. They all have the same speed, but some are headed toward the right and others are headed toward the left. These particles can pass through each other without disturbing the motion of the particles, so all the particles will leave the chamber relatively quickly.

You will be given the initial conditions by a string 'init' containing at each position an 'L' for a leftward moving particle, an 'R' for a rightward moving particle, or a '.' for an empty location. 'init' shows all the positions in the chamber. Initially, no location in the chamber contains two particles passing through each other.

We would like an animation of the particles as they move. At each unit of time, we want a string showing occupied locations with an 'X' and unoccupied locations with a '.'. Create a method 'animate' that takes a positive integer 'speed' and a string 'init' giving the initial conditions. 

The speed is the number of positions each particle moves in one unit of time. The method will return an array of strings in which each successive element shows the occupied locations at each time step. The first element of the return should show the occupied locations at the initial instant (at time = 0) in the 'X', '.' format. The last element in the return should show the empty chamber at the first time that it becomes empty.

Again, imagine that the method you write will be called thousands of times for varying initial conditions with size ranging from 0 to 50, and also imagine the case when init is several hundred thousand locations in size (though with speed > size / 20 or so).  Try to handle both of these cases efficiently in your implementation.

###Examples:###
(Note that in the examples below, the double quotes should not be considered part of the input or output strings.)

|Input|Output|Descripton|
|-----|-------|----------|
| 2, "..R...." | { "..X....",<br> "....X..",<br> "......X",<br> "......." }| The single particle starts at the 3rd position, moves to the 5th, then 7th, and then out of the chamber. |
| 3,  "RR..LRL"| { "XX..XXX",<br> ".X.XX..",<br> "X.....X",<br> "......." }|Note that, at the first time step after init, there are actually 4 particles in the chamber, but two are passing through each other at the 4th position|
| 2,  "LRLR.LRLR" | { "XXXX.XXXX",<br> "X..X.X..X",<br> ".X.X.X.X.",<br> ".X.....X.",<br>  "........." } | At time 0 (init) there are 8 particles. At time 1, there are still 6 particles, but only 4 positions are occupied since particles are passing through each other. |
| 10,  "RLRLRLRLRL" | { "XXXXXXXXXX", <br> ".........." } | These particles are moving so fast that they all exit the chamber by time 1.|
| 1,  "..." | { "..." } | |
| 1,  "LRRL.LR.LRR.R.LRRL." | { "XXXX.XX.XXX.X.XXXX.",<br> "..XXX..X..XX.X..XX.",<br> ".X.XX.X.X..XX.XX.XX",<br> "X.X.XX...X.XXXXX..X",<br> ".X..XXX...X..XX.X..",<br> "X..X..XX.X.XX.XX.X.",<br> "..X....XX..XX..XX.X",<br> ".X.....XXXX..X..XX.",<br> "X.....X..XX...X..XX",<br> ".....X..X.XX...X..X",<br> "....X..X...XX...X..",<br> "...X..X.....XX...X.",<br> "..X..X.......XX...X",<br> ".X..X.........XX...",<br> "X..X...........XX..",<br> "..X.............XX.",<br> ".X...............XX",<br>  "X.................X",<br>  "..................." } | |

