import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice19092025SK {
    public static void main(String[] args) {
//        🔹 Q1 (Stream API)
//
//        Problem:
//        Given a list of integers, return a list containing only the unique even numbers, sorted in ascending order.
//
//                Input: [4, 2, 8, 6, 2, 4, 10, 8]
//
//        Expected Output: [2, 4, 6, 8, 10]

        List<Integer> list = Arrays.asList(4, 2, 8, 6, 2, 4, 10, 8);

        List<Integer> finalAnswer = list.stream()
                .filter(num -> num % 2 == 0)  // keep only even numbers
                .distinct()
                .sorted()
                .toList();

        System.out.println("Final answer:-"+finalAnswer);

//        🔹 Q2 (Collections & Framework)
//
//        Problem:
//        You are given a list of words. Find the frequency of each word using a HashMap.
//
//        Input:["apple", "banana", "apple", "orange", "banana", "apple"]
//        Expected Output:
//        apple → 3
//        banana → 2
//        orange → 1

        List<String> list1 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Integer> frequency = list1.stream()
                .collect(Collectors.toMap(k -> k, v -> 1, (previousCount, currentCount) -> previousCount + currentCount, LinkedHashMap::new));

        // added LinkedHashMap::New to preserve the insertion order




        System.out.println(frequency);

//        🔹 Q3 (DSA – Arrays & Strings)
//
//        Problem:
//        Check if a given string is a palindrome (same forwards and backwards).
//
//        Input:
//        "madam"
//
//        Expected Output:
//        true
//
//        Input:
//        "hello"
//
//        Expected Output:
//        false

        String input="oppo";

        int left = 0 ;
        int right = input.length()-1;

        boolean isPalindrome = true;

        while(left<right){
            if(input.charAt(left)!=input.charAt(right)){
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }


        System.out.println("Is palindrome :-"+isPalindrome);




    }
}
