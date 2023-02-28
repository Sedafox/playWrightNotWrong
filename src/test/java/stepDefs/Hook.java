package stepDefs;

import SauceDemo.Utilities.PageManager;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    public static Page page;
    private static Browser browser;


    @Before
    public static void setUp() {
        Playwright playwright = Playwright.create();
        BrowserType chrome = playwright.chromium();
        browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext context = browser.newContext();
        page = context.newPage();
        PageManager.page = page;
    }

    @After
    public static void tearDown() {
        browser.close();
    }
}
