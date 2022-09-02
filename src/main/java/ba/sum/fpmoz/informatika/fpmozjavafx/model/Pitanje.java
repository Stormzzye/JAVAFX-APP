package ba.sum.fpmoz.informatika.fpmozjavafx.model;

public class Pitanje extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size = 100)
    String tekst_pit;

    @ForeignKey(table= "Test", attribute ="id")
    @Entity(type = "INTEGER", size = 32)
    int testFk;

}
