import java.util.*;
import java.util.stream.Collectors;

public class Practice03102025SK {

    public static void main(String[] args) {
//        🔹 Q1: Stream API
//        You are given:
//        List<String> words = Arrays.asList("stream", "spring", "java", "boot", "api", "microservice", "springboot");
//        👉 Tasks:
//        Find all distinct words whose length > 5.
//        Count how many words contain "spring".
//        Join all words into a single string separated by , .
        List<String> words = Arrays.asList("stream", "spring", "java", "boot", "api", "microservice", "springboot");

        List<String> stringList = words.stream()
                .distinct()
                .filter(word -> word.length() > 5)
                .toList();

        System.out.println("distinct words whose length > 5"+stringList);

        long countContaingWordSpring = words.stream()
                .filter(word -> word.contains("spring"))
                .count();

        System.out.println("Count of words contain spring "+countContaingWordSpring);

        String collectedResult = words.stream()
                .collect(Collectors.joining(","));
        System.out.println("Joined all words into a single string separated by ,"+collectedResult);

//        🔹 Q2: Collections & Framework
//
//        You are given a list of student names:
//        List<String> students = Arrays.asList(
//                "Alice", "Bob", "Charlie", "Alice", "Eve", "Frank", "Bob", "David"
//        );
//        👉 Tasks:
//        Remove duplicates from the list and print the unique students (use a Set).
//        Count the frequency of each student’s name (use a Map<String, Integer>).
//        Find the student(s) who appear the most times.
//        Convert the unique students into a TreeSet and print them in sorted order.

        List<String> students = Arrays.asList(
                "Alice", "Bob", "Charlie", "Alice", "Eve", "Frank", "Bob", "David"
        );
        Set<String> stringSet = new HashSet<>(students);

        System.out.println("Unique Students:"+stringSet);


//      Count the frequency of each student’s name (use a Map<String, Integer>).
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i<students.size();i++){
            if(!map.containsKey(students.get(i))){
                map.put(students.get(i),1);

            }else{
                map.put(students.get(i),map.get(students.get(i))+1);
            }
        }

        System.out.println("frequency of each student’s name:-"+map);

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int max = entries.get(0).getValue();
        List<String> mostFrequentNames = new ArrayList<>();
        for(int i = 0 ; i<entries.size();i++){
            if(entries.get(i).getValue()==max){
                mostFrequentNames.add(entries.get(i).getKey());
            }
        }

        System.out.println("student(s) who appear the most times:-"+mostFrequentNames);

//        above approach is also right but its time complexit is O(n log n)
//        when i can do it in O(n) by just tracking the max while iterating:


//        Integer max = Collections.max(map.values());
//        List<String> mostFrequentNames = new ArrayList<>();
//        for(Map.Entry<String,Integer> entry : map.entrySet()){
//            if(entry.getValue()==max){
//                mostFrequentNames.add(entry.getKey());
//            }
//        }

//        StreamAPI alternative
//        Map<String, Long> frequency = students.stream()
//                .collect(Collectors.groupingBy(
//                        name -> name,
//                        Collectors.counting()
//                ));
//        Long max1 = Collections.max(frequency.values());
//
//        List<String> mostFrequent  = frequency.entrySet()
//                .stream()
//                .filter(entry -> entry.getValue() == max1)
//                .map(entry->entry.getKey())
//                .toList();




        Set<String> sortedNames  = new TreeSet<>(students);

        System.out.println("Sorted Students:"+sortedNames);


//        Q3)DSA
//        53. Maximum Subarray
//        Given an integer array nums, find the subarray with the largest sum, and return its sum.
//                Example 1:
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//        Example 2:
//
//        Input: nums = [1]
//        Output: 1
//        Explanation: The subarray [1] has the largest sum 1.
//        Example 3:
//
//        Input: nums = [5,4,-1,7,8]
//        Output: 23
//        Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


 //       int[] nums = {5,4,-1,7,8};
       // Output: 6

        //Bruteforce approach
//        int maximum = nums[0];  // initialize to first element, not 0
//
//        for(int i = 0 ; i<nums.length;i++){
//            int sum = 0;
//            for(int j = i ; j<nums.length;j++){
//                System.out.print(nums[j]+" ");
//                sum+=nums[j];
//                maximum = Math.max(maximum,sum);
//            }
//            System.out.println();
//        }
//
//        System.out.println("Maximum sum:-"+maximum);

        //Optimized approach
        //This is Kadane’s Algorithm, the standard optimized solution for Maximum Subarray

        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};

        int maximum = Integer.MIN_VALUE;

        int sum = 0 ;

        for(int i = 0 ; i<nums.length;i++){
            sum+=nums[i];
            maximum = Math.max(maximum,sum);

            if(sum<0){
                sum = 0;
            }
        }

        System.out.println("Maximum subarray sum:-"+maximum);






    }
}
