/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.utilities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ruben
 */
public class Utilities {

public String Arraylist2string(ArrayList list)
{
    String ql="ARRAY[";
    for (int i = 0; i < list.size(); i++) {
        if(i==list.size()-1){ ql=ql+"'"+list.get(i) +"'";}
        else{ql=ql+"'"+list.get(i) +"',";}        
    }
    ql=ql+"]";
    System.out.println("ql---"+ql);
    return ql;
}

public ArrayList string2arraylist(String ar){

                ar = ar.substring(0, ar.length() - 1);               
                ar= ar.substring(1,ar.length());
                System.out.println("ar*************"+ar);                
                String[] ary = ar.split(",");
                // List<String> list = Arrays.asList(ary);
                ArrayList arraylist = new ArrayList<String>(Arrays.asList(ary));
                return arraylist;
                
}
        
    
}
