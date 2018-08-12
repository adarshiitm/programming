package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by adarsh.sharma on 17/07/18.
 */
public class LargestRectangleInHistogram84 {
    public int maxHistogram(int input[]) {
        Deque<Integer> stack = new LinkedList<>();
        int maxArea = 0;
        int i;
        for (i = 0; i < input.length; ) {
            if (stack.isEmpty() || input[stack.peekLast()] <= input[i]) {
                stack.addLast(i++);
            } else {
                maxArea = getMaxArea(input, stack, maxArea, i);
            }
        }
        while (!stack.isEmpty()) {
            maxArea = getMaxArea(input, stack, maxArea, i);
        }
        return maxArea;
    }

    private int getMaxArea(int[] input, Deque<Integer> stack, int maxArea, int i) {
        int area;
        int top = stack.pollLast();
        //if stack is empty means everything till i has to be
        //greater or equal to input[top] so get area by
        //input[top] * i;
        if (stack.isEmpty()) {
            area = input[top] * i;
        }
        //if stack is not empty then everything from i-1 to input.peek() + 1
        //has to be greater or equal to input[top]
        //so area = input[top]*(i - stack.peek() - 1);
        else {
            area = input[top] * (i - stack.peekLast() - 1);
        }
        if (area > maxArea) {
            maxArea = area;
        }
        return maxArea;
    }

    public static void main(String args[]) {
        LargestRectangleInHistogram84 mh = new LargestRectangleInHistogram84();
//        int input[] = {2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2};
        int input[] = {1, 2, 3, 1};
        int maxArea = mh.maxHistogram(input);
        System.out.println(maxArea);
        assert maxArea == 12;
    }

}
