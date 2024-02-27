public class App {
    public static void main(String[] args) throws Exception {
        float pesoKg = 127;
        float alturaMetro = 1.85f;
        float imc = pesoKg / (alturaMetro * alturaMetro);
        if(imc < 16.5){
            System.out.println("Resultado IMC: " + imc );
            System.out.println("Desnutrição");
        }else if ((imc > 16.6) & (imc < 18.5)){
            System.out.println("Resultado IMC: " + imc );
            System.out.println("Abaixo do peso");
        }else if ((imc > 18.6) & (imc <24.9)){
            System.out.println("Resultado IMC: " + imc );
            System.out.println("Peso normal");
        }else if ((imc > 25) & (imc < 29.9 )){
            System.out.println("Resultado IMC: " + imc );
            System.out.println("Sobrepeso");
        }else{
            System.out.println("Resultado IMC: " + imc );
            System.out.println("Obesidade");
        }
    }
}
