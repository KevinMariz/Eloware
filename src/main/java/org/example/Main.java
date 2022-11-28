package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.println("3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.");
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente"));

        System.out.println("3.2 – Remover o funcionário “João” da lista.");
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals("João")) {
                funcionarios.remove(i);
            }
        }

        System.out.println("3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:" +
                "• informação de data deve ser exibido no formato dd/MM/aaaa;" +
                "• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }


        System.out.println("3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.");
        for (Funcionario funcionario : funcionarios) {
            funcionario.setSalario(funcionario.salario.multiply(BigDecimal.valueOf(1.1)));
            System.out.println(funcionario.toString());
        }

        System.out.println("3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.");
        Set<String> setFuncao = new HashSet<>();
        Map<String, List<Funcionario>> mapFunc = new HashMap<>();

        Iterator<Funcionario> ii = funcionarios.iterator();
        while (ii.hasNext()){
            setFuncao.add(ii.next().getFuncao());
        }

        for (String funcao : setFuncao) {
            List<Funcionario> listFunc = new ArrayList<>();
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getFuncao().equals(funcao)) {
                    listFunc.add(funcionario);
                }
            }
            mapFunc.put(funcao, listFunc);
        }
        System.out.println(mapFunc);

        System.out.println("3.6 – Imprimir os funcionários, agrupados por função.");
        for (String funcao : setFuncao) {
            int count = 0;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getFuncao() == funcao) {
                    count += 1;
                }
            }
            System.out.println("A Funcao: " + funcao + ", possui: " + count + " funcionarios");
        }

        System.out.println("3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario func_38 = iterator.next();
            if (func_38.getData_nascimento().getMonthValue() == 10 || func_38.getData_nascimento().getMonthValue() == 12) {
                System.out.println(func_38);
            }
        }

        System.out.println("3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
        Funcionario maior = funcionarios.iterator().next();
        for (Funcionario funcionario: funcionarios) {
            if (funcionario.getData_nascimento().isEqual(maior.getData_nascimento())) {
                maior = funcionario;
            } else if (funcionario.getData_nascimento().isAfter(maior.getData_nascimento())) {
                maior = maior;
            } else if (funcionario.getData_nascimento().isBefore(maior.getData_nascimento())){
                maior = funcionario;
            }
        }
        System.out.println("Nome: " + maior.getNome() +" - Nome: " + Period.between(maior.getData_nascimento(), LocalDate.now()).getYears());

        System.out.println("3.10 – Imprimir a lista de funcionários por ordem alfabética.");
        funcionarios.sort(Comparator.comparing(funcionario -> funcionario.getNome()));
        System.out.println(funcionarios);

        System.out.println("3.11 – Imprimir o total dos salários dos funcionários.");
        BigDecimal salarioTotal = BigDecimal.valueOf(0);
        for (Funcionario funcionario: funcionarios) {
            salarioTotal = salarioTotal.add(funcionario.getSalario());
        }
        System.out.println(salarioTotal);

        System.out.println("3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");
        BigDecimal qtdSalrioMinimo;
        for (Funcionario funcionario: funcionarios) {
            qtdSalrioMinimo = funcionario.getSalario().divide(BigDecimal.valueOf(1212),2, RoundingMode.HALF_UP);
            System.out.println("O funcionario: "+ funcionario.getNome() + " - Recebe o total de " + qtdSalrioMinimo + " salarios minimos");
        }

    }
}
