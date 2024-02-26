import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int sorteado, numero, tentativas=0;
        Scanner scanner = new Scanner(System.in);
        Random numeroAleatorio = new Random();
        sorteado = numeroAleatorio.nextInt(10);

        do{
            System.out.println("Digite seu número: ");
            numero = scanner.nextInt();

            tentativas++;

        }while(numero != sorteado);

        if(numero == sorteado){
            System.out.println("Você acertou o número " + sorteado + " em "+ tentativas + " tentativas!!");
        }
    }
}
