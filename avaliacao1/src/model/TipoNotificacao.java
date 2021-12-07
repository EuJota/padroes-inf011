package model;

public enum TipoNotificacao {

    EMAIL("email"), WHATSAPP("wpp"), LIGACAO("ligacao");

    private String nomeTipo;

    private TipoNotificacao(String nomeTipo) {
        nomeTipo = nomeTipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

}
