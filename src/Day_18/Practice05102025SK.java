package Day_18;

import java.util.*;
import java.util.stream.Collectors;

public class Practice05102025SK {

    public static void main(String[] args) {
//        Q1 — Stream API Challenge
//        You are given:
//        List<String> employees = Arrays.asList(
//                "John Doe",
//                "Jane Smith",
//                "Alice Johnson",
//                "Bob Brown",
//                "Charlie Davis",
//                "Alice Williams"
//        );
//
//        👉 Tasks:
//        Find all employees whose names start with "A".
//        Count how many employees have last names starting with "J".
//        Join all unique employee names into a single comma-separated string.
//        Sort employee names by length (ascending) and print them.
//
//        ✅ Expected Output Format:
//        Employees starting with A: [Alice Johnson, Alice Williams]
//        Last names starting with J: 2
//        Unique Employee Names Joined: John Doe, Jane Smith, Alice Johnson, Bob Brown, Charlie Davis, Alice Williams
//        Sorted by Length: [Bob Brown, John Doe, Jane Smith, Alice Johnson, Alice Williams, Charlie Davis]

        List<String> employees = Arrays.asList(
                "John Doe",
                "Jane Smith",
                "Alice Johnson",
                "Bob Brown",
                "Charlie Davis",
                "Alice Williams");
//    Find all employees whose names start with "A".
        List<String> stringList = employees.stream()
                .filter(name -> name.startsWith("A"))
                .toList();

        System.out.println("Employees starting with A:-"+stringList);

        //Count how many employees have last names starting with "J".
        long count = employees.stream()
                .map(name -> name.split(" ")[1])
                .filter(lastName -> lastName.startsWith("j"))
                .count();

        System.out.println("Last name starting with J:-"+count);

//Join all unique employee names into a single comma-separated string.

        String collect = employees.stream()
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Unique Employee Names Joined:-"+collect);

//Sort employee names by length (ascending) and print them.
        List<String> sortedByLength = employees.stream()
                .sorted(Comparator.comparing(name -> name.length()))
                .toList();
        System.out.println("Sorted by Length:-"+sortedByLength);

//        ️ Q2: Collections & Framework
//        Create a Map of countries and their populations,then:
//        1)Print the country with the highest population.
//        2)Print the average population.
//        3)Print all countries whose population is below average.
//        Example Input:
//        Map<String, Integer> countryPopulation = Map.of(
//                "India", 140,
//                "USA", 33,
//                "China", 141,
//                "Brazil", 21,
//                "Japan", 12
//        );
//        Expected Output:
//        Highest population: China (141)
//        Average population: 69.4
//        Below average countries: [USA, Brazil, Japan]
        Map<String,Integer> countryPopulation = Map.of(
                "India",140,
                "USA",33,
                "China",141,
                "Brazil",21,
                "Japan",12
        );

//      Print the country with the highest population:-

        Integer max = Collections.max(countryPopulation.values());

        for(Map.Entry<String,Integer> country: countryPopulation.entrySet()){
            if(Objects.equals(country.getValue(),max)){
                System.out.println("Highest population: "+country.getKey()+" "+"("+country.getValue()+")");
            }
        }
//         2)Print the average population.
        int sum = 0 ;

        for(Map.Entry<String,Integer> country: countryPopulation.entrySet()){
            sum+=country.getValue();
        }

        float average = (float) sum /countryPopulation.size();

        System.out.println("Average population:-"+average);

        // 3)Print all countries whose population is below average.

        List<String> belowAverageCountries = new ArrayList<>();
        for(Map.Entry<String,Integer> country: countryPopulation.entrySet()){
            if(country.getValue()<average){
                belowAverageCountries.add(country.getKey());
            }
        }
        System.out.println("Below average countries:-"+belowAverageCountries);


//        Q3) DSA
//        153. Find Minimum in Rotated Sorted Array
//        Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
//        For example, the array nums = [0,1,2,4,5,6,7] might become:[4,5,6,7,0,1,2] if it was rotated 4 times.
//        [0,1,2,4,5,6,7] if it was rotated 7 times.
//        Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//        Given the sorted rotated array nums of unique elements, return the minimum element of this array.
//        You must write an algorithm that runs in O(log n) time.
//        Example 1:
//        Input: nums = [3,4,5,1,2]
//        Output: 1
//        Explanation: The original array was [1,2,3,4,5] rotated 3 times.

//        Example 2:
//        Input: nums = [4,5,6,7,0,1,2]
//        Output: 0
//        Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

//        Example 3:
//        Input: nums = [11,13,15,17]
//        Output: 11
//        Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
//
//        Constraints:
//        n == nums.length
//        1 <= n <= 5000
//        -5000 <= nums[i] <= 5000
//        All the integers of nums are unique.
//        nums is sorted and rotated between 1 and n times.


        int[] nums = {11,13,15,17};

        //Bruteforce approach
//        int minimum = Integer.MAX_VALUE;
//
//        for(int i = 0 ; i<nums.length;i++){
//            minimum = Math.min(minimum,nums[i]);
//        }
//
//        System.out.println("Minimum:-"+minimum);

//       Strivers Approach:-

        int low = 0 ;
        int high = nums.length-1;
        int minimumValue = Integer.MAX_VALUE;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[low]<=nums[mid]){
                minimumValue = Math.min(minimumValue,nums[low]);
                low = mid+1;

            }else{
                minimumValue = Math.min(minimumValue,nums[mid]);
                high = mid -1;
            }
        }

        System.out.println("Minimum value:-"+minimumValue);




    }
}
