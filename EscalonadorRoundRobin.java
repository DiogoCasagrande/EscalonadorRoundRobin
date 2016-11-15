import java.lang.Thread;

public class EscalonadorRoundRobin {

    public static void main(String [] args)throws InterruptedException{
        int quantum = 4;
        int quantumCont = 0;
        int cont= 0;
        int qtdProcessos;
        
        Processo cpuP=null;
        String saidal1;
        String saidal2;
        String saidal3;
        
        Fila fila = new Fila();
        Processo [] ps = new Processo[5];
        
        //cria os processos
        ps[0] = new Processo("P1",9,10,new int[]{2,4,6,8});
        ps[1] = new Processo("P2",10,4,new int []{5});
        ps[2] = new Processo("P3",5,0,new int[]{2});
        ps[3] = new Processo("P4",7,1,new int[]{3,6});
        ps[4] = new Processo("P5",2,17,null);
        
        qtdProcessos = ps.length;
        
        System.out.println("*************************************");
        System.out.println("*******Escalonador Round-Robin*******");
        System.out.println("*************************************");
        saidal1 = "Tempo "+cont;
        saidal2 = "FILA: ";
        saidal3 = "CPU: ";
        
        for(int i = 0;i<ps.length;i++){
            if(ps[i].chegada == cont){
                fila.equeue(ps[i]);
                saidal1 +=" Chegada do processo " + ps[i].pid;
            }
        }
        do{

            //troca de contexto
            //uma thread pra add eles a fila baseada no tempo

                        //ao utilizar a cpu
            if(cpuP==null){
                    cpuP = fila.dequeue();
            }
            
            saidal2 += fila.print();
            saidal3 += cpuP.pid + " ("+cpuP.duracao+")";
            System.out.println(saidal1);
            System.out.println(saidal2);
            System.out.println(saidal3);
            System.out.println(" ");
            
            Thread.sleep(1000);
            cont++;
            
            saidal1 = "Tempo "+cont;
            saidal2 = "FILA: ";
            saidal3 = "CPU: ";
            
            if(cpuP!=null){
                cpuP.duracao-=1;
                cpuP.cpuUsing++;
                quantumCont++;
                if(cpuP.duracao == 0){
                    saidal1+=" Fim do processo "+cpuP.pid;
                    cpuP = fila.dequeue();
                    quantumCont = 0;
                    qtdProcessos--;
                }
                else if(quantumCont == quantum){
                    saidal1 += " Fim do quantum "+cpuP.pid;
                    quantumCont = 0;
                    fila.equeue(cpuP);
                    cpuP = fila.dequeue();
                }
                else {
                    for(int i = 0;i<ps.length;i++){
                        if(ps[i].chegada == cont){
                            fila.equeue(ps[i]);
                            saidal1 +=" Chegada do processo " + ps[i].pid;
                        }
                    }
                    if(cpuP.opIO!=null){
                        for(int i = 0; i< cpuP.opIO.length;i++){
                            if(cpuP.opIO[i] == cpuP.cpuUsing){
                                saidal1 += " Operacao de IO " + cpuP.pid;
                                fila.equeue(cpuP);

                                cpuP = fila.dequeue();
                                quantumCont = 0;
                                break;
                            }
                        }
                    }
                }
            }

        }while(qtdProcessos!=0);
        System.out.println("*************************************");
        System.out.println("Encerrando simulação de escalonamento");
        System.out.println("*************************************");
    }
}

