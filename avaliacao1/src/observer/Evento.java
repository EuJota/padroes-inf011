package observer;

import model.Disciplina;
import model.TipoNotificacao;

import java.util.List;

public class Evento {
    private String descricao;
    private List<TipoNotificacao> tiposNotificacao;
    private List<Disciplina> disciplinas;

    public Evento(String descricao, List<TipoNotificacao> tiposNotificacao, List<Disciplina> disciplinas) {
        this.descricao = descricao;
        this.tiposNotificacao = tiposNotificacao;
        this.disciplinas = disciplinas;
    }

    public List<TipoNotificacao> getTiposNotificacao() {
        return tiposNotificacao;
    }

    public String getDescricao() {
        return descricao;
    }
}
