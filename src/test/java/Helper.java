public class Helper {
    public static void waitFewSeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        } catch(Exception ignored){}
    }
}
