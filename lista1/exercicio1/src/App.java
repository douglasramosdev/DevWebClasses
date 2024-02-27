
public class App {
    public static void main(String[] args) throws Exception {
        String nomeCliente = "Douglas";
        String enderecoCliente = "Torvalds, 123";
        float valorCompra = 12345.99f;
        String dataEntrega = "26/02/2024";

        System.out.println("                        AVISO");
        System.out.println("Caro cliente Sr(a): " + nomeCliente + " os produtos da sua compra no");
        System.out.println("valor de: R$" + valorCompra + " serao entregues no endereco abaixo:");
        System.out.println("R: " + enderecoCliente + ".");
        System.out.println("Data de entrega: "+ dataEntrega);
        System.out.println("************* OBRIGADO PELA PREFERENCIA! *************");
    }
}

