package ca.six.test.model;

public class Repo {
    public long id;
    public String name;
    public int size;

    @Override
    public String toString() {
        return "Repo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}