public class Instantiation{

    public static void main(String[] args){
        new Second("Random");
    }

    private static class First{
        private int mFirst = 1;

        public First(String random) {
            System.out.println("First Constructor: " + mFirst);
            test();
        }

        protected void test(){
            System.out.println("First test: " + mFirst);
        }
    }

    private static class Second extends First{
        private int mSecond = 2;

        public Second(String random) {
            super(random);
            System.out.println("Second Constructor: " + mSecond);
        }

        @Override
        protected void test() {
            System.out.println("Second test: " + mSecond);
            mSecond = 3;
            System.out.println("Second test: " + mSecond);
        }
    }    
}