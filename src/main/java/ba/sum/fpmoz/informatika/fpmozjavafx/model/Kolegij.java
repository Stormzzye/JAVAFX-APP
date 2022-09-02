package ba.sum.fpmoz.informatika.fpmozjavafx.model;

public class Kolegij extends Table {
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size = 50)
    String naziv;

    @ForeignKey(table= "User", attribute ="id")
    @Entity(type = "INTEGER", size = 32)
    int userFk;

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getUserFk() {
        return userFk;
    }

    public void setUserFk(int userFk) {
        this.userFk = userFk;
    }
}
