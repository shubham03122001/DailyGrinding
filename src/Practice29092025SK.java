import java.util.*;

public class Practice29092025SK {

    public static void main(String[] args) {
//        🔹 Q1. Stream API
//        You are given a list of integers:
//        List<Integer> numbers = Arrays.asList(10, 25, 33, 47, 50, 62, 70, 85, 90);
//        👉 Using Stream API, do the following:
//        Find all even numbers and collect into a list.
//        Find the sum of all numbers greater than 50.
//        Find the second largest number.
//        Output Format:
//        Even Numbers: [10, 50, 62, 70, 90]
//        Sum > 50: 307
//        Second Largest: 85
        List<Integer> numbers = Arrays.asList(10, 25, 33, 47, 50, 62, 70, 85, 90);

        List<Integer> evenNumber = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        System.out.println("Even Numbers: "+evenNumber);

        Integer sum = numbers.stream()
                .filter(number -> number > 50)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum of numbers greater than 50->"+sum);


        Integer secondLargest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println("Second largest:-"+secondLargest);



//        🔹 Q2. Collections & Framework
//        You are given a list of students with their marks:
//        Map<String, Integer> marks = new HashMap<>();
//        marks.put("Alice", 88);
//        marks.put("Bob", 95);
//        marks.put("Charlie", 67);
//        marks.put("David", 95);
//        marks.put("Eve", 76);
//        👉 Do the following:
//        Find the top scorer(s) (students with max marks).
//        Find the average marks of all students.
//        Print students sorted by marks (descending).
//        ✅ Output Format:
//        Top Scorers: [Bob, David]
//        Average Marks: 84.2
//        Sorted by Marks:
//        Bob -> 95
//        David -> 95
//        Alice -> 88
//        Eve -> 76
//        Charlie -> 67


        Map<String, Integer> marks = new HashMap<>();
        marks.put("Alice", 88);
        marks.put("Bob", 95);
        marks.put("Charlie", 67);
        marks.put("David", 95);
        marks.put("Eve", 76);

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(marks.entrySet());

        Set<String> topScorerNames = new HashSet<>();

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for(int i = 1 ; i<entries.size();i++){
            if(Objects.equals(entries.get(i - 1).getValue(), entries.get(i).getValue())){
                topScorerNames.add(entries.get(i).getKey());
                topScorerNames.add(entries.get(i-1).getKey());
            }
        }

        for(String name : topScorerNames){
            System.out.println("Top scores:-"+name);
        }

        int size = marks.size();
        Double sumOfMarks = 0.0;

        Set<String> keys = marks.keySet();

        for(String key : keys){
            sumOfMarks+=marks.get(key);
        }

        System.out.println("Average:-"+sumOfMarks/size);

        System.out.println("Sorted by marks:");
        for(int i = 0 ; i<entries.size();i++){
            System.out.println(entries.get(i).getKey()+"->"+entries.get(i).getValue());

        }

//        Q3 DSA
//        217. Contains Duplicate
//        Given an integer array nums, return true if any value appears at least twice in the array,
//        and return false if every element is distinct.
//        Example 1:
//        Input: nums = [1,2,3,1]
//        Output: true
//        Explanation:
//        The element 1 occurs at the indices 0 and 3.
//
//        Example 2:
//        Input: nums = [1,2,3,4]
//        Output: false
//        Explanation:
//        All elements are distinct.
//
//        Example 3:
//        Input: nums = [1,1,1,3,3,4,3,2,4,2]
//        Output: true



        int[] nums = {1,2,3,1};
        Map<Integer,Integer> map = new HashMap<>();
        boolean isContainsDuplicate = true;
        int count=0;

        for(int i = 0 ; i<nums.length;i++){
            int key = nums[i];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
               System.out.println("Conatains duplicate:-"+isContainsDuplicate);
                count++;
                break;
            }else{
                map.put(key,1);
            }

        }

        if(count==0){
            isContainsDuplicate=false;
            System.out.println("Contains duplicate :-"+isContainsDuplicate);
        }








    }
}
