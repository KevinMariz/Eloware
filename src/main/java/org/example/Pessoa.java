package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    String nome;

    LocalDate data_nascimento;

    public Pessoa() {

    }

    public Pessoa(String nome, LocalDate data_nascimento) {
        setNome(nome);
        setData_nascimento(data_nascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public String getData_nascimento_String(){
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = this.data_nascimento.format(formatar);
        return data;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
