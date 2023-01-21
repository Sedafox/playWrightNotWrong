package stepDefs;

import SauceDemo.PageObject.BasePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import java.nio.file.Paths;

public class BaseStepDefs {

    Page page;
    BasePage basePage;

    @Before
    public void getPage(){
        this.page = stepDefs.Hook.page;
        basePage = new BasePage(page);
    }

    @After
    public void includeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            byte[] newScreenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/" + scenario.getName() +".png")));
            scenario.attach(newScreenshot, "image/png", scenario.getName());
        }
    }

    @And("I click {string} on the menu")
    public void iClickLOGOUTOnTheMenu(String selection) {
        basePage.selectFromMenu(selection);
    }

    @And("debug step")
    public void debugStep() {
        try {
            Thread.sleep(50000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
