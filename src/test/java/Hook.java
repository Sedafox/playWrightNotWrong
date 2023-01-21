package stepDefs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hook {

    public static Page page = setUp();


    private static Page setUp() {
        Playwright playwright = Playwright.create();
        BrowserType chrome = playwright.chromium();
        Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
        return browser.newPage();
    }
}
