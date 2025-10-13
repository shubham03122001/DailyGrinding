package Day_20;

import java.util.*;
import java.util.stream.Collectors;

public class Practice13102025SK {
    public static void main(String[] args) {

//🔹 Q1 — Stream API
//    You are given:
//    List<String> cities = Arrays.asList(
//            "Pune", "Paris", "London", "Prague", "Los Angeles", "Lisbon", "Lima", "Lucknow"
//    );
//    👉 Tasks:
//
//    1)Find all cities that start with the letter “L”.
//
//    2)Count how many cities contain the substring “on”.
//
//    3)Convert all city names to uppercase and sort them alphabetically.
//
//    4)Join all distinct city names into a single comma-separated string.
//
//   ✅ Expected Output Format:
//    Cities starting with L: [London, Los Angeles, Lisbon, Lima, Lucknow]
//    Count of cities containing 'on': 1
//    Uppercase & Sorted: [LIMA, LISBON, LONDON, LOS ANGELES, LUCKNOW, PARIS, PRAGUE, PUNE]
//    Joined Cities: PUNE, PARIS, LONDON, PRAGUE, LOS ANGELES, LISBON, LIMA, LUCKNOW


//        1)Find all cities that start with the letter “L”.
        List<String> cities  = Arrays.asList("Pune", "Paris", "London", "Prague", "Los Angeles", "Lisbon", "Lima", "Lucknow");

        List<String> citiesStartingWithL = cities.stream()
                .filter(city -> city.startsWith("L"))
                .collect(Collectors.toList());

        System.out.println("Cities starting with L:"+citiesStartingWithL);

//      2)Count how many cities contain the substring “on”.
        long countOfOnInCities = cities.stream()
                .filter(city -> city.contains("on"))
                .count();
        System.out.println("Count of  cities contain the substring “on” "+countOfOnInCities);


//     3)  Convert all city names to uppercase and sort them alphabetically.
        List<String> collect = cities.stream()
                .map(city -> city.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Uppercase & Sorted:"+collect);

//     4) Join all distinct city names into a single comma-separated string.

        String joinedCities = cities.stream()
                .distinct()
                .collect(Collectors.joining(", "));

        System.out.println("Joined Cities:"+joinedCities);

//        🔹 Q2 — Collections & Framework
//        You are given:
//        Map<String, Integer> scores = new HashMap<>();
//        scores.put("Alice", 85);
//        scores.put("Bob", 92);
//        scores.put("Charlie", 78);
//        scores.put("David", 92);
//        scores.put("Eve", 68);

//        👉 Tasks:
//        1)Find the student(s) with the highest score.
//        2)Sort the map by scores in descending order.
//        3)Increase everyone’s score by 5 points and print the updated map.
//        4)Store all unique scores in a TreeSet and print them.
        Map<String,Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 78);
        scores.put("David", 92);
        scores.put("Eve", 68);

        Integer max = Collections.max(scores.values());
        List<String> studentNamesWithHighestSore = new ArrayList<>(); // In this arraylist we will store student name(s) having highest score

        for(Map.Entry<String,Integer> score : scores.entrySet()){
            if(Objects.equals(score.getValue(),max)){
//                System.out.println("Student with highest score:-"+score.getKey());
                studentNamesWithHighestSore.add(score.getKey());
            }
        }

        System.out.println("Top scorers:-"+studentNamesWithHighestSore);


//      2)Sort the map by scores in descending order.
//      Approach 1:-
//        LinkedHashMap<String, Integer> sortedByScoreDescending  = scores.entrySet()
//                .stream()
//                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Descending order
//                .collect(Collectors.toMap(
//                        entry -> entry.getKey(),
//                        entry -> entry.getValue(),
//                        (e1, e2) -> e1,  //merge function if duplicate keys appear (not in this case)
//                        LinkedHashMap::new
//                ));
//
//        System.out.println("Sorted by score descending order:-"+sortedByScoreDescending);

//       2nd approach
        List<Map.Entry<String,Integer>> entries = new ArrayList<>(scores.entrySet());

        Collections.sort(entries,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> e1 , Map.Entry<String,Integer>e2){
               return e2.getValue()-e1.getValue(); // Descending

            }
        });
        LinkedHashMap<String , Integer> sortedMap = new LinkedHashMap<>();

        for(Map.Entry<String,Integer>entry:entries){
            sortedMap.put(entry.getKey(),entry.getValue());
        }

        System.out.println("Sorted by score (desc): " + sortedMap);

//      3)Increase everyone’s score by 5 points and print the updated map.

//      Never update the value of a key while iterating using for each loop.

//      Safe & recommended alternatives :-

//      use replaceAll()
//      scores.replaceAll((key,value)->value+5);
//         Directly updates values without breaking iteration.
//         No risk of ConcurrentModificationException.
//         Clean and efficient.


//      Approach 2:- User Iterator Explicitely
        Iterator<Map.Entry<String, Integer>> iterator = scores.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            entry.setValue(entry.getValue()+5);
        }

//      4)Store all unique scores in a TreeSet and print them.
        Set<Integer> uniqueScores = new TreeSet<>(scores.values());
        System.out.println("Unique scores:-"+uniqueScores);



//🔹 Q3 — DSA
//        15. 3Sum

//        Hint
//        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//        Notice that the solution set must not contain duplicate triplets.

//        Example 1:
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Explanation:
//        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//        The distinct triplets are [-1,0,1] and [-1,-1,2].
//        Notice that the order of the output and the order of the triplets does not matter.

//        Example 2:
//        Input: nums = [0,1,1]
//        Output: []
//        Explanation: The only possible triplet does not sum up to 0.

//        Example 3:
//        Input: nums = [0,0,0]
//        Output: [[0,0,0]]
//        Explanation: The only possible triplet sums up to 0.

//        Constraints:
//        3 <= nums.length <= 3000
//        -105 <= nums[i] <= 105


        //Bruteforce approach
//        Set<List<Integer>> listSet = new HashSet<>();
//
//        int[] nums = {-1,0,1,2,-1,-4};
//        for(int i = 0 ; i<nums.length-2;i++){
//            for(int j = i+1 ; j<nums.length-1;j++){
//                for(int k = j+1 ; k<nums.length;k++){
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        listSet.add(List.of(nums[i],nums[j],nums[k]).stream().sorted().toList());
//                    }
//                }
//            }
//        }
//
//        System.out.println("Triplet:-"+listSet);


        //Better approach
        int[] nums = {-1,0,1,2,-1,-4};

    Set<List<Integer>> finalAsnwer = new HashSet<>();

        for(int i = 0 ; i<nums.length-1;i++){
            Set<Integer> seen = new HashSet<>();
            for(int j = i+1 ; j<nums.length;j++){
                int number = -(nums[i]+nums[j]);
                if(seen.contains(number)){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], number);
                    Collections.sort(triplet); // Sort to avoid duplicates
                    finalAsnwer.add(triplet);
                }
                seen.add(nums[j]);

            }
        }

        System.out.println("Triplet:-"+finalAsnwer);



    }

}
