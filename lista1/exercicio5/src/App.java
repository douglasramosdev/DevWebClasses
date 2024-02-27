import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        int tabuada;
        System.out.println("Digite o valor de x:");
        x = scanner.nextInt();
        System.out.println("Digite o valor de y: ");
        y = scanner.nextInt();
        System.out.println("\n");

        if (x == y){
            System.out.println("Digite dois valores diferentes um do outro!!");
        }else{
            for (int i = x ; x <= y; x++){
                for(int j = 1; j <=10; j++){
                    tabuada = x * j;
                    System.out.println(tabuada);
                    System.out.println("\n");
                }
            }
        }
    }
}
