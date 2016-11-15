import java.lang.Thread;

public class EscalonadorRoundRobin {

    public static void main(String [] args)throws InterruptedException{
        int quantum = 4;
        int cont= 0;
        Processo cpuP=null;
        String saidal1, saidal2, saidal3;
        Fila fila = new Fila();
        Processo [] ps = new Processo[5];
        //cria os processos
        ps[0] = new Processo("P1",9,10,new int[]{2,4,6,8});
        ps[1] = new Processo("P2",10,4,new int []{5});
        ps[2] = new Processo("P3",5,0,new int[]{2});
        ps[3] = new Processo("P4",7,1,new int[]{3,6});
        ps[4] = new Processo("P5",2,17,null);
        
        do{
            saidal1 = "Tempo "+cont;
            saidal2 = "FILA: ";
            //troca de contexto
            //uma thread pra add eles a fila baseada no tempo
            for(int i = 0;i<ps.length;i++){
                if(ps[i].chegada == cont){
                    fila.equeue(ps[i]);
                    saidal1 +=" Chegada do processo " + ps[i].pid;
                }
            }
            
            //ao utilizar a cpu
            if(cpuP==null){
                cpuP = fila.dequeue();
            }
            if(cpuP!=null){
                for(int i = 0; i< cpuP.opIO.length;i++){
                    if(cpuP.opIO[i] == cont){
                        fila.equeue(cpuP);
                        cpuP = fila.dequeue();
                    }
                }
            }
            //string dos processos na fila
            
            
            //printa a saida
            
            //contar tempo
            Thread.sleep(1000);
            cont++;
        }while(true);
    }
}
