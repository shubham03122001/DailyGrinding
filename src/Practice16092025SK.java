import java.util.*;
import java.util.stream.Collectors;

public class Practice16092025SK {
    public static void main(String[] args) {
//        🔹 1. Stream API Question
//
//        Given a list of strings, find the longest string using Java Stream API.
//
//        Input:
//        List<String> words = Arrays.asList("spring", "boot", "java", "microservices", "api");
//        Expected Output:
//        microservices

//        List<String> words = Arrays.asList("spring", "boot", "java", "microservices", "api","123");
//
//
//        String s = words.stream()
//                .max(Comparator.comparing(String::length))
//                .orElse(null);
//
//        System.out.println(s);

//
//        But if the input were:
      //  List<String> words1 = Arrays.asList("boot", "java", "apis");
//        Now all three have length 4.
//        ⚡ If Requirement is Different
//
//        Return all longest words → Collect into a list:

//        int maxLength = words1.stream()
//                .mapToInt(String::length)
//                .max()
//                .orElse(0);



        //It returns the maximum length of words if there are many

//                List<String> result = words1.stream()
//                .filter(word -> word.length() == maxLength)
//                .collect(Collectors.toList());
//        System.out.println(result);
//
//        🔹 Problem with Normal map()
//
//        A Stream<Integer> is a stream of wrapper objects (Integer), not primitives.
//
//                If you want to do operations like sum(), max(), average(), Java will need to unbox each Integer to int, which adds overhead.
//
//🔹 mapToInt()
//
//        mapToInt() converts a Stream<T> into an IntStream (specialized stream for primitive int).
//
//        Removes boxing/unboxing overhead.
//
//        Provides methods like sum(), average(), max(), min() directly.

       // map() → generic mapping → produces Stream<T> (objects).
//
//                mapToInt() → specialized mapping → produces IntStream (primitives).
//
//                Use mapToInt() when you’re dealing with numbers and want numeric operations like sum(), average(), max().



//        Q2)Collections & Framework
//
//You are given a list of Employee objects (id, name, department).
//👉 Write a method to group employees by department using a HashMap.
//
//Example Input:
//            [
//        (1, "Alice", "IT"),
//        (2, "Bob", "HR"),
//        (3, "Charlie", "IT"),
//        (4, "David", "Finance"),
//        (5, "Eve", "HR")
//]

//Employee emp1 = new Employee("Alice","IT");
//Employee emp2 = new Employee("Bob","HR");
//Employee emp3 = new Employee("Charlie","IT");
//Employee emp4 = new Employee("David","Finance");
//Employee emp5 = new Employee("Eve","HR");
//
////        Map<String,List<String>> map =new HashMap<>();
//
//        Employee[] employeeArray = {emp1,emp2,emp3,emp4,emp5};

//        for(int i = 0 ; i<employeeArray.length;i++){
//            map.put(employeeArray[i].getDepartment(),map.getOrDefault(employeeArray[i].getDepartment(),employeeArray[i].getName()));
//        }
//        System.out.println("Map:-"+map);

//
//        for(int i = 0 ; i<employeeArray.length;i++){
//            map.computeIfAbsent(employeeArray[i].getDepartment(),k->new ArrayList<>()).add(employeeArray[i].getName());
//        }
//        🔹 What Happens
//
//        For each employee:
//
//        map.computeIfAbsent(dept, k -> new ArrayList<>())
//
//        If department doesn’t exist yet, create a new empty ArrayList.
//
//                If it already exists, return the existing list.
//
//.add(name) then adds the employee’s name to the correct department.
//
//        System.out.println("New map"+map);
//
//        Set<String> keys = map.keySet();
//
//        for(String key : keys ){
//            System.out.println(key+"-->"+map.get(key));
//        }

//        🔹 Problem Statement: Anagram Check
//
//        Write a function to check if two strings are anagrams of each other.
//
//                An anagram means both strings contain the same characters with the same frequency, but possibly in a different order.
//
//                Ignore case and spaces.
//        ✅ Example 1:
//        Input: "listen", "silent"
//        Output: true
//
//✅ Example 2:
//        Input: "triangle", "integral"
//        Output: true
//
//✅ Example 3:
//        Input: "hello", "world"
//        Output: false

        String s1 ="listen";
        String s2="silent";
        s1=s1.replaceAll("\\s","");
        s2=s2.replaceAll("\\s","");
//        🔹 Difference between " " and "\\s"
//
//        " " (single space)
//
//        Matches only the space character (ASCII 32).
//
//                Example: "a b".replaceAll(" ", "") → "ab".
//
//                But it won’t remove tabs (\t), newlines (\n), or other whitespace characters.
//
//                "\\s" (regex for whitespace)
//
//        Matches all kinds of whitespace (space, tab, newline, carriage return, etc.).
//
//        Example:
//        "a\tb\nc".replaceAll("\\s", "") → "abc"


        StringBuilder sb1 = new StringBuilder(s1.toLowerCase());
        StringBuilder sb2 = new StringBuilder(s2.toLowerCase());

        int[] arr1 = new int[128];
        int[] arr2 = new int[128];

        for(int i = 0 ; i <sb1.length();i++){
            arr1[sb1.charAt(i)]++;
        }

        for(int i = 0 ; i <sb2.length();i++){
            arr2[sb2.charAt(i)]++;
        }

        boolean isAnagram = true;

        for(int i = 0 ; i<128;i++){
            if(arr1[i]!=arr2[i]){
                isAnagram=false;
            }
        }

        System.out.println("Anagram:-"+isAnagram);

//        🔹 Optimized Approach (Single Array)
//
//        Idea:
//
//        Traverse both strings at the same time.
//
//                For each character in s1, increment its count.
//
//        For each character in s2, decrement its count.
//
//        At the end, if all values are zero → strings are anagrams.

//        String s1 ="listen";
//        String s2="silent";
//
//        s1 = s1.replaceAll("\\s", "").toLowerCase();
//        s2 = s2.replaceAll("\\s", "").toLowerCase();
//
//        if (s1.length() != s2.length()) {
//            System.out.println("Anagram: false");
//        } else {
//            int[] freq = new int[128]; // assuming ASCII
//
//            for (int i = 0; i < s1.length(); i++) {
//                freq[s1.charAt(i)]++;
//                freq[s2.charAt(i)]--;
//            }
//
//            boolean isAnagram = true;
//            for (int count : freq) {
//                if (count != 0) {
//                    isAnagram = false;
//                    break;
//                }
//            }
//
//            System.out.println("Anagram: " + isAnagram);
//        }



    }
}
