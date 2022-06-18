import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] input = { 4, 5, 6, 8, 5, 3, 5, 6, -25, -25, -25, -25, -100 };
        int[] n = { 1, 2, 2 };
        int[] classPoints = { 10, 6, 8, 7, 5, 10 };
        int yourPoints = 9;
        int number = 47;
        String sentence = "The quick brown fox jumps over the lazy dog";
        String inp = "1010000";
        String p1 = "rock";
        String p2 = "paper";
        System.out.println("Count of positive numbers and sum of negatives numbers in array " + Arrays.toString(input)
                + ": " + Arrays.toString(countPositivesSumNegatives(input)));
        System.out.println("\nBinary to decimal of " + inp + ": " + binToDecimal(inp));
        System.out.println("\nSum of the squares of array " + Arrays.toString(n) + ": " + squareSum(n));
        System.out.println("\nPlayer 1 chose " + p1 + ", and Player 2 chose " + p2 + " so " + rps(p1, p2));
        System.out.println("\nClass points: " + Arrays.toString(classPoints) + ", and your points: " + yourPoints
                + ". Your points higher than class average: " + betterThanAverage(classPoints, yourPoints));
        System.out.println("\nSum of all natural numbers multiples of 3 and 5 below the number " + number + " is: "
                + sumOfNaturalNumbers(number));
        System.out.println("\nCount of vowels in sentence " + sentence + ": " + countVowels(sentence));
    }

    /*
     * (8kyu) (https://www.codewars.com/kata/576bb71bbbcf0951d5000044)
     * Given an array of integers, return an array where the first element is the
     * count of positives numbers and the second element is sum of negative numbers.
     * 0 is neither positive nor negative.
     * If the input is an empty array or is null, return an empty array.
     * Example
     * For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you
     * should return [10, -65].
     */
    public static int[] countPositivesSumNegatives(int[] input) {
        int positives = 0, negatives = 0;
        if ((input != null) && (input.length > 0)) {
            for (int number : input) {
                if (number > 0) {
                    positives++;
                } else {
                    negatives += number;
                }

            }
            return new int[] { positives, negatives };
        }
        return new int[] {};
    }

    /*
     * (8kyu) (https://www.codewars.com/kata/57a5c31ce298a7e6b7000334)
     * Complete the function which converts a binary number (given as a string) to a
     * decimal number.
     * For example, "1010000", should give 80.
     */
    public static int binToDecimal(String inp) {
        char[] arr = inp.toCharArray();
        int result = 0;
        if (!inp.isEmpty()) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '1') {
                    result += Math.pow(2, arr.length - i - 1);
                }
            }
            return result;
        }
        return 0;
    }

    /*
     * (8kyu) (https://www.codewars.com/kata/515e271a311df0350d00000f/java)
     * Complete the square sum function so that it squares each number passed into
     * it and then sums the results together.
     * For example, for [1, 2, 2] it should return 9 because 1^2 + 2^2 + 2^2 = 9.
     */
    public static int squareSum(int[] n) {
        int result = 0;
        if (n != null) {
            for (int num : n) {
                result += Math.pow(num, 2);
            }
            return result;
        }
        return 0;
    }

    /*
     * (8kyu) (https://www.codewars.com/kata/5672a98bdbdd995fad00000f/train/java)
     * Rock Paper Scissors
     * Let's play! You have to return which player won! In case of a draw return
     * Draw!.
     * Examples:
     * rps('scissors','paper') // Player 1 won!
     * rps('scissors','rock') // Player 2 won!
     * rps('paper','paper') // Draw!
     */
    public static String rps(String p1, String p2) {
        if (!p1.equals(p2)) {
            if ((p1.equals("scissors") && p2.equals("paper")) || (p1.equals("rock") && p2.equals("scissors"))
                    || (p1.equals("paper") && p2.equals("rock"))) {
                return "Player 1 won!";
            } else {
                return "Player 2 won!";
            }
        }
        return "Draw!";
    }

    /*
     * (8kyu) (https://www.codewars.com/kata/5601409514fc93442500010b/train/java)
     * There was a test in your class, and you passed it. Congratulations!
     * But you're an ambitious person. You want to know if you're better than the
     * average student in your class.
     * You receive an array with your peers' test scores. Now calculate the average
     * and compare your score!
     * Return True if you're better, else False!
     * Note:
     * Your points are not included in the array of your class's points. For
     * calculating the average point you may add your point to the given array!
     */
    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
        int sum = 0;
        for (int i = 0; i < classPoints.length; i++) {
            sum += classPoints[i];
        }
        sum = sum + yourPoints;
        sum = sum / (classPoints.length + 1);
        if (sum > yourPoints) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * (7kyu) (https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/java)
     * Return the number (count) of vowels in the given string.
     * We will consider a, e, i, o, u as vowels for this Kata (but not y).
     * The input string will only consist of lower case letters and/or spaces.
     */
    public static int countVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    /*
     * (6kyu) (https://www.codewars.com/kata/514b92a657cdc65150000006/train/java)
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
     * get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Finish the solution so that it returns the sum of all the multiples of 3 or 5
     * below the number passed in. Additionally, if the number is negative, return 0
     * (for languages that do have them).
     * Note: If the number is a multiple of both 3 and 5, only count it once.
     */
    public static int sumOfNaturalNumbers(int number) {
        int sum = 0;
        if (number > 0) {
            for (int i = 1; i < number; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    sum += i;
                } else if (i % 3 == 0) {
                    sum += i;
                } else if (i % 5 == 0) {
                    sum += i;
                }
            }
            return sum;
        }
        return 0;
    }
}
