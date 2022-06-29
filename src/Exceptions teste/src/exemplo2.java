public class exemplo2 {
    public static void main(String[] args) {
        try {
            int numero = Integer.parseInt("12a4");
            System.out.println("Entrada convertida para o tipo inteiro!");
        } catch (Exception e) {
            System.out.println("A operação retornou o seguinte erro: ");
            if (e.getClass().toString().equals("class java.lang.NumberFormatException"))
                System.out.println("O numero informado é invalido!");
        }
    }
}
