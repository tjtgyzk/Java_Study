package myStudy.Zuo.ShuaTi.Day01;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;

public class FindFile {
    public static int getFileNumber(String folderPath) {
        File root = new File(folderPath);
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        if (root.isFile()) {
            return 1;
        }
        Deque<File> stack = new LinkedList<>();
        stack.push(root);
        int num = 0;
        while (!stack.isEmpty()) {
            File folder = stack.pop();
            for (File next : folder.listFiles()) {
                if (next.isDirectory()) {
                    stack.push(next);
                } else if (next.isFile()) {
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(getFileNumber("C:\\Users\\86479\\Desktop\\实验报告"));
    }
}
