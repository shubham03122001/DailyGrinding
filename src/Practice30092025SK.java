import java.util.*;
import java.util.stream.Collectors;

public class Practice30092025SK {

    public static void main(String[] args) {
//        Q1. Stream API
//        You are given a list of strings representing products sold:
//        List<String> products = Arrays.asList("Apple", "Banana", "Mango", "Apple", "Banana", "Orange", "Mango", "Mango");
//
//        Tasks using Stream API:
//        Count the frequency of each product.
//        Find the most sold product.
//        Get a list of distinct products sorted alphabetically.
//        ✅ Output Format:
//        Product Frequencies: {Apple=2, Banana=2, Mango=3, Orange=1}
//        Most Sold Product: Mango
//        Distinct Products Sorted: [Apple, Banana, Mango, Orange]
        List<String> products = Arrays.asList("Apple", "Banana", "Mango", "Apple", "Banana", "Orange", "Mango", "Mango");

        Map<String, Long> frequencies = products.stream()
                .collect(Collectors.groupingBy(
                        fruit -> fruit,
                        Collectors.counting()
                ));

        System.out.println("Product frequency:-"+frequencies);

        //Since i already have frequencies map  , i just need to find the entry with the maximum value

        Map.Entry<String, Long> mostSold = Collections.max(
                frequencies.entrySet(),
                Map.Entry.comparingByValue()
        );

        System.out.println("Most sold product:-"+mostSold.getKey());


//        Alternative using Streams
//        String mostSoldProduct = frequencies.entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse("No products");
//        System.out.println("Most sold product:-"+mostSoldProduct);

        List<String> distinctSoretd = frequencies.keySet()
                .stream()
                .sorted()
                .toList();

        System.out.println("Distinct Products Sorted:"+distinctSoretd);
//
//        Q2 ( Collections & Framework)
//        You are given the following lists of student names:
//        List<String> classA = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));
//        List<String> classB = new LinkedList<>(Arrays.asList("Eve", "Frank", "Alice", "George", "Charlie"));
//        Tasks:
//        Combine classA and classB into one list and remove duplicates.
//        Sort the combined list alphabetically.
//        Convert the combined list into a TreeSet (to maintain sorted order automatically) and print.
//        Remove the first and last student from the TreeSet and print the remaining.
//        ✅ Output Format Example:
//        Combined List without duplicates: [Alice, Bob, Charlie, David, Eve, Frank, George]
//        Sorted List: [Alice, Bob, Charlie, David, Eve, Frank, George]
//        TreeSet: [Alice, Bob, Charlie, David, Eve, Frank, George]
//        After removing first and last: [Bob, Charlie, David, Eve, Frank]

        List<String> classA = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));
        List<String> classB = new ArrayList<>(Arrays.asList("Eve", "Frank", "Alice", "George", "Charlie"));

//        Step 1: Combine classA and classB into one list and remove duplicates
//        Combine lists using addAll():
        ArrayList<String> combined = new ArrayList<>(classA);
        combined.addAll(classB); //combined now has all students from both classes
        //Remove the duplicates
        LinkedHashSet<String> uniqueStudents = new LinkedHashSet<>(combined);

        System.out.println("Combined list without duplicates:-"+uniqueStudents);
        //LinkedHashSet automatically keeps the first occurence and remove repeated entries


        //Step2 :- Sort the combined list alphabetically 
        ArrayList<String> sortedList = new ArrayList<>(uniqueStudents);
        Collections.sort(sortedList); // sorts alphabetically
        System.out.println("Sorted List:-"+sortedList);

        //Step 3 :- Convert the combined list into Treeset
        //Treeset automatically removes the duplicate and keeps the element sorted
        TreeSet<String> treeSet = new TreeSet<>(combined);

        System.out.println("TreeSet:-"+treeSet);

        //Step 4 :- remove the first and last student from TreeSet
        treeSet.pollFirst();
        treeSet.pollLast();

        System.out.println("Set after removing first and last element:-"+treeSet);

        //Here’s a concise one-liner Streams solution that does everything:-
//        List<String> classA = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));
//        List<String> classB = new LinkedList<>(Arrays.asList("Eve", "Frank", "Alice", "George", "Charlie"));
//        // Combine, remove duplicates, sort, and collect into TreeSet in one line
//        TreeSet<String> treeSet = Stream.concat(classA.stream(), classB.stream())
//                .collect(Collectors.toCollection(TreeSet::new));
//
//        System.out.println("TreeSet: " + treeSet);
//
//        // Remove first and last
//        treeSet.pollFirst();
//        treeSet.pollLast();
//        System.out.println("After removing first and last: " + treeSet);



//        Explanation :-
//        Stream.concat(classA.stream(), classB.stream())
//        Merges two streams into one stream of all students.
//        .collect(Collectors.toCollection(TreeSet::new))
//        Collects elements into a TreeSet, which automatically:
//        Removes duplicates
//        Sorts elements alphabetically
//        treeSet.pollFirst() / pollLast()
//        Removes the first (smallest) and last (largest) elements from the TreeSet.



//        238. Product of Array Except Self
//        Given an integer array nums, return an array answer such that answer[i] is equal
//        to the product of all the elements of nums except nums[i].
//        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//        You must write an algorithm that runs in O(n) time and without using the division operation.

//        Example 1:
//        Input: nums = [1,2,3,4]
//        Output: [24,12,8,6]
//        Example 2:
//        Input: nums = [-1,1,0,-3,3]
//        Output: [0,0,9,0,0]

        int[] nums  = {1,2,3,4};
     //   int[] result = new int[nums.length];
//       Bruteforce Approach
//        for(int i = 0 ; i<nums.length;i++){
//            int multiplication = 1;
//            for(int j = 0 ; j<nums.length;j++){
//                if(i!=j){
//                    multiplication = multiplication*nums[j];
//                }
//
//            }
//            result[i]=multiplication;
//        }
//
//        for(int number : result){
//            System.out.print(number+" ");
//        }
//        System.out.println();

        int lengthOfNums = nums.length;

        int[] answer = new int[lengthOfNums];
        //prefix
        answer[0]=1;
        for(int i = 1 ; i<lengthOfNums;i++){
            answer[i]= answer[i-1]*nums[i-1];
        }

        //suffix
        int suffix=1;
        for(int i = lengthOfNums-2 ;i>=0;i-- ){
            suffix*=nums[i+1];
            answer[i]*=suffix;



        }
        for(int number : answer){
            System.out.print(number+" ");
        }
        System.out.println();




    }
}
