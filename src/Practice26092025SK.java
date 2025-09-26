import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice26092025SK {

    public static void main(String[] args) {
//        Q1 (Stream API)
//        Problem:
//        Given a list of strings, find the first string that has length greater than 5.
//        If no such string exists, return "Not Found".
//        Input:["cat", "elephant", "dog", "tiger", "lion"]
//        Expected Output:elephant

        List<String> list = Arrays.asList("cat", "elephant", "dog", "tiger", "lion");

        String result = list.stream()
                .filter(animal -> animal.length() > 5)
                .findFirst()
                .orElse("Not found");


        System.out.println("Result:-"+result);

//        Q2 (Collections & Framework)
//        Problem:
//        You are given a List<String> of words.
//        Count how many words start with each letter using a HashMap.
//        Input:["apple", "banana", "apricot", "blueberry", "cherry", "avocado"]
//        Expected Output:
//        a → 3
//        b → 2
//        c → 1

        List<String> stringList = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry", "avocado");

        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i<stringList.size();i++){
            String fruit = stringList.get(i);
            char firstCharacter = fruit.charAt(0);
            if(map.containsKey(firstCharacter)){
                map.put(firstCharacter, map.get(firstCharacter)+1);
            }else{
                map.put(firstCharacter,1);

            }



        }

        System.out.println("Map:-"+map);



//        Q3) DSA
//        1. Two Sum(EASY)
//        Given an array of integers nums and an integer target, return
//        indices of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution,
//        and you may not use the same element twice.
//        You can return the answer in any order.

//        Example 1:
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        Example 2:
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        Example 3:
//        Input: nums = [3,3], target = 6
//        Output: [0,1]

        //Bruteforce
        int[] nums  = {2,7,11,15};
        int target = 9;
        int[] answer = new int[2];

//        for(int i = 0 ;i<nums.length-1;i++){
//            for(int j = i+1 ; j<nums.length;j++){
//                if(nums[i]+nums[j]==target){
//                    answer[0]=i;
//                    answer[1]=j;
//                }
//            }
//        }
//
//        System.out.println(answer[0]);
//        System.out.println(answer[1]);

        //Better approach
        //Input :-
//        int[] nums  = {2,7,11,15};
//        int target = 9;
//        int[] answer = new int[2];
        Map<Integer,Integer> newMap = new HashMap<>();
        for(int i = 0  ; i< nums.length;i++){
            int number = nums[i];
            int key = target - number;

            if(newMap.containsKey(key)){
                answer[0] = i;
                answer[1] = newMap.get(key);
                break;

            }else{
                newMap.put(number,i);
            }
        }
        System.out.println(answer[0]);
        System.out.println(answer[1]);





    }
}
