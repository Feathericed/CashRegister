package com.example.cashregister;

import java.util.ArrayList;
import java.util.List;

public class CalcLogic {
    private final List <String>history =  new ArrayList<>();
    private String line;
     public String getHistory(){
        StringBuilder rtn = new StringBuilder();
         for (String item : history){
             rtn.insert(0, item + "\n");
         }
        return rtn.toString();
    }
    void push (String value) {
        history.add(value);
    }
    void setLine(String inp){
        line = inp;
    }
    int calculate() {
        char [] items= line.toCharArray();
        int rtn=0;
        int flag = 0;
        for(char item: items){
            if (item == 61)// if it is =
                return rtn;
            if (item == 43)//+
                flag = 1;
            else if(item == 45)// -
                flag = 2;
            else if( item == 47) // /
                flag = 3;
            else if (item == 42){
                flag = 4;
            } else if (item>47 && item <58){
                if (flag ==1 || flag ==0)
                    rtn += (item-48);
                else if (flag==2)
                    rtn -= (item-48);
                else if (flag==3)
                    if (item-48 == 0) {
                        break;
                    }
                    else rtn /= (item - 48);
                else if (flag==4)
                    rtn *= (item-48);
                flag=0;
            }
        }
        return rtn;
    }
}
