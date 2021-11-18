
import java.util.ArrayList;
import java.util.Objects;

public class ArrayStack implements IStackable {

       ArrayList<Integer> s2 = new ArrayList<Integer>();
       int sz2 = 0;
       
       public void push(int v){
             s2.add(v);
             sz2++;
       }

       public int pop(){
            sz2--; 
            return s2.remove(s2.size()-1);
       }       

       public int size(){
            return sz2;
       }

}

