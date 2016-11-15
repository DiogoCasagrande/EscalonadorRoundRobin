//implementação da fila
public class FilaPronto {
    noFilaCircular inicio, fim, proximo;
    
    public boolean vazia(){
        return inicio == null && fim == null;
    }//caso a fila esteja vazia retorna verdadeiro
    
    public void adicionarFila(int dado){
        noFilaCircular novo = new noFilaCircular(dado);
        
        if(vazia()){
            inicio = novo;
            fim = novo;
            fim.proximo = inicio;
        }else{
            novo.proximo = inicio;
            fim.proximo = novo;
            fim = novo;
        }
    }
    
    public int removerFila(){
        int removido;
        
        if (vazia()){
            removido = -1;
        }else if (inicio == fim){
            removido = inicio.dado;
            inicio = null;
            fim = null;
        }else{
            removido = inicio.dado;
            fim = inicio;
            inicio = inicio.proximo;
            fim.proximo = inicio;
        }
        return removido;
    }
    
    public FilaPronto(){
        this.inicio = null;
        this.fim = null;
        
    }
    
}
