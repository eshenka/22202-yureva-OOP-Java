package ModelFactory.Details;

abstract public class Detail {
    int id;

    public Detail() {
        this.id = this.hashCode();
    }

    public int getId() {
        return id;
    }
}
