package Day_19;

import java.util.*;
import java.util.stream.Collectors;

public class Practice06102025SK {
    public static void main(String[] args) {
//        Q1 — Stream API Challenge:
//
//        You are given the following list of books:
//        List<String> books = Arrays.asList(
//                "The Great Gatsby",
//                "1984",
//                "To Kill a Mockingbird",
//                "The Catcher in the Rye",
//                "Moby Dick",
//                "War and Peace",
//                "Pride and Prejudice"
//        );


//        Tasks:
//        1)Find all books whose titles start with the letter "T".
//        2)Count how many books have titles longer than 15 characters.
//        3)Join all book titles into a single string separated by semicolons.
//        4)Sort the books alphabetically by title and print them.
//
//        Expected Output Format:
//        Books starting with T: [The Great Gatsby, The Catcher in the Rye]
//        Books with titles longer than 15 characters: 3
//        All Books Joined: The Great Gatsby; 1984; To Kill a Mockingbird; The Catcher in the Rye; Moby Dick; War and Peace; Pride and Prejudice
//        Sorted Alphabetically: [1984, Moby Dick, Pride and Prejudice, The Catcher in the Rye, The Great Gatsby, To Kill a Mockingbird, War and Peace]

        List<String> books = Arrays.asList(
                "The Great Gatsby",
                "1984",
                "To Kill a Mockingbird",
                "The Catcher in the Rye",
                "Moby Dick",
                "War and Peace",
                "Pride and Prejudice"
        );

        // 1) Books starting with 'T'
        List<String> booksStartingWithT = books.stream()
                .filter(book -> book.startsWith("T"))
                .collect(Collectors.toList());

        // 2) Count of books with title length > 15
        long longTitleCount = books.stream()
                .filter(book -> book.length() > 15)
                .count();

        // 3) Join book titles with semicolon
        String joinedTitles = books.stream()
                .collect(Collectors.joining("; "));

        // 4) Sort alphabetically
        List<String> sortedBooks = books.stream()
                .sorted()
                .collect(Collectors.toList());

        // Output
        System.out.println("Books starting with T: " + booksStartingWithT);
        System.out.println("Books with titles longer than 15 characters: " + longTitleCount);
        System.out.println("All Books Joined: " + joinedTitles);
        System.out.println("Sorted Alphabetically: " + sortedBooks);


//     Q2 — Collections & Framework: Advanced Challenge
//     You are given a list of students along with their scores across different subjects:
//     Tasks:
//     Find the student with the highest average score.
//     Print all students whose average score is below 85.
//     Create a new map of students and their average scores (rounded to 2 decimal places).

//        ✅ Expected Output Format:
//        Top Student: Charlie (Average: 91.67)
//        Students below average threshold: [Alice, Bob, Diana, Ethan]
//        Student Averages: {Alice=84.33, Bob=83.33, Charlie=91.67, Diana=65.00, Ethan=87.33}

        Map<String,List<Integer>> studentScores = Map.of(
                "Alice",List.of(85, 90, 78),
                "Bob",List.of(70, 88, 92),
                "Charlie",List.of(95, 91, 89),
                "Diana",List.of(60, 65, 70),
                "Ethan",List.of(88, 84, 90)
        );

        // Map to store student and average score (rounded to 2 decimal places)
        Map<String,Double> studentAverages = new HashMap<>();


        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            double average = entry.getValue().stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0.0);
            double roundedAverage = Math.round(average * 100.0) / 100.0;
            studentAverages.put(entry.getKey(), roundedAverage);
        }

        // Find top student
        double maxAverage = Collections.max(studentAverages.values());
        String topStudent = studentAverages.entrySet().stream()
                .filter(entry -> entry.getValue() == maxAverage)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("No top student");

        // Find students below 85
        List<String> belowThresholdStudents = studentAverages.entrySet().stream()
                .filter(entry -> entry.getValue() < 85)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Output
        System.out.printf("Top Student: %s (Average: %.2f)%n", topStudent, maxAverage);
        System.out.println("Students below average threshold: " + belowThresholdStudents);
        System.out.println("Student Averages: " + studentAverages);


//        Q3) DSA

//        33. Search in Rotated Sorted Array
//        There is an integer array nums sorted in ascending order (with distinct values).
//
//        Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length)
//        such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//        For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
//
//        Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1
//        if it is not in nums.

//        You must write an algorithm with O(log n) runtime complexity.
//
//        Example 1:
//        Input: nums = [4,5,6,7,0,1,2], target = 0
//        Output: 4
//        Example 2:
//
//        Input: nums = [4,5,6,7,0,1,2], target = 3
//        Output: -1
//        Example 3:
//
//        Input: nums = [1], target = 0
//        Output: -1

//        int[] nums = {4,5,6,7,0,1,2};
//        int target = 0;
//
//        int low = 0 ;
//        int high = nums.length-1;
//        int index=-1;

        //Bruteforce approach

//        for(int  i = 0 ; i<nums.length;i++){
//            if(nums[i]==target){
//                index = i;
//            }
//
//        }
//
//        System.out.println("Index:-"+index);

//        Optimized approach

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int low = 0 ;
        int high = nums.length-1;
        int index=-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                index = mid;
                break;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            else{
                if(nums[mid]<=target && target<=nums[high]){
                    low = mid+1;

                }else{
                    high = mid -1;
                }
            }
        }

        System.out.println("Index:-"+index);



    }
}
