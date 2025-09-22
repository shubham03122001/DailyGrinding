import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice22092025SK {
    public static void main(String[] args) {
//        Q1 (Stream API)
//        Problem:
//        Given a list of integers, find the average of all odd numbers using Java Stream API.
//        Input:[1, 2, 3, 4, 5, 6, 7]
//        Expected Output:
//        Average of odd numbers = 4.0
//        (Explanation: Odd numbers → 1, 3, 5, 7 → Average = (1+3+5+7)/4 = 4.0)

        double average = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
                .stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.summarizingInt(number -> number)).getAverage();

        System.out.println("Average:- "+average);

        //Instead of using the .collect after the .filter method we
        //can make use of mapToInt(number->numer).average().orElse(0.0)
       // .mapToInt() transforms it to IntStream, which has number-specific methods (like .sum(),.average())



//        Q2 (Collections & Framework)
//        Problem:
//        You are given an array of integers. Find the element with the highest frequency using a HashMap.
//        Input:[1, 3, 2, 1, 4, 1, 2, 3, 3, 3]
//        Expected Output: 3
//        (Explanation: 3 appears 4 times, more than any other element)
        int[] array = {1, 3, 2, 1, 4, 1, 2, 3, 3, 3};

        int maximumValue = 0;
        int resultingKey = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i <array.length;i++){
            int key = array[i];

            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }

        Set<Integer> keys = map.keySet();

        for(int key : keys){

            if(map.get(key)>maximumValue){
                maximumValue = map.get(key);
                resultingKey = key;
            }
        }

        System.out.println(" key for Maximum value is:-"+resultingKey);



//        Q3 (DSA)
//        Problem:
//        Rotate a string to the left by k positions.
//        Input:String: "abcdef", k = 2
//        Expected Output:"cdefab"

        String input = "abcdef";
        int k = 2 ;
        k = k % input.length();

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = k ; i<input.length();i++){
            char character = input.charAt(i);
            stringBuilder.append(character);
        }
       // System.out.println(stringBuilder);

        for (int i = 0 ; i<k;i++){
            char character = input.charAt(i);
            stringBuilder.append(character);
        }

        System.out.println(stringBuilder);



    }
}
