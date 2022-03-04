package geeksForGeeks;

import java.util.HashSet;

public class KeyPair {

    public static void main(String[] args) {
        int x=4;
        int[] arr={1,2,5,6,7};
//        for(int i=0;i<arr.length;i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[i] + arr[j] == x ) {
//                    if(i!=j)
//                    {
//                        System.out.println(arr[i]+" "+arr[j]);
//                    }
//                }
//            }
//        }

        HashSet<Integer> s = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            int temp=x-arr[i];

            if(s.contains(temp))
            {
                System.out.println("YES");
            }
            s.add(arr[i]);
        }
        System.out.println("NO");
    }
}


