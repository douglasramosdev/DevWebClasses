    class obj {
    

    private static boolean ehPrimo(int numero) {
        
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int contaPrimos(int inicio, int fim) {
        int quantidadePrimos = 0;
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                quantidadePrimos++;
            }
        }
        return quantidadePrimos;
    }

    public static void main(String[] args) {
        int x = obj.contaPrimos(5, 20);
        System.out.println("Quantidade de números primos de 5 até 20: " + x);
    }
}
