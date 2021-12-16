package aval3.decorator;

public class CapaDura extends LivroDecorator {
	
	public CapaDura(Pedido pedido) {
		super("CAPA DURA",pedido);
	}
	
	public double getPreco() {
		return pedido.getPreco()*1.2;
	}

}
