package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yulai on 12/16/16.
 */
public class TwoSumIII {
    public class TwoSum {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        public void add(int number) {
            if (map.containsKey(number)) map.put(number, map.get(number) + 1);
            else {
                map.put(number, 1);
                list.add(number);
            }
        }

        public boolean find(int value) {
            for (int i = 0; i < list.size(); i++){
                int num1 = list.get(i), num2 = value - num1;
                if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
            }
            return false;
        }
    }
}
