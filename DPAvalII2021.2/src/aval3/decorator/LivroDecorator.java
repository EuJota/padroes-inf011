package aval3.decorator;

public abstract class LivroDecorator implements Pedido{
	
	protected Pedido pedido;
	protected String label;
	
	public LivroDecorator (String label,Pedido pedido) {
		this.pedido=pedido;
		this.label=label;
	}
	
	
	public abstract double getPreco();
	
	public String toString() {
		return pedido.toString()+" - "+this.label;
	}

}
