package SauceDemo.PageObject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {
    Page page;

    Locator hamburgerMenu;
    Locator menuContainer;

    public BasePage(Page page) {
        this.page = page;
        hamburgerMenu = page.locator("#react-burger-menu-btn");
        menuContainer = page.locator(".bm-item-list");
    }

    public boolean areMenuItemsVisibleOnPage(String[] items) {
        for (String item : items) {
            if (!menuContainer.getByText(item).isVisible()) {
                return false;
            }
        }
        return true;
    }

    public void clickHamburgerMenuButton() {
        hamburgerMenu.click();
    }

    public void selectFromMenu(String selection) {
        menuContainer.getByText(selection).click();
    }

}
