
//implementação da fila
public class Fila {
    int size;
    No inicio;
    
    public void equeue(Processo p){
        if(isEmpty()){
            inicio = new No(p);
            size++;
        }
        else {
            No aux = inicio;
            for(int i = 0;i < size;i++){
                if(aux.proximo!=null){
                    aux = aux.proximo;
                }
                else
                    break;
            }
            aux.proximo = new No(p);
            
            size++;
        }
    }
    public Processo dequeue(){
        if(isEmpty()) return null;
        else{
            No aux = inicio;
            inicio = inicio.proximo;
            size--;
            return aux.valor;
        }
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    public String print(){
        String saida = "";
        No aux = inicio;
        for(int i = 0; i<size;i++){
            saida += aux.valor.pid +"("+aux.valor.duracao+") ";
            aux = aux.proximo;
        }
        return saida;
    }
}
