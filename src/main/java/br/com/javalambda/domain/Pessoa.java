package br.com.javalambda.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Pessoa {

  private String nome;
  private String cidadeOndeEstaFalando;
  private Integer idade;
}