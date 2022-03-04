package geeksForGeeks;

import java.util.*;

public class TopKFrequentElementsInArray {
    // Java implementation to find
// k elements with max occurrence.

//    Algorithm:
//    Create a Hashmap hm, to store key-value pair, i.e. element-frequency pair.
//    Traverse the array from start to end.
//    For every element in the array update hm[array[i]]++
//    Store the element-frequency pair in a vector and sort the vector in decreasing order of frequency.
//    Print the first k elements of sorted array.
    static void print_N_mostFrequentNumber(int[] arr, int n, int k) {

        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Put count of all the
        // distinct elements in Map
        // with element as the key &
        // count as the value.
        for (int i = 0; i < n; i++) {

            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            mp.put(arr[i],
                    mp.getOrDefault(arr[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list
                = new ArrayList<Map.Entry<Integer,
                Integer>>(
                mp.entrySet());

//        // Sort the list
//        Collections.sort(list, new Comparator<Map.Entry<Integer,
//                        Integer>>() {
//                    public int compare(
//                            Map.Entry<Integer, Integer> o1,
//                            Map.Entry<Integer, Integer> o2) {
//                        if (o1.getValue() == o2.getValue())
//                            return o2.getKey() - o1.getKey();
//                        else
//                            return o2.getValue()
//                                    - o1.getValue();
//                    }
//                });


        Collections.sort(list,
                (o1, o2) -> {
                    if(o1.getValue() == o2.getValue()) {
                        return o2.getKey() - o1.getKey();
                    }
                    else {
                        return o2.getValue() - o1.getValue();
                    }
                });

//        list.stream().sorted((o1, o2) -> {
//                   if(o1.getValue() == o2.getValue()) {
//                        return o2.getKey() - o1.getKey();
//                   }
//                   else {
//                        return o2.getValue() - o1.getValue();
//                   }
//                }).forEach(System.out::println);


        for (int i = 0; i < k; i++)
            System.out.println(list.get(i).getKey());
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
        int n = arr.length;
        int k = 2;

        // Function call
        print_N_mostFrequentNumber(arr, n, k);
    }
}
