package br.com.senai.crudmysqlspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Usuario {

  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private String nome;
  private String email;
  private String telefone;
  private String genero;
  private String data_cadastro;
  private String senha;
  private boolean verificado;

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String genero() {
    return genero;
  }

  public String getData_cadastro() {
    return data_cadastro;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getSenha() {
    return senha;
  }

  public boolean getVerificado() {
    return verificado;
  }

}
