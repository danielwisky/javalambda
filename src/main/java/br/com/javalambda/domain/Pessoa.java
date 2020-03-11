package br.com.javalambda.domain;

import lombok.Data;

@Data
public class Pessoa {

  private String nome;
  private String cidadeOndeEstaFalando;
  private Integer idade;
}