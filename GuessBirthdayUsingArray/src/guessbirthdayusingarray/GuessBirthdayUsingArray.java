/*
Sean O'Brien
Birthday Guessing Game.

 What is really happening is that we are converting the birthday to binary 
(base two) and back!

The card (set) starting with 1 contains all the numbers whose 1's digit in 
binary is 1:

    1 = 00001 (base 2)
    3 = 00011
    5 = 00101
    7 = 00111
and so on. (These are, in fact, all the odd numbers.)

The next card (set), starting with 2, contains all the number whose 2's 
digit in binary is 1:

    2 = 00010 (base 2)
    3 = 00011
    6 = 00110
    7 = 00111
and so on.

Each number appears on one card for each digit that is equal to one. 
If you think about what base 2 means, you can see that, for example,

    6 = 110 (base 2) = 1 * 2^2 + 1 * 2^1 + 0 * 2^0
                     = 1 * 4   + 1 * 2   + 0 * 1
                     = 4 + 2

Thus, expanding the number in binary adds the numbers of the cards it 
is on. In selecting the cards, the student is converting the number to 
binary.

What makes this work well with the calendar is that 31, the largest 
number of days in a month, happens to be one less than 2^5 = 32, so 
that a nonzero 5-digit binary number can go from 1 to 31.

Your first answer is the 1st (right-most) exponential 0 or 1 in the binary 
number.  Your second answer would be the next exponential value; i.e., if your 
answers in order were:
0
0
1
0
1

... then the binary number would be 10100, reading bottom to top.  Converting 
from binary to decimal:  10100 = 20

*/
package guessbirthdayusingarray;

import java.util.Scanner;

public class GuessBirthdayUsingArray {

    public static void main(String[] args) {
        int day = 0;
        int answer;
        int[][][] dates = {
            {{1, 3, 5, 7},
            {9, 11, 13, 15},
            {17, 19, 21, 23},
            {25, 27, 29, 31}},
            {{2, 3, 6, 7},
            {10, 11, 14, 15},
            {18, 19, 22, 23},
            {26, 27, 30, 31}},
            {{4, 5, 6, 7},
            {12, 13, 14, 15},
            {20, 21, 22, 23},
            {28, 29, 30, 31}},
            {{8, 9, 10, 11},
            {12, 13, 14, 15},
            {24, 25, 26, 27},
            {28, 29, 30, 31}},
            {{16, 17, 18, 19},
            {20, 21, 22, 23},
            {24, 25, 26, 27},
            {28, 29, 30, 31}}};

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Is your birthday in Set " + (i + 1) + "?");
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.printf("%4d", dates[i][j][k]);
                }
                System.out.println();
            }

            System.out.print("\nEnter '0' for No and '1' for Yes:  ");
            answer = input.nextInt();
            System.out.println();

            if (answer == 1) {
                day += dates[i][0][0];
            }
        }
        System.out.println("Your birthday 'day' is " + day);
    }
}
