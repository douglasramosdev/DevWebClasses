import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        
        System.out.println("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        
        System.out.println("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        
        System.out.println("Soma: " + calculadora.soma(num1, num2));
        System.out.println("Subtração: " + calculadora.subtracao(num1, num2));
        System.out.println("Multiplicação: " + calculadora.multiplicacao(num1, num2));
        System.out.println("Radiciação (primeiro número): " + calculadora.radiciacao(num1));
        System.out.println("Radiciação (segundo número): " + calculadora.radiciacao(num2));
        
        if(num1 >= 0 && (int)num1 == num1) {
            System.out.println("Fatorial do primeiro número: " + calculadora.fatorial((int)num1));
        } else {
            System.out.println("Fatorial não definido para números não inteiros ou negativos (primeiro número).");
        }
        
        if(num2 >= 0 && (int)num2 == num2) {
            System.out.println("Fatorial do segundo número: " + calculadora.fatorial((int)num2));
        } else {
            System.out.println("Fatorial não definido para números não inteiros ou negativos (segundo número).");
        }
        
        scanner.close();
    }
}

class Calculadora {
    
    public double soma(double a, double b) {
        return a + b;
    }
    
    public double subtracao(double a, double b) {
        return a - b;
    }
    
    public double multiplicacao(double a, double b) {
        return a * b;
    }
    
    public double radiciacao(double a) {
        return Math.sqrt(a);
    }
    
    public long fatorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }
}

