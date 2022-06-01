import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] input = {4,5,6,8,5,3,5,6,-25,-25,-25,-25,-100};
        int[] n = {1, 2, 2};
        String inp = "1010000";
        String p1 = "rock";
        String p2 = "paper";
        System.out.println("Count of positive numbers and sum of negatives numbers in array "+Arrays.toString(input)+": " + Arrays.toString(countPositivesSumNegatives(input)));
        System.out.println("\nBinary to decimal of "+inp+": " + binToDecimal(inp));
        System.out.println("\nSum of the squares of array "+Arrays.toString(n)+": "+squareSum(n));
        System.out.println("\nPlayer 1 chose "+p1+", and Player 2 chose "+p2+" so "+rps(p1, p2));
    }
    /* (8kyu) (https://www.codewars.com/kata/576bb71bbbcf0951d5000044)
    Given an array of integers, return an array where the first element is the count of positives numbers and the second element is sum of negative numbers.
     0 is neither positive nor negative.
    If the input is an empty array or is null, return an empty array.
    Example
    For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65].
*/
    public static int[] countPositivesSumNegatives(int[] input) {
        int positives = 0, negatives = 0;
        if ((input != null) && (input.length > 0)) {
            for (int number : input) {
                if (number>0){
                    positives++;
                }else {
                    negatives += number;
                }

            }
            return new int[]{positives, negatives};
        }
        return new int[]{};
    }
    /* (8kyu) (https://www.codewars.com/kata/57a5c31ce298a7e6b7000334)
    Complete the function which converts a binary number (given as a string) to a decimal number.
    For example, "1010000", should give 80.
    */
    public static int binToDecimal(String inp){
        char[] arr = inp.toCharArray();
        int result = 0;
        if (!inp.isEmpty()){
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '1') {
                    result += Math.pow(2, arr.length - i - 1);
                }
            }
            return result;
        }
        return 0;
    }
    /* (8kyu) (https://www.codewars.com/kata/515e271a311df0350d00000f/java)
    Complete the square sum function so that it squares each number passed into it and then sums the results together.
    For example, for [1, 2, 2] it should return 9 because 1^2 + 2^2 + 2^2 = 9.*/
    public static int squareSum(int[] n){
        int result = 0;
        if (n != null){
            for (int num : n) {
                result += Math.pow(num, 2);
            }
            return result;
        }
        return 0;
    }
    /* (8kyu) (https://www.codewars.com/kata/5672a98bdbdd995fad00000f/train/java)
    Rock Paper Scissors
    Let's play! You have to return which player won! In case of a draw return Draw!.
    Examples:
    rps('scissors','paper') // Player 1 won!
    rps('scissors','rock') // Player 2 won!
    rps('paper','paper') // Draw!*/
    public static String rps(String p1, String p2) {
        if (!p1.equals(p2)){
            if((p1.equals("scissors") && p2.equals("paper")) || (p1.equals("rock") && p2.equals("scissors")) || (p1.equals("paper") && p2.equals("rock"))){
                return "Player 1 won!";
            }
            else{
                return "Player 2 won!";
            }
        }
        return "Draw!";
    }
}

