import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice24092025SK {
    public static void main(String[] args) {
//   Q1 (Stream API)
//   Problem:Given a list of integers, return a list containing the squares of even numbers only,
//   sorted in ascending order.
//   Input: [3, 2, 7, 8, 5, 6]
//   Expected Output: [4, 36, 64]


        List<Integer> list = Arrays.asList(3, 2, 7, 8, 5, 6);

        List<Integer> result = list.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .sorted()
                .toList();

        System.out.println("Answer :-"+result);

//     Problem:
//     You are given a List<String> containing employee email addresses.Remove duplicates.
//     Group employees by their company domain (the part after @).
//     Print the grouped result.
//     Input:["alice@gmail.com", "bob@yahoo.com", "charlie@gmail.com", "david@outlook.com", "eve@yahoo.com"]
//     Expected Output:
//     gmail.com -> [alice@gmail.com, charlie@gmail.com]
//     yahoo.com -> [bob@yahoo.com, eve@yahoo.com]
//     outlook.com -> [david@outlook.com]

        List<String> list1 = Arrays.asList("alice@gmail.com", "bob@yahoo.com", "charlie@gmail.com", "david@outlook.com", "eve@yahoo.com");

        Map<String, List<String>> grouped = list1.stream()
                .distinct()
                .collect(Collectors.groupingBy(word -> word.substring(word.indexOf('@') + 1)));



        grouped.forEach((domain,emails)-> System.out.println(domain+"-->"+emails));

//        Q3 (DSA)
//        Problem:
//        Given an array of integers, find the length of the longest subarray with sum equal to k.
//        Input:arr = [10, 5, 2, 7, 1, 9], k = 15
//        Expected Output:4


        int[] array = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int maxLength = 0 ;


        for(int i = 0 ; i<array.length-1;i++){
            int sum = 0 ;
            for(int j = i ; j<array.length;j++){
                sum+=array[j];
                if(sum==k){
                   int  length = j-i+1;
                   maxLength = Math.max(maxLength,length);
                }

            }
        }


        System.out.println("Length:-"+maxLength);




    }
}
