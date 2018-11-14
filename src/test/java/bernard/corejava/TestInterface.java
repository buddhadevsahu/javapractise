package bernard.corejava;

public class TestInterface {



    static interface A{

        public int add(int a, int b);
        public int multiply(int a, int b);

    }
    static interface B{

        public int add(int a, int b);
        public int substract(int a, int b);

    }

    static interface MathOperation extends A,B{

        //public int add(int a, int b);
        public int devide(int a, int b);
    }


    static class MyMathClass implements MathOperation{

        @Override
        public int add(int a, int b) {
            return 0;
        }

        @Override
        public int substract(int a, int b) {
            return 0;
        }

        @Override
        public int multiply(int a, int b) {
            return 0;
        }

        @Override
        public int devide(int a, int b) {
            return 0;
        }
    }
}


