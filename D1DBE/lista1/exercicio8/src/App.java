import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Digite os números do CPF digito a digito clicando ENTER");
        num[0] = scanner.nextInt();
        num[1] = scanner.nextInt();
        num[2] = scanner.nextInt();
        num[3] = scanner.nextInt();
        num[4] = scanner.nextInt();
        num[5] = scanner.nextInt();
        num[6] = scanner.nextInt();
        num[7] = scanner.nextInt();
        num[8] = scanner.nextInt();
        num[9] = scanner.nextInt();
        num[10] = scanner.nextInt();

        if((num[0] == num[1]) & (num[1] == num[2]) & (num[2] == num[3]) & (num[3] == num[4]) & (num[4] == num[5]) & (num[5] == num[6]) & (num[6] == num[7]) & (num[7] == num[8]) & (num[8] == num[9]) & (num[9] == num[10])){
            System.out.println("Digite um CPF válido");
            System.exit(0);
        }else{
            int somaDigito1 = (num[0]*10) + (num[1]*9) + (num[2]*8) + (num[3]*7) + (num[4]*6) + (num[5]*5) + (num[6]*4) + (num[7]*3) + (num[8]*2);
            int restoDigito1 = (somaDigito1 *10) % 11;
            if (restoDigito1 == 10){
                restoDigito1 = 0;
            }
            int somaDigito2 = (num[0]*11) + (num[1]*10) + (num[2]*9) + (num[3]*8) + (num[4]*7) + (num[5]*6) + (num[6]*5) + (num[7]*4) + (num[8]*3) + (num[9]*2) ;
            int restoDigito2 = (somaDigito2 * 10) % 11;
            if (restoDigito2 == 10){
                restoDigito2 = 0;
            }
            if ((restoDigito1 == num[9]) & (restoDigito2 == num[10])){
                System.out.println("CPF Válido");
            }else{
                System.out.println("CPF Inválido");
            }
        }

    }
}
