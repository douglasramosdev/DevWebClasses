package escola;

import java.sql.Date;

public class aluno {
  private int ra;
  private String nome;
  private int idade;
  private char endereco;
  private Date dataMatricula;
  
  public int getRa(){
    return ra;
  }
  public void setRA(int ra){
    this.ra = ra;
  }
  public String getNome(){
    return nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  public int getIdade(){
    return idade;
  }
  public void setIdade(int idade){
    this.idade = idade;
  }
  public char getEndereco(){
    return endereco;
  }
  public void setEndereco(char endereco){
    this.endereco = endereco;
  }
  public Date getData(){
    return dataMatricula;
  }
  public void setData(Date dataMatricula){
    this.dataMatricula = dataMatricula;
  }

}
