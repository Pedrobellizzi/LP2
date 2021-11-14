
import java.util.LinkedList;
import java.util.Objects;

public class LinkedStack implements IStackable {

     LinkedList<Integer> s1 = new LinkedList<Integer>();
       int sz1 = 0;
       int v1;

       public void push(int v1){
             s1.add(v1);
             sz1++;
       }

       public int pop(){
//            s1.remove(sz1);
            sz1--; 
            return s1.removeFirst();
       }       

       public int size(){
            return sz1;
       }

}

