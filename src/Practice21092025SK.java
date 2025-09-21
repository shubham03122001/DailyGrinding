import java.util.*;

public class Practice21092025SK {
    public static void main(String[] args) {
//        Q1 (Stream API)
//        Problem:
//        Given a list of integers, return a new list that contains only the even numbers,
//        sorted in descending order, using Stream API.
//        📥 Input:[5, 2, 8, 1, 3, 10]
//        📤 Expected Output:[10, 8, 2]


        List<Integer> list = Arrays.asList(5, 2, 8, 1, 3, 10);


        List<Integer> answer = list.stream()
                .filter(number -> number % 2 == 0)
                .sorted((a,b)->b-a)
                .toList();

        System.out.println("Answer:-"+answer);

//        Q2 (Collections & Framework)
//        Problem: You are given a sentence. Count the frequency of each word using a HashMap.
//        Input:"I love Java I love coding"
//        Output: {I=2, love=2, Java=1, coding=1}


        String input = "I love Java I love coding";
        Map<String,Integer> map = new LinkedHashMap<>();

        String[] inputArray = input.split(" ");

        for(int i = 0 ; i<inputArray.length;i++){
            String key = inputArray[i];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
        }

        System.out.println("Map:-"+map);
//
//        Q3 (DSA – Arrays/Strings)
//        Problem:
//        Reverse each word in a given sentence while maintaining the word order.
//        Input:"I love Java"
//         Output:"I evol avaJ"

        String inputString = "I love Java";
        StringBuilder stringBuilder = new StringBuilder();

        String[] inputStringArray = inputString.split(" ");

        for(int i = 0 ; i<inputStringArray.length;i++){

            String word = inputStringArray[i];

            for(int j  = word.length()-1 ; j>=0;j--){
                stringBuilder.append(word.charAt(j));

            }
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString().trim());


    }
}
