import java.util.*;

public class Practice23092025SK {

    public static void main(String[] args) {

//        Q1 (Stream API)
//        Problem:
//        Given a list of strings, return the strings that start with the letter "a",
//        convert them to uppercase, and sort them in alphabetical order.
//        Input: ["apple", "banana", "avocado", "cherry", "apricot"]
//        Expected Output: [APPLE, APRICOT, AVOCADO]

        List<String> list = Arrays.asList("apple", "banana", "avocado", "cherry", "apricot");

        List<String> result = list.stream()
                .filter(fruit -> fruit.startsWith("a"))
                .map(fruit -> fruit.toUpperCase())
                .sorted()
                .toList();

        System.out.println("Result :-"+result);

//        Q2 (Collections & Framework)
//        Problem:
//        You are given a HashMap<String, Integer> where keys are product names and values are their prices.
//        Find the top 3 most expensive products and print them in descending order of price.
//        Input:{ "Laptop"=80000, "Phone"=60000, "Tablet"=30000, "Watch"=15000, "Headphones"=5000 }
//        Expected Output:
//        Laptop=80000
//        Phone=60000
//        Tablet=30000

        Map<String,Integer>  map = new HashMap<>();
        map.put("Laptop",80000);
        map.put("Phone",60000);
        map.put("Tablet",30000);
        map.put("Watch",15000);
        map.put("Headphones",5000);

        List<Map.Entry<String,Integer>> newList = new ArrayList<>(map.entrySet());

        System.out.println("New list:-"+newList);



        Collections.sort(newList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return  o2.getValue() - o1.getValue();
                //Comparator safety: o2.getValue() - o1.getValue()
                // could overflow in theory if prices are very large. Better:
                //to overcome this we can also use
                //return Integer.compare(02.getValue() , 01.getValue());


            }
        });

        List<Map.Entry<String,Integer>> resultantList = new ArrayList<>();
        for(int i = 0 ; i<3;i++){
            resultantList.add(newList.get(i));
        }

        System.out.println(resultantList);


//        Q3 (DSA)
//        Problem:Given an array of integers, move all zeros to the end while maintaining the
//        relative order of the non-zero elements.
//        Input:[0, 1, 0, 3, 12]
//        Expected Output: [1, 3, 12, 0, 0]

        int[] inputArray = {0, 1, 0, 3, 12};
        int[] resultantArray = new int[inputArray.length];

        int index=0;
        for(int i = 0 ;i<inputArray.length;i++){
            int number = inputArray[i];
            if(number!=0){
                resultantArray[index] =  number;
                index++;
            }
        }


        for(int element : resultantArray){
            System.out.print(element+" ");
        }

        System.out.println();



    }
}
