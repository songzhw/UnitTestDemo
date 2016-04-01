package ca.six.test.model;

/**
 * Created by songzhw on 2016/4/1.
 */
public class User {
    public String name;
    public String location;
    public int public_repos;

    @Override
    public String toString() {
        return "User{" +
                "public_repos=" + public_repos +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
