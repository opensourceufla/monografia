package lib;
import java.util.Date;


public class Bonus extends Promocao {

	private Date validade;
	private double quantidade;
	private double limiteDiario;

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getLimiteDiario() {
		return limiteDiario;
	}

	public void setLimiteDiario(double limiteDiario) {
		this.limiteDiario = limiteDiario;
	}
	
	
}
