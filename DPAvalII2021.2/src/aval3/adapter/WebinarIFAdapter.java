package aval3.adapter;

import aval3.Disciplina;

public class WebinarIFAdapter extends Disciplina {

    private WebinarIF webinar;

    public WebinarIFAdapter(WebinarIF webinar){
        super(webinar.getId(),webinar.getTitle());
        this.webinar = webinar;
    }

    @Override
    public double getPreco() {
        return this.webinar.getPrice();
    }

    @Override
    public int getCHTotal() {
        return (int) Math.ceil(this.webinar.getMinutes()/60);
    }

    @Override
    public double getPctCumprido() {
        if (this.webinar.wasWatched())
            return 1;
        else
            return 0;
    }

    @Override
    public void avancar(double pct) {
        if(pct <= 0)	return;
        this.webinar.play();
    }

}