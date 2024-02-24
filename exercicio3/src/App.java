import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Double valorX;
        Double valorY;
        char operadorLogico;
        Double resultado;

        System.out.println("Digite um valor: ");
        valorX = scanner.nextDouble();
        System.out.println("Informe a operação ( (+) , (-) , (*) , (/) ): ");
        operadorLogico = scanner.next().charAt(0);
        System.out.println("Digite outro valor: ");
        valorY = scanner.nextDouble();


        if(operadorLogico == '+'){
            resultado = valorX + valorY;
            System.out.println(resultado);
        }else if (operadorLogico == '-'){
            resultado = valorX - valorY;
            System.out.println(resultado);
        }else if (operadorLogico == '*'){
            resultado = valorX * valorY;
            System.out.println(resultado);
        }else if (operadorLogico == '/'){
            resultado = valorX / valorY;
            System.out.println(resultado);
        } else {
                System.out.println("informe um operador logico valido!!");
        }
    }
}
