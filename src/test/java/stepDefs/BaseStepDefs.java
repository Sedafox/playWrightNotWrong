package stepDefs;

import SauceDemo.PageObject.BasePage;
import com.microsoft.playwright.Page;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

public class BaseStepDefs {

    Page page;
    BasePage basePage;

    @Before
    public void getPage(){
        this.page = stepDefs.Hook.page;
        basePage = new BasePage(page);
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
