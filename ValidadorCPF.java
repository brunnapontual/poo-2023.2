package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class ValidadorCPF {

    private ValidadorCPF() {
        // Construtor privado
    }

    public static boolean ehCpfValido(String cpf) {
        // Verifica se o cpf tem o formato correto.
        if (cpf.length() != 11 || !cpf.matches("[0-9]+")) {
            return false;
        }

        // Calcula os dois últimos dígitos do cpf.
        int digito1 = calcularDigito(cpf.substring(0, 9));
        int digito2 = calcularDigito(cpf.substring(0, 9) + digito1);

        // Verifica se os dois últimos dígitos do cpf são iguais aos recebidos.
        return cpf.substring(9, 11).equals(String.format("%02d", digito1) + String.format("%02d", digito2));
    }

    private static int calcularDigito(String cpf) {
        int soma = 0;
        for (int i = 0; i < cpf.length() - 1; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
}
