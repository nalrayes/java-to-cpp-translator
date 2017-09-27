public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        for (int i = 0; i < 1000; i++) {

           resultFunc(i);
        }
    }


    public static void resultFunc(int i ){

        double res = 0;

        res = (Math.pow(i, 2) + i + 41);

        if (res % 2 == 0){


            System.out.println("found");
        }
    }

//    public void isPrime(){
//
//        for (int i = 0; i < 10; i++){
//
//            System.out.println(resultFunc(i));
//
//
//        }


    }

