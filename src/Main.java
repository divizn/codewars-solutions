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
        System.out.println("\nAmount of 1s in int 2 is " + countBits(2));
        System.out.println("\nIntsteam " + anaiian(2, 2));
        System.out.println("\ntostring " + maskify("jfajfiajfiajf"));
        System.out.println("\nreversed The quick brown fox jumps over the lazy dog: " + spinWords(sentence));
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
        for (int classPoint : classPoints) {
            sum += classPoint;
        }
        sum = sum + yourPoints;
        sum = sum / (classPoints.length + 1);
        return sum <= yourPoints;
    }

    /*
     * (7kyu) (https://www.codewars.com/kata/54ff3102c1bad923760001f3/train/java)
     * Return the number (count) of vowels in the given string.
     * We will consider A, E, I, O, U as vowels for this Kata (but not y).
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
     * (7kyu) (https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java)
     * Usually when you buy something, you're asked whether your credit card number,
     * phone number or answer to your most secret question is still correct.
     * However, since someone could look over your shoulder, you don't want that
     * shown on your screen. Instead, we mask it.
     * Your task is to write a function maskify, which changes all but the last four
     * characters into '#'.
     * Examples:
     * "4556364607935616" --> "############5616"
     * "64607935616" --> "#######5616"
     * "1" --> "1"
     * "" --> ""
     * // "What was the name of your first pet?"
     * "Skippy" --> "##ippy"
     * "Nananananananananananananananana Batman!"
     * -->
     * "####################################man!"
     */
    public static String maskify(String str) {
        if (str.length() <= 4)
            return str;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 4; i++) {
            sb.append("#");
        }
        sb.append(str.substring(str.length() - 4));
        return sb.toString();
    }

    /*
     * (7kyu) (https://www.codewars.com/kata/562f91ff6a8b77dfe900006e/train/java)
     * My friend John likes to go to the cinema. He can choose between system A and
     * system B:
     * System A - he buys a ticket (15 dollars) every time
     * System B - he buys a card (500 dollars) and a first ticket for 0.90 times the
     * ticket price and then for each additional ticket he pays 0.90 times the price
     * paid for the previous ticket.
     * John wants to know how many times he must go to the cinema so that the final
     * result of System B, when rounded up to the next dollar, will be cheaper than
     * System A.
     * The function movie has 3 parameters: card (price of the card), ticket (normal
     * price of a ticket), perc (fraction of what he paid for the previous ticket)
     * and returns the first n such that
     * ceil(price of System B) < price of System A.
     */
    public static int movie(int card, int ticket, double perc) {
        double priceOfA = 0;
        double priceOfB = card;
        int i = 0;
        while (Math.ceil(priceOfB) >= priceOfA) {
            i++;
            priceOfA += ticket;
            priceOfB += ticket * Math.pow(perc, i);
        }
        return i;
    }

    /*
     * (7kyu) (https://www.codewars.com/kata/55f2b110f61eb01779000053/train/java)
     * Given two integers a and b, which can be positive or negative, find the sum
     * of all the integers between and including them and return it. If the two
     * numbers are equal return a or b.
     * Note: a and b are not ordered!
     * Examples (a, b) --> output (explanation)
     * (1, 0) --> 1 (1 + 0 = 1)
     * (1, 2) --> 3 (1 + 2 = 3)
     * (0, 1) --> 1 (0 + 1 = 1)
     * (1, 1) --> 1 (1 since both are same)
     * (-1, 0) --> -1 (-1 + 0 = -1)
     * (-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)
     */
    public static int anaiian(int a, int b) {
        int sum = 0;
        if (a > b) {
            for (int i = b; i <= a; i++) {
                sum += i;
            }
        } else {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        }
        return sum;
    }

    /*
     * (7kyu) (https://www.codewars.com/kata/5259b20d6021e9e14c0010d4/train/java)
     * Complete the function that accepts a string parameter, and reverses each word
     * in the string. All spaces in the string should be retained.
     * Examples:
     * "This is an example!" ==> "sihT si na !elpmaxe"
     * "double  spaces" ==> "elbuod  secaps"
     */
    public static String reverseWords(String str) {
        if (str.trim() == "")
            return str;
        String[] words = str.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reverse = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reverse += word.charAt(j);
            }
            result += reverse + " ";
        }
        return result.trim();
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

    /*
     * (6kyu) (https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java)
     * Write a function that takes an integer as input, and returns the number of
     * bits that are equal to one in the binary representation of that number. You
     * can guarantee that input is non-negative.
     * Example: The binary representation of 1234 is 10011010010, so the function
     * should return 5 in this case
     */
    public static int countBits(int n) {
        String binVal = Integer.toBinaryString(n);
        int count = (int) binVal.chars().filter(ch -> ch == '1').count();
        return count;
    }

    /*
     * (6kyu) (https://www.codewars.com/kata/5264d2b162488dc400000001/train/java)
     * Write a function that takes in a string of one or more words, and returns the
     * same string, but with all five or more letter words reversed (Just like the
     * name of this Kata). Strings passed in will consist of only letters and
     * spaces. Spaces will be included only when more than one word is present.
     * Examples:
     * spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
     * spinWords( "This is a test") => returns "This is a test" spinWords(
     * "This is another test" )=> returns "This is rehtona test"
     */
    public static String spinWords(String sentence) {
        String words[] = sentence.split(" ");
        String newSentence = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                String str = words[i];
                StringBuilder sb = new StringBuilder(str);
                newSentence += sb.reverse() + " ";
            } else {
                newSentence += words[i] + " ";
            }
        }
        return newSentence.trim();
    }

    /*
     * (6kyu) (https://www.codewars.com/kata/54da539698b8a2ad76000228/train/java)
     * You live in the city of Cartesia where all roads are laid out in a perfect
     * grid. You arrived ten minutes too early to an appointment, so you decided to
     * take the opportunity to go for a short walk. The city provides its citizens
     * with a Walk Generating App on their phones -- everytime you press the button
     * it sends you an array of one-letter strings representing directions to walk
     * (eg. ['n', 's', 'w', 'e']). You always walk only a single block for each
     * letter (direction) and you know it takes you one minute to traverse one city
     * block, so create a function that will return true if the walk the app gives
     * you will take you exactly ten minutes (you don't want to be early or late!)
     * and will, of course, return you to your starting point. Return false
     * otherwise.
     * Note: you will always receive a valid array containing a random assortment of
     * direction letters ('n', 's', 'e', or 'w' only). It will never give you an
     * empty array (that's not a walk, that's standing still!).
     */
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }

        int x = 0;
        int y = 0;

        for (Character c : walk) {
            switch (c) {
                case 'n':
                    y++;
                    break;
                case 's':
                    y--;
                    break;
                case 'e':
                    x--;
                    break;
                case 'w':
                    x++;
                    break;
                default:
                    break;
            }
        }

        return x == 0 && y == 0;
    }
}
