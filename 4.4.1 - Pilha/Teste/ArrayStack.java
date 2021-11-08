
import java.util.ArrayList;

public class ArrayStack implements IStackable {

       ArrayList s2 = new ArrayList();
       int sz2 = 0;
       int v2;

       public void push(int v2){
             s2.add(v2);
             sz2++;
       }

       public int pop(){
            s2.remove(sz2);
            sz2--; 
       }       

       public int size(){
            return sz2;
       }

}

