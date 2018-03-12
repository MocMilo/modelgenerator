package datagenerator.model.wired;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Thagentarep {

    private long id;
    private String geruwa;
    private int traedsof;
    private String iowatendal;
    private boolean iskwalterad;
    private BigDecimal sallryzofar;
    private LocalDate borneyteDatfa;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGeruwa() {
        return geruwa;
    }

    public void setGeruwa(String geruwa) {
        this.geruwa = geruwa;
    }

    public int getTraedsof() {
        return traedsof;
    }

    public void setTraedsof(int traedsof) {
        this.traedsof = traedsof;
    }

    public String getIowatendal() {
        return iowatendal;
    }

    public void setIowatendal(String iowatendal) {
        this.iowatendal = iowatendal;
    }

    public boolean isIskwalterad() {
        return iskwalterad;
    }

    public void setIskwalterad(boolean iskwalterad) {
        this.iskwalterad = iskwalterad;
    }

    public BigDecimal getSallryzofar() {
        return sallryzofar;
    }

    public void setSallryzofar(BigDecimal sallryzofar) {
        this.sallryzofar = sallryzofar;
    }

    public LocalDate getBorneyteDatfa() {
        return borneyteDatfa;
    }

    public void setBorneyteDatfa(LocalDate borneyteDatfa) {
        this.borneyteDatfa = borneyteDatfa;
    }

    public Thagentarep(long id, String geruwa, int traedsof, String iowatendal, boolean iskwalterad, BigDecimal sallryzofar, LocalDate borneyteDatfa) {
        this.id = id;
        this.geruwa = geruwa;
        this.traedsof = traedsof;
        this.iowatendal = iowatendal;
        this.iskwalterad = iskwalterad;
        this.sallryzofar = sallryzofar;
        this.borneyteDatfa = borneyteDatfa;
    }
}
