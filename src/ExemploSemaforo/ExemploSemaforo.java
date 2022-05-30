package exemplos;

//classe que ira executar o programa
public class ExemploSemaforo 
{
   public static void main(String[] args)
   {
      FilaSemaforo filaSemaforo = new FilaSemaforo();
      Thread thread[] = new Thread[10];
      for (int i = 0; i < 10; i++)
      {
         thread[i] = new Thread(new ImprimirSemaforo(filaSemaforo), "Thread " 
      + i);
      }
      for (int i = 0; i < 10; i++)
      {
         thread[i].start();
      }
   }
}