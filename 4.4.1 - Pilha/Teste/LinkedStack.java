import java.util;
import java.LinkedList;
import IStackable.*;

public class LinkedStack implements IStackable {

      LinkedList l = newLinkedList();
           private Elemento first;
           private Elemento last;
           private int size;

           public LinkedList(){
                this.size = 0;
           }

           public Elemento getFirst() {
                return first;
           }

           public Elemento setFirst(Elemento first) {
                this.first = first;
           }

           public Elemento getLast() {
                return last;
           }

           public Elemento setLast(Elemento last) {
                this.last = last;
           }

           public int getSize() {
                return size;
           }

           public Elemento setSize(int size) {
                this.size = size;
           }

           public void add(int valor){
                 Elemento novoElemento = newElemento(novoValor);
                 if (this.first == null && this.last == null){
                      this.first = novoElemento;
                      this.last = novoElemento;
                 }else{
                      novoElemento.setProximo(this.first);
                      this.first = novoElemento;
                 }
                 this.size++;
           }

           public void remove(int valorProcurado){
                 Elemento anterior = null;
                 Elemento atual = this.first;
                 


           } 

}