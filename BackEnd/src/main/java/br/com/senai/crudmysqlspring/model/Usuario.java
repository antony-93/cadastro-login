package br.com.senai.crudmysqlspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private String telefone;
  private String genero;
  private String data_cadastro;
  private String senha;
  private boolean verificado;

  public void setId(Long id){
    this.id = id;
  }

  public Long getId(){
    return id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome(){
    return nome;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getEmail(){
    return email;
  }

  public void setGenero(String genero){
    this.genero = genero;
  }

  public String genero(){
    return genero;
  }

  public void setData_cadastro(String data_cadastro){
    this.data_cadastro = data_cadastro;
  }

  public String getData_cadastro(){
    return data_cadastro;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }

  public String getTelefone(){
    return telefone;
  }

  public void setSenha(String senha){
    this.senha = senha;
  }

  public String getSenha(){
    return senha;
  }

  public void setVerificado(boolean verificado){
    this.verificado = verificado;
  }

  public boolean getVerificado(){
    return verificado;
  }

}
