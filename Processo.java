public class Processo {
    public String pid;
    public int duracao;
    public int chegada;
    public int opIO [];
    public int cpuUsing;
    
    public Processo(String pid, int duracao,int chegada,int opIO[]){
        this.pid = pid;
        this.duracao = duracao;
        this.chegada = chegada;
        this.opIO = opIO;
        this.cpuUsing = 0;
    }
}
