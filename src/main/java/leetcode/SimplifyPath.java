package leetcode;

import java.util.Stack;

/**
 * Created by yulai on 12/13/16.
 * "/a/./b/../../c/"
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }

        path += "/";

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                String dir = sb.toString();
                sb = new StringBuilder();
                if (dir.length() > 0) {
                    if (".".equals(dir)) {
                        continue;
                    } else if ("..".equals(dir)) {
                        if (!stack.isEmpty())
                            stack.pop();
                    } else {
                        stack.push(dir);
                    }
                }
            } else {
                sb.append(path.charAt(i));
            }
        }


        if (stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            ret.insert(0, "/"+stack.pop());
        }

        return ret.toString();
    }
}
