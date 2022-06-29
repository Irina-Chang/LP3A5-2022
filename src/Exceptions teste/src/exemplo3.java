import java.util.InputMismatchException;
import java.util.Scanner;

public class exemplo3 {
public static void main (String[] args) {
    Scanner dado = new Scanner(System.in);

    try {
        System.out.print("Informe o índice: ");
        String i = dado.nextLine();

        System.out.println (GetIndice(i));
    }
    catch (IndexOutOfBoundsException | InputMismatchException e) {
        if (e.getClass().toString().equals("class java.lang.ArrayIndexOutOfBoundException"))
    System.out.println ("O indice informado não existe!");
        else if (e.getClass().toString().equals("java.util.InputMismatchException"))
            System.out.println("O índice informado precisa ser uma letra!");
    }
    dado.close();
}

    public static String GetIndice (String indice) {
        String[] valores = { "A", "B", "C", "D", "E"};
    return valores[Integer.parseInt(indice)];
}

}
