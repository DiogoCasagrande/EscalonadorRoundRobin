public class Processo {
    String pid;
    int duracao;
    int chegada;
    int opIO [];
    
    public Processo(String pid, int duracao,int chegada,int opIO[]){
        this.pid = pid;
        this.duracao = duracao;
        this.chegada = chegada;
        this.opIO = opIO;
    }
}
