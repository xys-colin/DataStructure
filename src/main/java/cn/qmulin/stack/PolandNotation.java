package cn.qmulin.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 - ";
        List<String> rpnList = getListString(suffixExpression);
        //System.out.println(rpnList);
        int res = calculate(rpnList);
        System.out.println(res);
    }

    public static List<String> toInfixExpressionList(String s) {
       List<String> list=new ArrayList<>();
       int i=0;//这时是一个指针,用于遍历中缀表达式字符串
       String string;//对多位数的拼接
       char c;//每遍历到一个字符,就放入到C
        do {

        }while (i<s.length()){

        }

    }

    public static List<String> getListString(String suffix) {
        String[] split = suffix.split(" ");
        return new ArrayList<>(Arrays.asList(split));
    }

    public static int calculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
