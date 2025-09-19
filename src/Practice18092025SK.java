import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice18092025SK {

    public static void main(String[] args) {
//        🔹 Q1 (Stream API)
//
//        Problem:
//        Given a list of integers, find the sum of all even numbers using Java Stream API.
//
//        Input:[1, 2, 3, 4, 5, 6]
//        Expected Output:12   // (2 + 4 + 6)

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        long sum = list.stream()
//                .filter(number -> number % 2 == 0)
//                .collect(Collectors.summarizingInt(x -> x))
//                .getSum();
//        ✅ Correct — this works fine.
//⚡ But Collectors.summarizingInt is overkill here. It builds a
//        full IntSummaryStatistics object (with min, max, count, avg, sum). You only need the sum.
//        mapToInt converts to an IntStream.
//  Then .sum() directly gives the result → simpler & efficient.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = list.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();


        System.out.println("Sum of even numbers:-"+sum);

//        🔹 Q2 (Collections & Framework)
//
//        Problem:
//        You are given a string. Find the first repeated character using a HashMap.
//
//        Input:"programming"
//        Expected Output:r

        String input="programming";

        Map<Character ,Integer> map = new HashMap<>();

        for(int i = 0 ; i <input.length();i++){
            char key = input.charAt(i);

            if(map.containsKey(key)){
                System.out.println("First repeating character--> "+key);
                break;
            }else{
                map.put(key,1);
            }
        }

//        🔹 Q3 (DSA – Arrays & Strings)
//
//        Problem:
//        Given an array of integers, rotate the array to the right by k steps.
//
//        Input: nums = [1, 2, 3, 4, 5, 6, 7], k = 3
//        Expected Output:[5, 6, 7, 1, 2, 3, 4]

        int[] arr = {1,2,3,4,5,6,7};
        int k = 8;
        k=k% arr.length;
        int endIndex = arr.length-k;
        int[] answer = new int[arr.length];

        for(int i = 0 ; i<endIndex;i++){
            answer[i+k]=arr[i];

        }

        int indexCounter =0;
        for(int i = endIndex;i<answer.length;i++){
            answer[indexCounter] = arr[i];
            indexCounter++;


        }

        for(int i = 0 ; i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }



    }
}
