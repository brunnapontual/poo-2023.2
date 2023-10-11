package br.gov.cesarschool.poo.bonusvendas.negocio;

public class VendedorMediator {

    private static VendedorMediator instance;

    private VendedorDAO repositorioVendedor;
    private AcumuloResgateMediator caixaDeBonusMediator;

    private VendedorMediator() {
        repositorioVendedor = new VendedorDAO();
        caixaDeBonusMediator = AcumuloResgateMediator.getInstance();
    }

    public static VendedorMediator getInstance() {
        if (instance == null) {
            instance = new VendedorMediator();
        }

        return instance;
    }

    public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
        String mensagemErro = validar(vendedor);
        if (mensagemErro != null) {
            return new ResultadoInclusaoVendedor(0, mensagemErro);
        }

        long numeroCaixaDeBonus = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
        vendedor.setNumeroCaixaDeBonus(numeroCaixaDeBonus);

        repositorioVendedor.incluir(vendedor);

        return new ResultadoInclusaoVendedor(numeroCaixaDeBonus, null);
    }

    public String alterar(Vendedor vendedor) {
        String mensagemErro = validar(vendedor);
        if (mensagemErro != null) {
            return mensagemErro;
        }

        repositorioVendedor.alterar(vendedor);

        return null;
    }

    private String validar(Vendedor vendedor) {

        if (vendedor.getCpf() == null || vendedor.getCpf().isEmpty()) {
            return "CPF nao informado";
        }

        if (!ValidadorCPF.ehCpfValido(vendedor.getCpf())) {
            return "CPF invalido";
        }

        if (vendedor.getNomeCompleto() == null || vendedor.getNomeCompleto().isEmpty()) {
            return "Nome completo nao informado";
        }

        if (vendedor.getSexo() == null) {
            return "Sexo nao informado";
        }

        if (vendedor.getDataNascimento() == null) {
            return "Data de nascimento nao informada";
        }

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNascimento = vendedor.getDataNascimento();
        if (dataNascimento.isBefore(dataAtual.minusYears(18))) {
            return "Data de nascimento invalida";
        }

        if (vendedor.getRenda() < 0) {
            return "Renda menor que zero";
        }

        if (vendedor.getEndereco() == null) {
            return "Endereco nao informado";
        }

        Endereco endereco = vendedor.getEndereco();

        if (endereco.getLogradouro() == null || endereco.getLogradouro().isEmpty()) {
            return "Logradouro nao informado";
        }
        //Logradouro tem menos de 04 caracteres FALTA IMPLEMENTAR

        if (endereco.getNumero() < 0) {
            return "Numero menor que zero";
        }

        if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
            return "Cidade nao informada";
        }

        if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
            return "Estado nao informado";
        }

        if (endereco.getPais() == null || endereco.getPais().isEmpty()) {
            return "Pais nao informado";
        }

        return null;
    }

    public Vendedor buscar(String cpf) {
        return repositorioVendedor.buscarPorCpf(cpf);
    }
}
