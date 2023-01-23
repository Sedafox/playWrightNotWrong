package SauceDemo.Utilities;

public class PageUtilities {

    public static boolean retryVerificationForSeconds(int timeInSeconds, boolean condition) {
        long exitTime = System.currentTimeMillis() + timeInSeconds * 1000L;
        do {
            try {
                if(condition){
                    return condition;
                }
            } catch (AssertionError e) {
                //Do nothing
            }
        } while (System.currentTimeMillis() < exitTime);
        return condition;
    }
}
