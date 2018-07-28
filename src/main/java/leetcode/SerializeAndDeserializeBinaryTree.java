package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by adarsh.sharma on 28/07/18.
 */
public class SerializeAndDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> dq = new LinkedList<>();
        List<String> res = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        int nCount = 0;
        dq.addLast(root);
        int count = 1;
        int j = count;

        while (!dq.isEmpty()) {
            TreeNode n = dq.pollFirst();
            j--;
            if (n != null) {
                r.add(n.val);
                dq.add(n.left);
                dq.add(n.right);
            } else {
                nCount++;
                r.add(null);
                dq.add(null);
                dq.add(null);
            }

            if (j == 0) {
                if (r.size() == nCount) {
                    break;
                }
                count *= 2;
                j = count;
                res.addAll(compress(r));
                r = new ArrayList<>();
                nCount = 0;
            }
        }
        return res.toString();
    }

    private List<String> compress(List<Integer> r) {
        List<String> res = new ArrayList<>();
        int count = 0;
        for (Integer val : r) {
            if (val == null) {
                count++;
            } else {
                if (count > 0) {
                    res.add(count + "|n");
                    count = 0;
                }
                res.add(val + "");
            }
        }

        if (count > 0) {
            res.add(count + "|n");
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] strs = data.split(",");
        strs[0] = strs[0].replace("[", "");
        strs[strs.length - 1] = strs[strs.length - 1].replace("]", "");

        TreeNode root = new TreeNode(Integer.parseInt(strs[0].trim()));

        List<Integer> l = new ArrayList<>();
        for (String str : strs) {
            str = str.trim();
            if (str.contains("n")) {
                int count = Integer.parseInt(str.split("\\|")[0]);
                while (count > 0) {
                    l.add(null);
                    count--;
                }
            } else {
                l.add(Integer.parseInt(str));
            }
        }

        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        int i = 1;
        while (!dq.isEmpty() && i < l.size()) {
            TreeNode n = dq.pollFirst();
            if (n == null) {
                i += 2;
                dq.addLast(null);
                dq.addLast(null);
            } else {
                if (l.get(i) != null) {
                    n.left = new TreeNode(l.get(i));
                    dq.addLast(n.left);
                } else {
                    dq.addLast(null);
                }
                i++;
                if (i < l.size()) {
                    if (l.get(i) != null) {
                        n.right = new TreeNode(l.get(i));
                        dq.addLast(n.right);
                    } else {
                        dq.addLast(null);
                    }
                    i++;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        String serialize = s.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = s.deserialize(serialize);
        System.out.println("done");
    }
}
