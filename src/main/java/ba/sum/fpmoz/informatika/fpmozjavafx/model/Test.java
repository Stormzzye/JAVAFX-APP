package ba.sum.fpmoz.informatika.fpmozjavafx.model;

public class Test extends Table {
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size = 50)
    String naziv_testa;

    @Entity(type = "VARCHAR", size = 100)
    String pocetak_date;

    @Entity(type = "VARCHAR", size = 100)
    String kraj_date;

    @Entity(type = "VARCHAR", size = 50)
    String ime_datoteke;

    @ForeignKey(table= "Kolegij", attribute ="id")
    @Entity(type = "INTEGER", size = 32)
    int kolegijFk;

    public int getId() {
        return id;
    }

    public String getNaziv_testa() {
        return naziv_testa;
    }

    public void setNaziv_testa(String naziv_testa) {
        this.naziv_testa = naziv_testa;
    }

    public String getPocetak_date() {
        return pocetak_date;
    }

    public void setPocetak_date(String pocetak_date) {
        this.pocetak_date = pocetak_date;
    }

    public String getKraj_date() {
        return kraj_date;
    }

    public void setKraj_date(String kraj_date) {
        this.kraj_date = kraj_date;
    }

    public String getIme_datoteke() {
        return ime_datoteke;
    }

    public void setIme_datoteke(String ime_datoteke) {
        this.ime_datoteke = ime_datoteke;
    }

    public int getKolegijFk() {
        return kolegijFk;
    }

    public void setKolegijFk(int kolegijFk) {
        this.kolegijFk = kolegijFk;
    }
}


