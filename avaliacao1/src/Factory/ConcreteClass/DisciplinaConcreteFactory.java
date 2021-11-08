package factory.ConcreteClass;

import model.Disciplina;
import model.ProdutoContrato;
import model.Produto;

public class DisciplinaConcreteFactory implements ProdutoContrato {

    @Override
    public Produto criarProduto(String nome, String codigo) {
        Disciplina disciplina = new Disciplina();

        disciplina.setNome(nome);
        disciplina.setCodigo(codigo);
        disciplina.setChTotal(200);
        disciplina.setPreco(200.00);
        disciplina.setPctCumprido(0);


        return disciplina;
    }
}