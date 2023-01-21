package stepDefs;

import com.microsoft.playwright.*;

public class Hook {

    public static Page page = setUp();


    private static Page setUp() {
        Playwright playwright = Playwright.create();
        BrowserType chrome = playwright.chromium();
        Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        return context.newPage();
    }
}
