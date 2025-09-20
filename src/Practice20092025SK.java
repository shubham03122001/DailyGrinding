import java.lang.reflect.Array;
import java.util.*;

public class Practice20092025SK {
    public static void main(String[] args) {
//        🔹 Q1 (Stream API)
//        Problem:
//        Given a list of strings, find the longest string using Java Stream API.
//        Input:["java", "springboot", "microservices", "api"]
//        Expected Output: microservices

        List<String> list = Arrays.asList("java", "springboot", "microservices", "api");

        String maxWordByLength = list.stream()
                .max(Comparator.comparing(word->word.length()))
                .orElse(null);

        System.out.println(maxWordByLength);


//       🔹 Q2 (Collections & Framework)
//        Problem:
//        You are given an array of integers. Find the top 2 most frequent elements using a HashMap.
//        Input:[1, 1, 1, 2, 2, 3]
//        Expected Output: [1, 2]
//        (Explanation: 1 appears 3 times, 2 appears 2 times)

        int[] arr = {1, 1, 1, 2, 2, 3};
        Map<Integer,Integer> map = new HashMap<>();
        
        
        for(int i = 0 ; i<arr.length;i++){
            int key = arr[i];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);

            }
        }

        System.out.println("Map"+map);

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        System.out.println("Keys:-"+keys);

        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer k1 , Integer k2) {
                return map.get(k2) - map.get(k1); //compare count i.e values of keys

            }
        });

        //Now pick top 2
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i<2;i++){
            result.add(keys.get(i));

        }

        System.out.println("Result:-"+result);


        //2nd approach :- this can be solved using stream as well
        List<Integer> top2 = map.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue()) //Sort by descending
                .limit(2)//Top 2
                .map(Map.Entry::getKey) //Extract the key here
                .toList();

        System.out.println(top2);

//        🔹 Q3 (DSA)
//        Problem:
//        Reverse the words in a given string.-
//         1)Words are separated by spaces.
//         2)Do it without using built-in reverse methods for the whole string.
//         Input:"I love Java"
//         Expected Output: "Java love I"

        String input = "I love Java";
        String[] inputArray = input.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = inputArray.length - 1; i >= 0; i--) {
            sb.append(inputArray[i]).append(" ");
        }

        System.out.println(sb.toString().trim());



    }
}
