import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Digite a primeira data no formato DD/MM/AAAA:");
        String primeiraDataString = scanner.nextLine();
        System.out.println("Digite a segunda data no formato DD/MM/AAAA:");
        String segundaDataString = scanner.nextLine();
        
        LocalDate primeiraData = LocalDate.parse(primeiraDataString, formatter);
        LocalDate segundaData = LocalDate.parse(segundaDataString, formatter);
        
        CalculadoraDeDias calculadora = new CalculadoraDeDias();
        long diferencaDias = calculadora.calcularDiferencaDias(primeiraData, segundaData);
        
        System.out.println("A diferença entre as datas é de " + diferencaDias + " dias.");
        
        scanner.close();
    }
}

class CalculadoraDeDias {
    public long calcularDiferencaDias(LocalDate data1, LocalDate data2) {
        return ChronoUnit.DAYS.between(data1, data2);
    }
}
