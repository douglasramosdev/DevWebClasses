import java.util.Scanner;
public class App {
    public class Fatorial{
        public static int fatorial(int num){
            if (num <= 1){
                return 1;
            }else{
                return fatorial(num - 1) * num;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int r;
        System.out.println("Digite um número para fatorar");
        r = scanner.nextInt();
        System.out.println("O fatorial de: " + r + " é " + Fatorial.fatorial(r) + ".");
    }
}
