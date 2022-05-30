package exemplos;

import java.sql.Date;
import java.util.concurrent.Semaphore;

//esta classe cria a fila de impressoes e controla o acesso
class FilaSemaforo 
{
   private final Semaphore semaphore;
 
   public FilaSemaforo()
   {
	   //instanciando o metodo de semaforo binario
      semaphore = new Semaphore(1);
   }
 
   public void imprime(Object document)
   {
      try
      {
    	  //chamando o metodo
         semaphore.acquire();
          //ordem randomica da fila
         Long duration = (long) (Math.random() * 10000);
         System.out.println(Thread.currentThread().getName() 
        		 + ": Fila de Impressao: Imprimindo durante " 
        		 + (duration / 1000) + " seconds :: Time - " 
        		 + new Date(duration));
         Thread.sleep(duration);
      } 
      catch (InterruptedException e)
      {
         e.printStackTrace();
      } 
      finally
      {
         System.out.printf("%s: O documento foi impresso\n", Thread.currentThread().getName());
         
         //encerrando o semaforo
         semaphore.release();
      }
   }
}