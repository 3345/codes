package leetcode;

import java.util.Stack;

import org.junit.Test;

/**
 Suppose we abstract our file system by a string in the following manner:

 The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

 dir
    subdir1
    subdir2
        file.ext
 The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

 The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

 dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
 The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

 We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

 Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.

 Note:
 The name of a file contains at least a . and an extension.
 The name of a directory or sub-directory will not contain a ..
 Time complexity required: O(n) where n is the size of the input string.

 Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.

 */
public class LongestAbsoluteFilePath {
    public class Node {
        public int level;
        public int parentLen;
        public int selfLen;

        public Node(int level, int parentLen, int selfLen) {
            this.level = level;
            this.parentLen = parentLen;
            this.selfLen = selfLen;
        }
    }

    public int lengthLongestPath(String input) {
        Stack<Node> main = new Stack<>();
        Stack<Node> buffer = new Stack<>();
        int max = 0;

        char[] arr = (input).toCharArray();

        int level = 0;
        boolean dot = false;
        int i = 0;
        int len = 0;

        while (i < arr.length) {
            if (arr[i] != '\n') {
                len++;

                if (arr[i] == '.') {
                    dot = true;
                }

                if (i < arr.length - 1) {
                    i++;
                    continue;
                }
            }

            if (!dot) {
                if (main.isEmpty()) {
                    main.push(new Node(level, 0, len));
                } else {
                    Node top = main.peek();
                    while (top.level > level) {
                        main.pop();
                        top = main.peek();
                    }
                    if (top.level == level) {
                        main.push(new Node(level, top.parentLen, len));
                    } else {
                        main.push(new Node(level, top.parentLen + top.selfLen + 1, len));
                    }
                }

            } else {
                while(!main.empty() && main.peek().level >= level) {
                    buffer.push(main.pop());
                }

                if (main.empty()) {
                    max = Math.max(max, len);
                } else {
                    max = Math.max(max, main.peek().parentLen + main.peek().selfLen + len + 1);
                }

                while (!buffer.empty()) {
                    main.push(buffer.pop());
                }
            }


            int j = i + 1;
            int numT = 0;

            while (i < arr.length - 1 && (arr[j] == '\t' || arr[j] == ' ')) {
                if (!main.empty()) {
                    if (main.peek().level < numT) {
                        break;
                    }
                } else {
                    if(numT > 0) {
                        break;
                    }
                }
                if (arr[j] == '\t') {
                    numT ++;
                    j++;
                } else if (arr[j + 3] == ' '){
                    numT ++;
                    j+=4;
                } else {
                    break;
                }

            }


            if (i == arr.length - 1) {
                return max;
            }

            //reset dot, len
            i = j;
            dot = false;
            len = 0;
            level = numT;
        }

        return max;
    }

    @Test
    public void t0() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int i = lengthLongestPath(input);
        System.out.println(i);
    }

    @Test
    public void t1() {
        String input = "a.txt";
        int i = lengthLongestPath(input);
        System.out.println(i);
    }

    @Test
    public void t2() {
        String input = "dir\n    file.txt";
        int i = lengthLongestPath(input);
        System.out.println(i);
    }

    @Test
    public void t3() {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int i = lengthLongestPath(input);
        System.out.println(i);
    }

    @Test
    public void t4() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext";
        int i = lengthLongestPath(input);
        System.out.println(i);
    }

    @Test
    public void t5() {
        /**
         * a
         *     b
         *         c
         *             d
         *                 e.txt
         *                 alsdkjf.txt
         *         skdjfl.txtlsdkjflsdjflsajdflkjasklfjkasljfklas(46)
         *     lskdjflkajsflj.txt
         */
        String input = "a\n\tb\n\t\tc\n\t\t\td\n\t\t\t\te.txt\n\t\t\t\talsdkjf.txt\n\t\tskdjfl.txtlsdkjflsdjflsajdflkjasklfjkasljfklas\n\tlskdjflkajsflj.txt";
        int i = lengthLongestPath(input);
        System.out.println(i);
    }

}
