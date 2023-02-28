# Foodchain
Solving the problem Foodchain while practicing union-find sets
## Problem
### Background
There are N animals with index 1, 2, ..., N. Every animal belongs to category A or B or C. Knowing that A eats B, B eats C, C eats A, this program should judge whether these K informations is correct, and print the count of wrong informations.
### Information has two types:
1. x and y are in the same category.
2. x eats y.
### Limits:
1<=N<=50000

0<=K<=10000
### Input
The first line has two Integer: N and K.

Then there are K lines of information, and every line has 3 Integers, representing for "the type of information" "x" "y".
### Example 1
#### Input 1
100 7

1 101 1

2 1 2

2 2 3

2 3 3

1 1 3

2 3 1

1 5 5
#### Output 1
3
#### Note
Information 1, 4, 5 are wrong.
