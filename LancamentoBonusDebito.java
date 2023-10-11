package br.gov.cesarschool.poo.bonusvendas.entidade;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import java.time.LocalDateTime;

public class LancamentoBonusDebito extends LancamentoBonus {

    private TipoResgate tipoResgate;

    public LancamentoBonusDebito(long numero, double valor, LocalDateTime dataHoraAtualizacao, TipoResgate tipoResgate) {
        super(numero, (int) valor, dataHoraAtualizacao);
        this.tipoResgate = tipoResgate;
    }

    public TipoResgate getTipoResgate() {
        return tipoResgate;
    }
}