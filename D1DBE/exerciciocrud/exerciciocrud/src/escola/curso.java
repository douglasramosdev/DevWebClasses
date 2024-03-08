package escola;

import java.sql.Date;

public class curso {
  private int cdCurso;
  private String nomeCurso;
  private char descricaoCurso;
  private Date dataInicio;
  private Date dataFinal;
  
  public int getCdcurso(){
    return cdCurso;
  }
  public void setCdcurso(int cdCurso){
    this.cdCurso = cdCurso;
  }
  public String getNomecurso(){
    return nomeCurso;
  }
  public void setNomeurso(String nomeCurso){
    this.nomeCurso = nomeCurso;
  }
  public char getDescricaocurso(){
    return descricaoCurso;
  }
  public void setDescricaocurso(char descricaoCurso){
    this.descricaoCurso = descricaoCurso;
  }
  public Date getDatainicio(){
    return dataInicio;
  }
  public void setDatainicio(Date dataInicio){
    this.dataInicio = dataInicio;
  }
  public Date getDatafinal(){
    return dataFinal;
  }
  public void setDatafinal(Date dataFinal){
    this.dataFinal = dataFinal;
  }
}
