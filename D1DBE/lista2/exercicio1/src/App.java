    class Cliente{
    private String nome;
    private String endereco;
    private String cep;
    private String cpf;

    public Cliente(String nome, String endereco, String cep, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.setCep(cep);
        this.setCpf(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep.matches("\\d{5}-\\d{3}")) {
            this.cep = cep;
        } else {
            System.out.println("CEP inválido.");
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF inválido.");
        }
    }

    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("CEP: " + getCep());
        System.out.println("CPF: " + getCpf());
    }
}

public class App{
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João Silva", "Rua Exemplo, 123", "12345-678", "123.456.789-00");

        cliente.exibirDados();
    }
}
