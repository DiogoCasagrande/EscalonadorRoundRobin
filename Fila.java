
//implementação da fila
public class Fila {
    int size;
    No inicio;
    No fim;
    
    public void equeue(Processo p){
        if(isEmpty()){
            inicio = new No(p);
            size++;
        }
    }
    public Processo dequeue(){
        return null;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public String print(){
        return null;
    }
}
