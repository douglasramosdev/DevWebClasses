import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numeroN;

        System.out.println("Digite um número maior que 1: ");
        numeroN = scanner.nextInt();

        if(numeroN > 1){
                for (int i = 2; i < numeroN; i++){
                    if(numeroN % i == 0){
                        System.out.println("O número " + numeroN + " não é primo");
                        System.exit(0);
                    }
                System.out.println("O número " + numeroN + " é primo");
                System.exit(0);
                }
        }else{
            System.out.println("Digite um numero maior do que 1!!");
        }

    }
}
