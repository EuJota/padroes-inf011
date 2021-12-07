package observer;

public class StateCheckpointObserver implements StateObserver {

    // envio de notificacao
    @Override
    public void notifyStateChanged(Evento event) {
        factory.Factory factory = new factory.Factory();
        factory.enviaNotificacao(event);
    }
}
