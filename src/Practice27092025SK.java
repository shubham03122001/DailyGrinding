import java.util.*;
import java.util.stream.Collectors;

public class Practice27092025SK {

    public static void main(String[] args) {
//       🔹 Stream API Question
//       Problem:
//       You are given a list of strings:List<String> words = Arrays.asList("apple", "banana", "pear", "mango", "pineapple", "kiwi");

//        👉 Using Stream API, do the following:
//        Find the longest word in the list.
//        Count how many words start with "p".
//        Convert all words to uppercase and collect them into a new list.
//        ✅ Output Format:
//        Longest word: pineapple
//        Words starting with 'p': 2
//        Uppercase List: [APPLE, BANANA, PEAR, MANGO, PINEAPPLE, KIWI]

        List<String> words = Arrays.asList("apple", "banana", "pear", "mango", "pineapple", "kiwi");

        String maxWord = words.stream()
                .max(Comparator.comparing(fruit -> fruit.length()))
                .orElse("word not found");
        System.out.println("Longest word in list:-" + maxWord);


//        Map<String, Long> collect = words.stream()
//                .collect(
//                        Collectors.groupingBy(
//                                word -> word.substring(0, 1), //Key :- first letter
//                                Collectors.counting() //value :- count of words
//                        )
//                );
//
//        System.out.println(collect);

        long count = words.stream()
                .filter(fruit -> fruit.startsWith("p"))
                .count();

        System.out.println("Words starting with 'p' " + count);


        List<String> uppercaseCollection = words.stream()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(uppercaseCollection);


//        🔹 Collections & Framework Question
//        Problem:
//        You are given the following:
//        Map<String, Integer> scores = new HashMap<>();
//        scores.put("Alice", 85);
//        scores.put("Bob", 92);
//        scores.put("Charlie", 78);
//        scores.put("David", 92);
//        👉 Do the following:
//        Find the student(s) with the highest score. (If multiple, print all.)
//        Remove the student "Charlie" from the map.
//        Iterate through the map and print "Name: <key>, Score: <value>".
//        ✅ Output Format:
//        Highest Score Students: [Bob, David]
//        After removing Charlie:
//        Name: Alice, Score: 85
//        Name: Bob, Score: 92
//        Name: David, Score: 92

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 78);
        scores.put("David", 92);
        scores.put("Shubham",92);


        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());

        //Find the student(s) with the highest score. (If multiple, print all.)
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        Set<String> answerList = new HashSet<>();
        System.out.println("Entries in list after sorting elements based on makrs "+entries);

        for(int i = 1 ; i<entries.size();i++){
            if(entries.get(i - 1).getValue().equals(entries.get(i).getValue())){
                answerList.add(entries.get(i-1).getKey());
                answerList.add(entries.get(i).getKey());

            }

        }

        System.out.println(answerList);


        //Remove the student "Charlie" from the map.

        String nameToRemove="Charlie";

        scores.remove(nameToRemove);




        for(String key: scores.keySet()){
            System.out.println("Name:"+key+" Score :"+scores.get(key));
        }

        //DSA Question :-
        //121. Best Time to Buy and Sell Stock
//        You are given an array prices where prices[i] is the price of a given stock on the ith day.
//        You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//        Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//        Example 1:
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//        Example 2:
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transactions are done and the max profit = 0.
//        Constraints:
//        1 <= prices.length <= 105
//        0 <= prices[i] <= 104

        int[] prices = {7,1,5,3,6,4};
        // Output: 5

        int minimum = prices[0];
        int maxProfit = 0;

        for(int i = 1 ; i<prices.length;i++){
            int cost = prices[i]-minimum;

            maxProfit = Math.max(maxProfit,cost);

            minimum = Math.min(minimum,prices[i]);
        }

        System.out.println("Max Profit:-"+maxProfit);




    }


    }

