package datagenerator.model.wired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TContainer {
    public List<Thagentarep> get(){

        List<Thagentarep> thagentareps = new ArrayList<Thagentarep>();

        thagentareps.add(new ThagentarepBuilder()
                .setId(1)
                .setGeruwa("abaddater")
                .setIowatendal("sdfs32s")
                .setIskwalterad(true)
                .setTraedsof(44)
                .setSallryzofar(new BigDecimal("100300.00"))
                .setBorneyteDatfa(LocalDate.of(2015,2,20))
                .createThagentarep());

        thagentareps.add(new ThagentarepBuilder()
                .setId(2)
                .setGeruwa("abaddater")
                .setIowatendal("sdfs32s")
                .setIskwalterad(true)
                .setTraedsof(44)
                .setSallryzofar(new BigDecimal("100400.00"))
                .setBorneyteDatfa(LocalDate.of(2015,2,20))
                .createThagentarep());

        thagentareps.add(new ThagentarepBuilder()
                .setId(3)
                .setGeruwa("yaama")
                .setIowatendal("234234")
                .setIskwalterad(true)
                .setTraedsof(423)
                .setSallryzofar(new BigDecimal("10000.30"))
                .setBorneyteDatfa(LocalDate.of(2014,1,24))
                .createThagentarep());

        thagentareps.add(new ThagentarepBuilder()
                .setId(4)
                .setGeruwa("tesee23")
                .setIowatendal("sdsewe2s")
                .setIskwalterad(false)
                .setTraedsof(33)
                .setSallryzofar(new BigDecimal("1003200.00"))
                .setBorneyteDatfa(LocalDate.of(2013,12,23))
                .createThagentarep());

        thagentareps.add(new ThagentarepBuilder()
                .setId(5)
                .setGeruwa("GGadkedkkl")
                .setIowatendal("sdfs32s")
                .setIskwalterad(true)
                .setTraedsof(42)
                .setSallryzofar(new BigDecimal("340000.00"))
                .setBorneyteDatfa(LocalDate.of(2017,2,28))
                .createThagentarep());

        thagentareps.add(new ThagentarepBuilder()
                .setId(6)
                .setGeruwa("AAAabaddater")
                .setIowatendal("sdfs3sfwe2s33")
                .setIskwalterad(true)
                .setTraedsof(12)
                .setSallryzofar(new BigDecimal("4140000.00"))
                .setBorneyteDatfa(LocalDate.of(2016,5,27))
                .createThagentarep());

        thagentareps.add(new ThagentarepBuilder()
                .setId(7)
                .setGeruwa("SFWEWE")
                .setIowatendal("sdfs3sdf2s")
                .setIskwalterad(true)
                .setTraedsof(88)
                .setSallryzofar(new BigDecimal("510000.00"))
                .setBorneyteDatfa(LocalDate.of(2018,2,26))
                .createThagentarep());

        thagentareps.add(new ThagentarepBuilder()
                .setId(8)
                .setGeruwa("abadWEWERWr")
                .setIowatendal("sdfs32s")
                .setIskwalterad(true)
                .setTraedsof(46)
                .setSallryzofar(new BigDecimal("6410000.00"))
                .setBorneyteDatfa(LocalDate.of(2019,8,21))
                .createThagentarep());

        return thagentareps;
    }
}