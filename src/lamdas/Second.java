package lamdas;

public class Second {

    public static void main(String[] args) {

//this anonymous class implements interface which has one method and is name "function interface"

//        getToWork(new Worker() {
//            @Override
//            public void doSmth() {
//                System.out.println("I'm work");
//            }
//        });

        getToWork(() -> System.out.println("I'm work"));

    }

    private interface Worker{
        void doSmth();
    }

    private static void getToWork(Worker worker){
        worker.doSmth();
    }
}
