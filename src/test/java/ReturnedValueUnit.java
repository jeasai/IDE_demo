import org.testng.annotations.Test;

public class ReturnedValueUnit {
    @Test
    public void testHelloWorld() {
        String hello_world = ReturnedValue.helloWorld();
        assert hello_world.equals("Hello, World!");
    }

    public void simpleTest() {
        assert true;
    }
}
