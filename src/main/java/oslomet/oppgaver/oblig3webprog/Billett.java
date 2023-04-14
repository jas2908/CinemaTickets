package oslomet.oppgaver.oblig3webprog;

public class Billett {
    private String kino;
    private String antall;
    private String fornavn;
    private String etternavn;
    private String telefonnr;
    private String epost;

    public Billett(String kino, String antall, String fornavn, String etternavn, String telefonnr, String epost) {
        this.kino = kino;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }

    public Billett(){}

    public String getKino() {
        return kino;
    }

    public void setKino(String kino) {
        this.kino = kino;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}

