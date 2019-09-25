
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class calculate {

    private Map<String, Integer> priority;

    public calculate(){
        init();
    }

    private  void init(){
        this.priority = new HashMap<>();
        this.priority.put("#", 0);
        this.priority.put("*", 2);
        this.priority.put("/", 2);
        this.priority.put("-", 1);
        this.priority.put("+", 1);
        this.priority.put("(", 3);
    }

    public int getPriority(String operator){
       return priority.get(operator);
    }

    public boolean judgePriority(String one, String another){
        return getPriority(one) <= getPriority(another);
    }

    public boolean isDigit(char ch){
        return ((ch > '0') && (ch < '9'));

    }

    public boolean isSymbol(char ch){
        return ((ch == '/') || (ch == '+') || (ch == '-') || (ch == '*') || (ch == '(') || (ch == ')'));
    }

    public StringBuilder format(String experssion){
        StringBuilder NewExperssion = new StringBuilder(experssion);
        if((NewExperssion.charAt(0) == '-') || (NewExperssion.charAt(0) == '+')) NewExperssion.insert(0, '0');
        int size = NewExperssion.length();
        for (int i=0; i < size; i++){
            if (((NewExperssion.charAt(i) == '+') || (NewExperssion.charAt(i) == '-')) &&
                    ((NewExperssion.charAt(i-1) == '/') || (NewExperssion.charAt(i-1) == '*'))){
                int j =i;
                for (j = i + 1;j < size; ++j){
                    if(!(isDigit(NewExperssion.charAt(j)) && NewExperssion.charAt(j) == '.')){
                        break;
                    }
                }
                NewExperssion.insert(j+1,')');
                NewExperssion.insert(i,'(');
                NewExperssion.insert(i+1, '0');
                i+=2;
            }
        }
        return NewExperssion;
    }
    public Stack<String> InterfixToSufix(String experssion){
        Stack<String> stack = new Stack<String>();
        Stack<String> post = new Stack<String>();
        stack.push("#");
        StringBuilder NewExperssion = new StringBuilder(experssion);
        StringBuilder tmp = new StringBuilder();
        int size = NewExperssion.length();
        for(int i=0; i < size; i++){
           while ((i < size) &&!isSymbol(NewExperssion.charAt(i))){
              tmp.append(String.valueOf(NewExperssion.charAt(i)));
              i++;
           }
           if (!String.valueOf(tmp).equals("")){
               post.push(String.valueOf(tmp));
               tmp.delete(0, tmp.length());
           }
           if (i >= size) break;
           if (isSymbol(NewExperssion.charAt(i))){
               if (NewExperssion.charAt(i) == ')'){
                   while(!stack.peek().equals("(")){
                       System.out.print(stack.peek());
                       post.push(String.valueOf(stack.pop()));
                   }
                   post.pop();
               }else{
                   if (judgePriority(stack.peek(), String.valueOf(NewExperssion.charAt(i)))){
                     stack.push(String.valueOf(NewExperssion.charAt(i)));
                       System.out.println(stack.peek());
                   }else{
                       post.push(String.valueOf(NewExperssion.charAt(i)));
                   }
               }
           }
        }
        while(!stack.peek().equals("#")){
            post.push(stack.pop());
        }
        return post;
    }

    public static void main(String[] args) {
        calculate cal = new calculate();
        String test= "2*(9+6/3-5)+4";
        test= String.valueOf(cal.format(test));
        System.out.println(test);
        System.out.println(cal.InterfixToSufix(test).toString());

    }
}
