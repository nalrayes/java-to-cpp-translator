package inputs.CustomTests;

class A {
    public void printOther(A other) {
        System.out.println(other.toString());
    }
}

class B extends A {
    public B some;

    private A classA;

    public A returnClass(){
        return this.classA;
    }

    public void printOther(A other, B thing, int xyz) {
        System.out.println(other.toString());
    }

    public String toString() {
        return some.toString();
    }
}

public class CustomTest1 {

    //int x;
    public static void main(String[] args) {
        A a = new A();
        B other = new B();
        other.some = (B) a; // throws ClassCastException
        a.printOther(other);
    }
}