import java.util.Scanner;
import java.util.regex.Pattern;

class ValidadorCPF {

    public static boolean validaCPF(String cpf) {

        cpf = cpf.replaceAll("\\D+", "");

        if (!cpf.matches("\\d{11}") || cpf.matches(cpf.charAt(0) + "{11}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int primeiroDigito = (resto < 2) ? 0 : 11 - resto;
        if (primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int segundoDigito = (resto < 2) ? 0 : 11 - resto;
        if (segundoDigito != Character.getNumericValue(cpf.charAt(10))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF (com ou sem pontuação):");
        String cpf = scanner.nextLine();

        boolean cpfValido = validaCPF(cpf);
        if (cpfValido) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }

        scanner.close();
    }
}
