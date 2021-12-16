package aval3.adapter;

public interface WebinarIF {
    String getId();
    String getTitle();
    double getPrice();
    long getMinutes();
    boolean wasWatched();
    void play();
}
