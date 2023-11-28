package br.gov.cesarschool.poo.bonusvendas.tela;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;

import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TelaAcumuloResgate {

	protected Shell shell;
	private Text textNumeroCaixaDeBonus;
	private Text textSaldoAtual;
	private Text textValor;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaAcumuloResgate window = new TelaAcumuloResgate();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private AcumuloResgateMediator mediator = AcumuloResgateMediator.getInstancia();
	private CaixaDeBonusDAO repositorioCaixaBonus;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(394, 420);
		shell.setText("SWT Application");
		
		textNumeroCaixaDeBonus = new Text(shell, SWT.BORDER);
		textNumeroCaixaDeBonus.setBounds(10, 32, 153, 21);
		
		Label lblNmeroDaCaixa = new Label(shell, SWT.NONE);
		lblNmeroDaCaixa.setBounds(10, 11, 153, 15);
		lblNmeroDaCaixa.setText("Número da caixa de bônus:");
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.setBounds(293, 30, 75, 25);
		btnBuscar.setText("Buscar");
		
		textSaldoAtual = new Text(shell, SWT.BORDER);
		textSaldoAtual.setEnabled(false);
		textSaldoAtual.setBounds(10, 163, 153, 21);
		
		Label lblSaldoAtual = new Label(shell, SWT.NONE);
		lblSaldoAtual.setEnabled(false);
		lblSaldoAtual.setBounds(10, 136, 153, 15);
		lblSaldoAtual.setText("Saldo Atual:");
		
		Label lblOperacao = new Label(shell, SWT.NONE);
		lblOperacao.setBounds(10, 72, 55, 15);
		lblOperacao.setText("Operação:");
		
		Button btnAcumulo = new Button(shell, SWT.RADIO);
		btnAcumulo.setBounds(10, 98, 75, 16);
		btnAcumulo.setText("Acumulo");
		
		Button btnResgate = new Button(shell, SWT.RADIO);
		btnResgate.setBounds(106, 98, 90, 16);
		btnResgate.setText("Resgate");
		
		Label lblTipoDeResgate = new Label(shell, SWT.NONE);
		lblTipoDeResgate.setEnabled(false);
		lblTipoDeResgate.setBounds(10, 213, 153, 15);
		lblTipoDeResgate.setText("Tipo de Resgate:");
		
		textValor = new Text(shell, SWT.BORDER);
		textValor.setEnabled(false);
		textValor.setBounds(10, 309, 154, 21);
		
		Label lblValor = new Label(shell, SWT.NONE);
		lblValor.setEnabled(false);
		lblValor.setBounds(10, 284, 55, 15);
		lblValor.setText("Valor:");
		
		Button btnVoltar = new Button(shell, SWT.NONE);
		btnVoltar.setEnabled(false);
		btnVoltar.setBounds(10, 346, 75, 25);
		btnVoltar.setText("Voltar");
		
		Button btnAcumularresgatar = new Button(shell, SWT.NONE);
		btnAcumularresgatar.setEnabled(false);
		btnAcumularresgatar.setBounds(236, 346, 132, 25);
		btnAcumularresgatar.setText("Acumular/Resgatar");
		
		Combo comboTipoResgate = new Combo(shell, SWT.NONE);
		comboTipoResgate.setEnabled(false);
		comboTipoResgate.setItems(new String[] {"Produto", "Serviço", "Cash"});
		comboTipoResgate.setBounds(10, 240, 91, 23);
		
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				long numeroCaixaDeBonus = Long.parseLong(textNumeroCaixaDeBonus.getText());
				CaixaDeBonus caixa = mediator.buscarCaixaDeBonus(numeroCaixaDeBonus);
				if(caixa != null && (btnAcumulo.getSelection() != false || btnResgate.getSelection() != false)) {
					textNumeroCaixaDeBonus.setEnabled(false);
					lblNmeroDaCaixa.setEnabled(false);
					btnBuscar.setEnabled(false);
					lblOperacao.setEnabled(false);
					btnAcumulo.setEnabled(false);
					btnResgate.setEnabled(false);
					if(btnAcumulo.getSelection() == true) {
						btnAcumularresgatar.setText("Acumular");
					}else if(btnResgate.getSelection() == true) {
						btnAcumularresgatar.setText("Resgatar");
						lblTipoDeResgate.setEnabled(true);
						comboTipoResgate.setEnabled(true);
					}
					lblSaldoAtual.setEnabled(true);
					textSaldoAtual.setText("" + caixa.getSaldo());
					lblValor.setEnabled(true);
					textValor.setEnabled(true);
					btnVoltar.setEnabled(true);
					btnAcumularresgatar.setEnabled(true);
				}else if(caixa == null) {
					mostrarMensagemErro("Erro: Caixa de bonus inexistente!");
				}else {
					mostrarMensagemErro("Selecione uma operação!");
				}
				
			}
		});
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				textNumeroCaixaDeBonus.setText("");
				textNumeroCaixaDeBonus.setEnabled(true);
				lblNmeroDaCaixa.setEnabled(true);
				btnBuscar.setEnabled(true);
				lblOperacao.setEnabled(true);
				btnAcumulo.setSelection(false);
				btnAcumulo.setEnabled(true);
				btnResgate.setSelection(false);
				btnResgate.setEnabled(true);
				comboTipoResgate.deselect(0);
				comboTipoResgate.deselect(1);
				comboTipoResgate.deselect(2);
				comboTipoResgate.setEnabled(false);
				textSaldoAtual.setText("");
				lblSaldoAtual.setEnabled(false);
				lblValor.setEnabled(false);
				textValor.setText("");
				textValor.setEnabled(false);
				btnVoltar.setEnabled(false);
				btnAcumularresgatar.setText("Acumular/Resgatar");
				btnAcumularresgatar.setEnabled(false);
			}
		});
		
		btnAcumularresgatar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String stringValor = textValor.getText();
				if (!stringValor.matches("\\d+\\.\\d+")) {
			        mostrarMensagemErro("Formato do campo Valor inválido!");
			        return;
			    }
				long numeroCaixaDeBonus = Long.parseLong(textNumeroCaixaDeBonus.getText());
				double valor = Double.parseDouble(textValor.getText());
				String mensagemSucesso = null;
				String retorno = null;
				
				if(btnAcumularresgatar.getText() == "Acumular") {
					retorno = mediator.acumularBonus(numeroCaixaDeBonus, valor);
					mensagemSucesso = "Valor acumulado com Sucesso!";
				}else {
					String selectedText = comboTipoResgate.getText();
                    TipoResgate tipoResgate = Arrays.stream(TipoResgate.values())
                                                    .filter(t -> t.getDescricao().equals(selectedText))
                                                    .findFirst()
                                                    .orElse(null);
                    if(tipoResgate == null) {
                    	mostrarMensagemErro("Selecione um tipo de resgate!");
                    	mensagemSucesso = "";
                    	return;
                    }else {                    	
                    	retorno = mediator.resgatar(numeroCaixaDeBonus, valor, tipoResgate);
                    	mensagemSucesso = "Valor retirado com Sucesso!";
                    }
				}
				if(retorno != null) {
					mostrarMensagemErro(retorno);
					return;
				}else {					
					MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
					messageBox.setMessage(mensagemSucesso);
					messageBox.open();
				}
				btnVoltar.notifyListeners(SWT.MouseDown, new Event());
				
			}
		});

	}
	
	private void mostrarMensagemErro(String mensagem) {
	    MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
	    messageBox.setMessage(mensagem);
	    messageBox.open();
	}
}