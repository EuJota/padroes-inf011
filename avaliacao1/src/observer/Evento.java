package observer;

import model.Disciplina;
import model.TipoNotificacao;

import java.util.List;

public class Evento {
    private String de;
    private String para;
    private List<TipoNotificacao> tiposNotificacao;
    private List<Disciplina> disciplinas;

    Evento(String de, String para, List<TipoNotificacao> tiposNotificacao, List<Disciplina> disciplinas) {
        this.de = de;
        this.para = para;
        this.tiposNotificacao = tiposNotificacao;
        this.disciplinas = disciplinas;
    }

    public List<TipoNotificacao> getTiposNotificacao() {
        return tiposNotificacao;
    }

    public String getDe() {
        return de;
    }

    public String getPara() {
        return para;
    }
}
