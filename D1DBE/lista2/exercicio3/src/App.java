import java.util.Scanner;

class CalculadoraFormasDinamica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe os valores (separados por espaço). Para coordenadas, use o formato x,y x,y x,y. Digite 'sair' para encerrar:");

        while(true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            String[] parts = input.split(" ");
            try {
                if (parts.length == 1) {
                    double raio = Double.parseDouble(parts[0]);
                    System.out.println("Área do círculo: " + calcularCirculo(raio));
                } else if (parts.length == 2) {
                    double lado1 = Double.parseDouble(parts[0]);
                    double lado2 = Double.parseDouble(parts[1]);
                    System.out.println("Área do quadrado: " + calcularQuadrado(lado1, lado2));
                } else if (parts.length == 3 && parts[0].contains(",")) {
                    // Assume coordenadas no formato "x,y"
                    double[][] pontos = new double[3][2];
                    for (int i = 0; i < 3; i++) {
                        String[] coordenadas = parts[i].split(",");
                        pontos[i][0] = Double.parseDouble(coordenadas[0]);
                        pontos[i][1] = Double.parseDouble(coordenadas[1]);
                    }
                    System.out.println("Área do triângulo (coordenadas): " + calcularAreaTriangulo(pontos));
                } else if (parts.length == 3) {
                    int lado1 = Integer.parseInt(parts[0]);
                    int lado2 = Integer.parseInt(parts[1]);
                    int lado3 = Integer.parseInt(parts[2]);
                    System.out.println("Perímetro do triângulo: " + calcularPerimetroTriangulo(lado1, lado2, lado3));
                } else if (parts.length == 2) {
                    int base = Integer.parseInt(parts[0]);
                    double altura = Double.parseDouble(parts[1]);
                    System.out.println("Área do triângulo: " + calcularAreaTriangulo(base, altura));
                } else {
                    System.out.println("Uso incorreto.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Uso incorreto.");
            }
        }

        scanner.close();
    }

    private static double calcularCirculo(double raio) {
        return Math.PI * raio * raio;
    }

    private static double calcularQuadrado(double lado1, double lado2) {
        return lado1 * lado2;
    }

    private static double calcularPerimetroTriangulo(int lado1, int lado2, int lado3) {
        return lado1 + lado2 + lado3;
    }

    private static double calcularAreaTriangulo(int base, double altura) {
        return (base * altura) / 2;
    }

    private static double calcularAreaTriangulo(double[][] pontos) {
        double ladoA = distanciaEntrePontos(pontos[0], pontos[1]);
        double ladoB = distanciaEntrePontos(pontos[1], pontos[2]);
        double ladoC = distanciaEntrePontos(pontos[2], pontos[0]);
        double s = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
    }

    private static double distanciaEntrePontos(double[] ponto1, double[] ponto2) {
        return Math.sqrt(Math.pow(ponto2[0] - ponto1[0], 2) + Math.pow(ponto2[1] - ponto1[1], 2));
    }
}

