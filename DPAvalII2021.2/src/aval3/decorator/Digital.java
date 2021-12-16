package aval3.decorator;

public class Digital extends LivroDecorator {

	public Digital(Pedido pedido) {
		super("DIGITAL",pedido);
	}
	
	public double getPreco() {
		return pedido.getPreco()*0.85;
	}

}
