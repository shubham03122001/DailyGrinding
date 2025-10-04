import java.util.*;

public class Practice04102025SK {

    public static void main(String[] args) {
//        🔹 Q1 – Stream API Challenge
//        You are given a list of transactions:
//        List<Integer> transactions = Arrays.asList(1200, 5500, 3400, 1200, 8000, 5500, 2000, 9500, 1200);
//       👉 Tasks:
//        Remove duplicate transaction amounts.
//        Find the average of all transactions greater than 3000.
//        Find the 3 highest unique transactions.
//        Print all transaction amounts sorted in descending order.
//        ✅ Expected Output Format:
//        Unique Transactions: [1200, 5500, 3400, 8000, 2000, 9500]
//        Average (>3000): 6680.0
//        Top 3 Transactions: [9500, 8000, 5500]
//        Sorted (Descending): [9500, 8000, 5500, 3400, 2000, 1200]

        List<Integer> transactions = Arrays.asList(1200, 5500, 3400, 1200, 8000, 5500, 2000, 9500, 1200);

        List<Integer> list = transactions.stream()
                .distinct()
                .toList();
        System.out.println("Unique Transactions:"+list);

        double average = transactions.stream()
                .filter(transaction -> transaction > 3000)
                .mapToInt(transaction -> transaction.intValue())
                .average()
                .orElse(0.0);

        System.out.println("Average (>3000):"+average);

        List<Integer> top3Transactions = transactions.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("Top 3 Transactions:-"+top3Transactions);


        List<Integer> sortedListInDescendingOrder = transactions.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Sorted (Descending):-"+sortedListInDescendingOrder);

//        🔹 Q2 – Collections & Framework
//        You are given the following:
//        Map<String, Integer> inventory = new HashMap<>();
//        inventory.put("Laptop", 10);
//        inventory.put("Mouse", 50);
//        inventory.put("Keyboard", 35);
//        inventory.put("Monitor", 20);
//        inventory.put("USB", 50);
//        👉 Tasks:
//        Find the item(s) with the highest stock count.
//        Sort all items by stock (descending order).
//        Increase the stock of all items by 10 % and print the updated inventory.
//        Store all unique stock counts in a TreeSet and print them in sorted order.
//        ✅ Expected Output Format:
//        Highest Stock Items: [Mouse, USB]
//        Sorted by Stock:
//        USB -> 50
//        Mouse -> 50
//        Keyboard -> 35
//        Monitor -> 20
//        Laptop -> 10
//        Updated Inventory (after 10% increase): {Laptop=11, Mouse=55, Keyboard=38, Monitor=22, USB=55}
//        Unique Stock Counts (Sorted): [11, 22, 38, 55]

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Laptop", 10);
        inventory.put("Mouse", 50);
        inventory.put("Keyboard", 35);
        inventory.put("Monitor", 20);
        inventory.put("USB", 50);


        List<String> stringList = new ArrayList<>();
        Integer max = Collections.max(inventory.values());

        for(Map.Entry<String,Integer> map : inventory.entrySet()){
            if(Objects.equals(map.getValue(), max)){
                stringList.add(map.getKey());
            }
        }
        System.out.println("Highest Stock Items: "+stringList);

//      Another approach using stream API :-
//      Find highest stock items
//      int max = Collections.max(inventory.values());
//      List<String> highestStockItems = inventory.entrySet().stream()
//                .filter(e -> e.getValue().equals(max))
//                .map(Map.Entry::getKey)
//                .toList();
//        System.out.println("Highest Stock Items: " + highestStockItems);


        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(inventory.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println("Sorted by Stock:");
        for(int i = 0 ; i<entryList.size();i++){
            System.out.println(entryList.get(i).getKey()+"-->"+entryList.get(i).getValue());
        }

//        Another approach using stream API
        // Sort by stock (descending)
//        System.out.println("Sorted by Stock:");
//        inventory.entrySet().stream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
//                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

//        Set<Map.Entry<String, Integer>> entries = inventory.entrySet();
//        for(Map.Entry<String,Integer> entry : entries){
//            inventory.put(entry.getKey(), (int)(entry.getValue()+(entry.getValue()*0.10)));
//        }
//        I made a mistake that i should avoid modifying map while iterating
//        updating the same map (inventory) while iterating over its entrySet().
//        his usually works with HashMap, but it’s not recommended — in
//        some cases, it may throw a ConcurrentModificationException.


//        ✅ Better way:
//        Use .replaceAll() (cleaner and safer):
        inventory.replaceAll((key,value)->(int)(value*1.10));

        System.out.println("Updated Inventory (after 10% increase):"+inventory);

        Set<Integer> uniqueStockCountInsortedOrder = new TreeSet<>(inventory.values());
        System.out.println("Unique Stock Counts (Sorted): "+uniqueStockCountInsortedOrder);


//        Q3) DSA
//        152. Maximum Product Subarray
//        Given an integer array nums, find a subarray that has the largest product,
//        and return the product.
//
//        The test cases are generated so that the answer will fit in a 32-bit integer.
//        Example 1:
//        Input: nums = [2,3,-2,4]
//        Output: 6
//        Explanation: [2,3] has the largest product 6.
//        Example 2:
//        Input: nums = [-2,0,-1]
//        Output: 0
//        Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

        //Bruteforce approach :-
        int[] numbers = {2,3,-2,4};
        int answer = 0;

        for(int i = 0 ; i<numbers.length;i++){
            int multiplication=1;
            for(int j = i;j<numbers.length;j++){
                multiplication*=numbers[j];

                answer = Math.max(answer,multiplication);
            }
        }
        System.out.println("Maximum Product Subarray:-"+answer);




//  Optimized approach:-
        int maximumProduct = Integer.MIN_VALUE;
        int prefix = 1 ;
        int suffix = 1;


        for(int i = 0 ; i<numbers.length;i++){
            prefix=prefix*numbers[i];
            suffix=suffix*numbers[numbers.length-i-1];

            maximumProduct = Math.max(maximumProduct,Math.max(prefix,suffix));
            if(prefix==0){
                prefix =1;
            }
            if(suffix==0){
                suffix=1;
            }

        }
        System.out.println("Maximum product :-"+maximumProduct);


    }
}



