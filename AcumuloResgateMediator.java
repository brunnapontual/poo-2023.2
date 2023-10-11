package br.gov.cesarschool.poo.bonusvendas.negocio;

public class AcumuloResgateMediator {

    private static AcumuloResgateMediator instance;

    private CaixaDeBonusDAO repositorioCaixaDeBonus;
    private LancamentoBonusDAO repositorioLancamento;

    private AcumuloResgateMediator() {
        repositorioCaixaDeBonus = new CaixaDeBonusDAO();
        repositorioLancamento = new LancamentoBonusDAO();
    }

    public static AcumuloResgateMediator getInstance() {
        if (instance == null) {
            instance = new AcumuloResgateMediator();
        }

        return instance;
    }

    public long gerarCaixaDeBonus(Vendedor vendedor) {
        LocalDateTime dataAtual = LocalDateTime.now();

        String numeroCaixaDeBonus = vendedor.getCpf() +
                String.format("%04d%02d%02d", dataAtual.getYear(), dataAtual.getMonthValue(), dataAtual.getDayOfMonth());

        CaixaDeBonus caixaDeBonus = new CaixaDeBonus();
        caixaDeBonus.setNumero(numeroCaixaDeBonus);
        caixaDeBonus.setSaldo(0.0);

        repositorioCaixaDeBonus.incluir(caixaDeBonus);

        return numeroCaixaDeBonus;
    }

    public String acumularBonus(long numeroCaixaDeBonus, double valor) {
        if (valor <= 0) {
            return "Valor menor ou igual a zero";
        }

        CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscarPorNumero(numeroCaixaDeBonus);
        if (caixaDeBonus == null) {
            return "Caixa de bônus inexistente";
        }

        caixaDeBonus.setSaldo(caixaDeBonus.getSaldo() + valor);
        repositorioCaixaDeBonus.alterar(caixaDeBonus);

        LancamentoBonusCredito lancamentoBonus = new LancamentoBonusCredito();
        lancamentoBonus.setCaixaDeBonus(caixaDeBonus);
        lancamentoBonus.setValor(valor);
        repositorioLancamento.incluir(lancamentoBonus);

        return null;
    }

    public String resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo) {
        if (valor <= 0) {
            return "Valor menor ou igual a zero";
        }

        CaixaDeBonus caixaDeBonus = repositorioCaixaDeBonus.buscarPorNumero(numeroCaixaDeBonus);
        if (caixaDeBonus == null) {
            return "Caixa de bônus não encontrada";
        }

        if (caixaDeBonus.getSaldo() < valor) {
            return "Saldo insuficiente";
        }

        caixaDeBonus.setSaldo(caixaDeBonus.getSaldo() - valor);
        repositorioCaixaDeBonus.alterar(caixaDeBonus);

        LancamentoBonusResgate lancamentoBonus = new LancamentoBonusResgate();
        lancamentoBonus.setCaixaDeBonus(caixaDeBonus);
        lancamentoBonus.setValor(valor);
        lancamentoBonus.setTipoResgate(tipo);
        repositorioLancamento.incluir(lancamentoBonus);

        return null;
    }
}
