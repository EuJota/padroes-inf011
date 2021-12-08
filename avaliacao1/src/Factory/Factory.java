package factory;
import factory.ConcreteClass.DisciplinaConcreteFactory;
import factory.ConcreteClass.LivroConcreteFactory;
import model.*;
import observer.Evento;

import java.util.List;

public class Factory {
   public Produto criarProduto(String nome, String codigo, TipoProduto tipo) {
       if (tipo == TipoProduto.DISCIPLINA) {
           return new DisciplinaConcreteFactory().criarProduto(nome, codigo);
       }
       return new LivroConcreteFactory().criarProduto(nome, codigo);
   }


   // TODO -> criar classes para cada tipo e so colocar o print dentro de cada classe ....
    /**
     * envio de e-mail, envio de SMS,
     * etc. Implemente um destes mecanismos, que faça a notificação da ocorrência / restauração do
     * checkpoint, indicando o percentual de conclusão (ou a CH concluída) de cada disciplina do curso
     * após a operação.
     *
     */

    public void enviaNotificacao(Evento evento) {
       evento.getTiposNotificacao().forEach( opcao -> {
           switch (opcao) {
               case EMAIL: System.out.println("Enviando email de evento " +evento.getDescricao());
                    break;
               case WHATSAPP: System.out.println("Enviando mensagem");
                   break;
               case LIGACAO: System.out.println("Ligando");
                   break;
           }
       });
   }
}
