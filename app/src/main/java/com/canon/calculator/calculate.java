/*tuffy*/
package com.canon.calculator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class calculate {

    private Map<String, Integer> priority;

    public calculate() {
        init();
    }

    private void init() {
        this.priority = new HashMap<>();
        this.priority.put("#", 0);
        this.priority.put("*", 3);
        this.priority.put("/", 3);
        this.priority.put("-", 2);
        this.priority.put("+", 2);
        this.priority.put("(", 1);
    }

    public int getPriority(String operator) {
        return priority.get(operator);
    }

    public boolean judgePriority(String one, String another) {
        return getPriority(one) < getPriority(another);
    }

    public boolean isDigit(char ch) {
        return ((ch >= '0') && (ch <= '9'));

    }

    public boolean isSymbol(char ch) {
        return ((ch == '/') || (ch == '+') || (ch == '-') || (ch == '*') || (ch == '(') || (ch == ')'));
    }

    public StringBuilder format(String experssion) {
        StringBuilder NewExperssion = new StringBuilder(experssion);
        if ((NewExperssion.charAt(0) == '-') || (NewExperssion.charAt(0) == '+'))
            NewExperssion.insert(0, '0');
        int j;
        for (int i = 0; i < NewExperssion.length(); i++) {
            if (((NewExperssion.charAt(i) == '+') || (NewExperssion.charAt(i) == '-'))
                    && ((NewExperssion.charAt(i - 1) == '/') || (NewExperssion.charAt(i - 1) == '*'))) {
                for (j = i + 1; j < NewExperssion.length(); ++j) {
                    if (isSymbol(NewExperssion.charAt(j))) {
                        break;
                    }
                }
                NewExperssion.insert(j, ')');
                NewExperssion.insert(i, '(');
                NewExperssion.insert(i + 1, '0');
                i += 2;
            }
            else if(((NewExperssion.charAt(i) == '+') || (NewExperssion.charAt(i) == '-'))
                    && (NewExperssion.charAt(i - 1) == '(')){
                        NewExperssion.insert(i, '0');
                    }
            if (NewExperssion.charAt(i)=='%'){
                String per = "*0.01";
                for (int l = 0 ;l < per.length(); l++){
                    NewExperssion.insert(i++, per.charAt(l));
                }
                NewExperssion.deleteCharAt(i--);
            }
            if((NewExperssion.charAt(i) == '(') && (NewExperssion.length() > 1) && (this.isDigit(NewExperssion.charAt(i-1)))){
                NewExperssion.insert(i++, '*');
            }
        }
        System.out.println(String.valueOf(NewExperssion));
        return NewExperssion;
    }

    public LinkedList<String> InterfixToSufix(String experssion) {
        Stack<String> stack = new Stack<String>();
        LinkedList<String> post = new LinkedList<String>();
        stack.push("#");
        StringBuilder NewExperssion = new StringBuilder(experssion);
        StringBuilder tmp = new StringBuilder();
        int size = NewExperssion.length();
        for (int i = 0; i < size; i++) {
            while ((i < size) && !isSymbol(NewExperssion.charAt(i))) {
                tmp.append(String.valueOf(NewExperssion.charAt(i)));
                i++;
            }
            if (!String.valueOf(tmp).equals("")) {
                post.add(String.valueOf(tmp));
                tmp.delete(0, tmp.length());
            }
            if (i >= size)
                break;
            if (isSymbol(NewExperssion.charAt(i))) {
                if (NewExperssion.charAt(i) == '(') {
                    stack.push("(");
                } else if (NewExperssion.charAt(i) == ')') {
                    while (!stack.peek().equals("(")) {
                        post.add(String.valueOf(stack.pop()));
                    }
                    stack.pop();
                } else {
                    if (judgePriority(stack.peek(), String.valueOf(NewExperssion.charAt(i)))) {
                        stack.push(String.valueOf(NewExperssion.charAt(i)));
                    } else {
                        while (!judgePriority(stack.peek(), String.valueOf(NewExperssion.charAt(i)))) {
                            post.add(stack.pop());
                        }
                        stack.push(String.valueOf(NewExperssion.charAt(i)));
                    }
                }
            }
        }
        while (!stack.peek().equals("#")) {
            post.add(stack.pop());
        }
        return post;
    }

    public String getResult(String experssion) {
        try {
            StringBuilder NewExperssion = new StringBuilder(this.format(experssion));
            LinkedList<String> post = this.InterfixToSufix(String.valueOf(NewExperssion));
            Stack<Double> result = new Stack<Double>();
            String tmp;
            Double one, two, temp = 0.0;
            while (!post.isEmpty()) {
                tmp = post.poll();
                if (!isSymbol(tmp.toCharArray()[0])) {
                    result.push(Double.valueOf(tmp));
                } else {
                    one = result.pop();
                    two = result.pop();
                    switch (tmp.toCharArray()[0]) {
                    case '+':
                        temp = one + two;
                        break;
                    case '-':
                        temp = two - one;
                        break;
                    case '*':
                        temp = one * two;
                        break;
                    case '/':
                        temp = two / one;
                        break;
                    }
                    result.push(temp);

                }
            }
            String finalresult = String.valueOf(result.peek());
            if (!finalresult.equals("") && finalresult.indexOf('.') > 0){
                finalresult = finalresult.replaceAll("0+?$", "");
                finalresult = finalresult.replaceAll("[.]$", "");
            }
            return String.valueOf(finalresult);

        } catch (Exception e) {
            return "error";
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        calculate cal = new calculate();
        String test = "10.";
        System.out.println(cal.getResult(test));
    }
}
