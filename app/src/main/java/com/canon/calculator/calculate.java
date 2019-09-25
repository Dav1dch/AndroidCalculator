package com.canon.calculator;

public class calculate {
    public boolean isDigit(char ch){
        return ((ch > '0') && (ch < '9'));

    }

    public boolean isSymbol(char ch){
        return ((ch == '/') || (ch == '+') || (ch == '-') || (ch == '*'));
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
                System.out.println(j);
                NewExperssion.insert(j+1,')');
                NewExperssion.insert(i,'(');
                NewExperssion.insert(i+1, '0');
                i+=2;
            }
        }
        return NewExperssion;
    }

    public static void main(String[] args) {
        calculate cal = new calculate();
        String test= "6*-1/-2+2";
        System.out.printf(String.valueOf(cal.format(test)));
    }
}
