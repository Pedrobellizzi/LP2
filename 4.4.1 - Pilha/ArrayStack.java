
import java.util.ArrayList;
import java.util.Objects;

public class ArrayStack implements IStackable {

       ArrayList<Integer> s2 = new ArrayList<Integer>();
       int sz2 = 0;
       int v2;

       public void push(int v2){
             s2.add(v2);
             sz2++;
       }

       public int pop(){
//            s2.remove(sz2);
            sz2--; 
            return s2.remove(s2.size()-1);
       }       

       public int size(){
            return sz2;
       }

}

