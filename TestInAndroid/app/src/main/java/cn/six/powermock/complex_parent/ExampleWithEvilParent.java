package cn.six.powermock.complex_parent;

public class ExampleWithEvilParent extends EvilParent {

    private final String message;

    public ExampleWithEvilParent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
