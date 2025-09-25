import java.util.*;

public class Practice25092025SK {
    public static void main(String[] args) {
//        Q1 (Stream API)
//        Problem:
//        You are given a list of sentences. Find the unique words across all sentences,
//        convert them to lowercase, and sort them alphabetically.
//        Input:["Java is great", "Java Streams are powerful", "I love Java"]
//        Expected Output: [are, great, i, is, java, love, powerful, streams]

        List<String> list = Arrays.asList("Java is great", "Java Streams are powerful", "I love Java");
        List<String> result = list.stream()
                .flatMap(sentence->Arrays.stream(sentence.split(" ")))
                .map(word -> word.toLowerCase())
                .distinct()
                .sorted()
                .toList();

        System.out.println("Result:-"+result);

 //       Q2 (Collections & Framework)
//        You are given a list of student names.
//        You need to group them by their first letter using a HashMap.
//        📥 Input:["Alice", "Bob", "Charlie", "David", "Amanda", "Brian"]
//        📤 Expected Output:
//        A → [Alice, Amanda]
//        B → [Bob, Brian]
//        C → [Charlie]
//        D → [David]


        String[] students  = {"Alice", "Bob", "Charlie", "David", "Amanda", "Brian"};
        Map<Character,List<String>> grouped  = new HashMap<>();


        for(String student : students){
            char firstCharacter = student.charAt(0);

            grouped.computeIfAbsent(firstCharacter,k->new ArrayList<>()).add(student);
        }

        System.out.println("Grouped student by first character:-"+grouped);




//        Problem (Q3 – DSA):
//        Problem: Given an array of integers, find the length of the longest increasing contiguous subarray.
//        Input: nums = [1, 3, 5, 4, 7]
//        Expected Output: 3
//        Explanation: [1, 3, 5] is the longest increasing contiguous subarray.
//        Input: nums = [2, 2, 2, 2, 2]
//        Expected Output: 1

        int[] nums = {1, 3, 5,7, 4, 7};

        int maxLength = 1;
        int currentLength = 1;

        for(int i =1 ; i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                currentLength++;
                maxLength = Math.max(maxLength,currentLength);
            }else{
                currentLength=1;
            }
        }

        System.out.println("Length of longest increasing contiguous subarray: " + maxLength);


    }
}
