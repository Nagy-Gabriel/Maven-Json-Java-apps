package exemplul2;
public class Calculator {
    private final int a;
    private final int b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int suma() {
        return a + b;
    }
}