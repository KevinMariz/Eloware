package org.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;

public class Funcionario extends Pessoa{

    BigDecimal salario;
    String funcao;

    public Funcionario(){

    }

    public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
        super(nome, data_nascimento);
        setSalario(salario);
        setFuncao(funcao);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", data_nascimento=" + getData_nascimento_String() + '\'' +
                ", salario=" + getSalario_String() + '\'' +
                ", funcao='" + getFuncao() +
                '}';
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getSalario_String() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(salario);
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
