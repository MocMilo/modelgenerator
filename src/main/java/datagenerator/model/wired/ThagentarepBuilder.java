package datagenerator.model.wired;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ThagentarepBuilder {
    private long id;
    private String geruwa;
    private int traedsof;
    private String iowatendal;
    private boolean iskwalterad;
    private BigDecimal sallryzofar;
    private LocalDate borneyteDatfa;

    public ThagentarepBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public ThagentarepBuilder setGeruwa(String geruwa) {
        this.geruwa = geruwa;
        return this;
    }

    public ThagentarepBuilder setTraedsof(int traedsof) {
        this.traedsof = traedsof;
        return this;
    }

    public ThagentarepBuilder setIowatendal(String iowatendal) {
        this.iowatendal = iowatendal;
        return this;
    }

    public ThagentarepBuilder setIskwalterad(boolean iskwalterad) {
        this.iskwalterad = iskwalterad;
        return this;
    }

    public ThagentarepBuilder setSallryzofar(BigDecimal sallryzofar) {
        this.sallryzofar = sallryzofar;
        return this;
    }

    public ThagentarepBuilder setBorneyteDatfa(LocalDate borneyteDatfa) {
        this.borneyteDatfa = borneyteDatfa;
        return this;
    }

    public Thagentarep createThagentarep() {
        return new Thagentarep(id, geruwa, traedsof, iowatendal, iskwalterad, sallryzofar, borneyteDatfa);
    }
}