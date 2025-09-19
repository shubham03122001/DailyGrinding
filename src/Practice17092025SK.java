import java.util.*;
import java.util.stream.Collectors;

public class Practice17092025SK {

    public static void main(String[] args) {
//        🔹 Q1 (Stream API)
//
//        Given a list of strings, return the list sorted by the last character of each string using Java Stream API.
//
//        Input:
        //["apple", "banana", "cherry", "date"]
//        Expected Output:
//        ["banana", "apple", "date", "cherry"]
//        (Explanation: sorted by 'a', 'e', 'e', 'y')

        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> collect = list.stream()
                .sorted(Comparator.comparing(
                                (String word) -> word.charAt(word.length() - 1)))

                .collect(Collectors.toList());

        System.out.println(collect);

//        🔹 Q2 (Collections & Framework)
//
//        You are given a list of integers. Write a program to find the first non-repeating element using a LinkedHashMap.
//
//        Input:
//        [9, 4, 9, 6, 7, 4]
//
//        Expected Output:
//        6
        Map<Integer,Integer> map = new LinkedHashMap<>();

        int[] arr = {9,4,9,6,7,4};

        for(int i = 0 ; i< arr.length;i++){
            int key = arr[i];
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                map.put(key , map.get(key)+1);
            }

        }

        Set<Integer> keys = map.keySet();

        for(int key:keys){
            if(map.get(key)==1){
                System.out.println("Key-->"+key);
                break;
            }

        }


//        🔹 Q3 (DSA)
//
//        Implement a function to check if a number is a prime number.
//
//        Input:
//        29
//        Expected Output:true

        int number = 29;
        int count=0;
        boolean isPrime = true;
        for(int i = 2 ; i<=Math.sqrt(number);i++){
            if(number%i==0){
                isPrime=false;
                break;
            }
        }



        System.out.println("Is number prime:-"+isPrime);

//        double sqrt = Math.sqrt(29);
//        System.out.println("Square root:-"+sqrt);


    }
}
