package observer;

public class StateCheckpointObserver implements StateObserver {

    @Override
    public void notifyStateChanged(Evento event) {
        factory.Factory factory = new factory.Factory();
        factory.enviaNotificacao(event);
    }
}
