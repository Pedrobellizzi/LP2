
import java.util.LinkedList;
import java.util.Objects;

public class LinkedStack implements IStackable {

     LinkedList<Integer> s1 = new LinkedList<Integer>();
       int sz1 = 0;
       
       public void push(int v){
             s1.add(v);
             sz1++;
       }

       public int pop(){
            sz1--; 
            return s1.removeFirst();
       }       

       public int size(){
            return sz1;
       }

}

