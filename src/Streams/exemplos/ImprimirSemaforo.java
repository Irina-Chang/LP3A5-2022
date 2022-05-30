package exemplos;
//classe q ira solicitar uma impressao

class ImprimirSemaforo implements Runnable
{
   private FilaSemaforo  filaSemaforo;
 
   public ImprimirSemaforo(FilaSemaforo filaSemaforo)
   {
      this.filaSemaforo = filaSemaforo;
   }
 
   @Override
   public void run()
   {
      System.out.printf("%s: Imprimindo o documento\n", Thread.currentThread()
    		  .getName());
      filaSemaforo.imprime(new Object());
   }
}