package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created by yulai on 10/9/15.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        return result;
    }

    public void dfs(ArrayList<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0&&right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }

    @Test
    public void test() {
        generateParenthesis(3);
    }

}
