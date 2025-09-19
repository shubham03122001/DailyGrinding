import java.util.*;
import java.util.stream.Collectors;

public class Practice15092025SK {
    public static void main(String[] args) {
//        🔹 1. Stream API Question
//
//        Given a list of integers, find the second highest number using Java Stream API.
//
//        Input: List<Integer> nums = Arrays.asList(10, 20, 30, 40, 50, 50);
//
//        Expected Output: 40


//        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50, 50);
//
//        Integer secondHighestNumber = list.stream()
//                .distinct() //removes duplicate
//                .sorted(Comparator.reverseOrder()) // sort descending
//                .skip(1) // skips the first number that is highest
//                .findFirst()//Pick the next element
//                .orElse(null);
//
//        System.out.println("Second highest number:-"+secondHighestNumber);


//        🔹 2. Collections & Framework Question
//
//        Design a method that counts the frequency of words in a sentence using a HashMap.
//
//                Input: "java spring boot java stream api java"
//
//        Expected Output:
//        java -> 3
//        spring -> 1
//        boot -> 1
//        stream -> 1
//        api -> 1

     // String Input = "java spring boot java stream api java";
//        String[] inputStringArray = Input.split(" ");
//
//        Map<String,Integer> map = new LinkedHashMap<>();
//
//        for(int i = 0 ; i<inputStringArray.length;i++){
//
//            map.put(inputStringArray[i], map.getOrDefault(inputStringArray[i],0)+1);
//        }
//
//
//        Set<String>  keyInMap = map.keySet();
//
//        for(String Key : keyInMap){
//            System.out.println(Key+"--->"+map.get(Key));
//        }

//        the same question can be solved using the stream API

//        LinkedHashMap<String, Long> collect = Arrays.stream(Input.split(" "))
//                .collect(Collectors.groupingBy(
//                        w -> w,
//                LinkedHashMap::new,
//                Collectors.counting()
//                ));
//
//        System.out.println(collect);

//        🔹 3. DSA Question
//
//        Implement a function to check if a string is a palindrome (ignoring spaces and case).
//
//        Input: "A man a plan a canal Panama"
//
//        Expected Output: true

//        String input = "A man a plan a canal Panama";
//
//        String stringWithoutspacesandIgnorecase = "";
//
//        for(int i = 0 ; i<input.length();i++){
//            char character = input.charAt(i);
//
//            if(character!=' '){
//
//                stringWithoutspacesandIgnorecase+=character;
//            }
//
//
//
//        }
//
//        System.out.println(stringWithoutspacesandIgnorecase);
//        String lowerCase = stringWithoutspacesandIgnorecase.toLowerCase();
//        int left=0;
//        int right = lowerCase.length()-1;
//        int count=0;
//        while(left<=right){
//            if(lowerCase.charAt(left)!=lowerCase.charAt(right)){
//                System.out.println("False");
//                count++;
//            }
//            left++;
//            right--;
//
//        }
//        if(count==0){
//            System.out.println("True");
//        }
    }
}
