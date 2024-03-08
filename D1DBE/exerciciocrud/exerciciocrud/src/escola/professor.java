package escola;

import java.sql.Date;

public class professor {
  private int idProfessor;
  private String nomeProfessor;
  private String disciplina;
  private char emailProfessor;
  private char telefoneProfessor;
  
  public int getIdprofessor(){
    return idProfessor;
  }
  public void setIdprofessor(int idProfessor){
    this.idProfessor = idProfessor;
  }
  public String getNomeprofessor(){
    return nomeProfessor;
  }
  public void setNomeprofessor(String nomeProfessor){
    this.nomeProfessor = nomeProfessor;
  }
  public String getDisciplina(){
    return disciplina;
  }
  public void setDisciplina(String disciplina){
    this.disciplina = disciplina;
  }
  public char getEmailprofessor(){
    return emailProfessor;
  }
  public void setEmailprofessor(char emailProfessor){
    this.emailProfessor = emailProfessor;
  }
  public char getTelefoneprofessor(){
    return telefoneProfessor;
  }
  public void setTelefoneprofessor(char telefoneProfessor){
    this.telefoneProfessor = telefoneProfessor;
  }
}
