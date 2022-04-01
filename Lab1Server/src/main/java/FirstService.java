public class FirstService {
    int i = 1;
    public Integer compute(int x, int y){
        return x + y;
    }
    public int asyProc(int x){
        System.out.println("...asyProc called - processing");
        try {
            Thread.sleep(x);

        }catch (InterruptedException exception){
            exception.printStackTrace();
            Thread.currentThread().interrupt();

        }
        System.out.println("... asyProc - finished");
        return 123;
    }
}
