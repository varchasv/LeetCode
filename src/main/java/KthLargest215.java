import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public  class KthLargest215 {
    public static void check(int[] nums, int k) {
        Queue<Integer> list = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : nums) {
            list.add(i);
        }
        for (int i = 0; i < k - 1; i++) {
            if (!list.isEmpty())
                list.remove();
        }
        if (!list.isEmpty()) {
            System.out.println(list.poll());
        } else {
            System.out.println(-1);
        }
            /* palindromic substring i is taken middle and middle +1 i.e in between 2 ele
            int left = i-(len-1)/2; // counting left most length
            int right = i+ (len)/2; // counting right most length

             */
    }
}
