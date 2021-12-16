package aval3.decorator;

public class Colorida extends LivroDecorator {
	
	public Colorida(Pedido pedido) {
		super("COLORIDA",pedido);
	}
	
	public double getPreco() {
		return pedido.getPreco()*1.05;
	}

}