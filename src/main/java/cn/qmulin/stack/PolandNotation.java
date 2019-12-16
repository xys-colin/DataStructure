package cn.qmulin.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 - ";
        String expression = "1+((2+3)*4)-5";
        List<String> rpnList = getListString(suffixExpression);
        //System.out.println(rpnList);
        List<String> infixExpressionList=toInfixExpressionList(expression);
        List<String> parseSuffix=parseSuffixExpressionList(infixExpressionList);
        System.out.println("中缀表达式转变为后缀表达式"+parseSuffix);
        int res = calculate(rpnList);
        // System.out.println(res);
    }

    /**
     * 把中缀表达式切割成list集合
     * @param s
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;//这时是一个指针,用于遍历中缀表达式字符串
        String string;//对多位数的拼接
        char c;//每遍历到一个字符,就放入到C
        do {
            //如果c是一个非数字,我需要加入到list中
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {//如果是一个数,需要考虑多位数
                string = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    string += c;
                    i++;
                }
                list.add(string);
            }
        } while (i < s.length());
        return list;
    }

    public static List<String> parseSuffixExpressionList(List<String> strings) {
        //符号栈
        Stack<String> s1 = new Stack<>();
        //说明: 因为s2这个栈,在整个转换过程中,pop操作,而且后面还需要逆序输出
        //所以这里不用Stack直接使用list
        List<String> s2 = new ArrayList<>();//存储中间结果的list
        for (String item : strings) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号,则依次弹出s1栈顶的运算符,并压入s2,直到遇到左括号位置
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 &&Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
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

class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}
