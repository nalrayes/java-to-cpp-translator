package inputs.test016;

class A {
    public void printOther(A other) {
        System.out.println(other.toString());
    }
}

class B extends A {
    public B some;

    public void printOther(A other) {
        System.out.println(other.toString());
        int x;
        int y;
        int z;
    }

    public String toString() {
        return some.toString();
    }
}

public class Test016 {
    public static void main(String[] args) {
        A a = new A();
        int xyz;
        B other = new B();
        other.some = (B) a; // throws ClassCastException
        a.printOther(other);
    }
}