package quandoo.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import quandoo.utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private SelenideElement acceptBtn;

    @FindBy(id ="cookiebanner")
    private SelenideElement banner;

    public Page() {
       //BASE_URL = PropertiesLoader.loadProperty("url");
    }

    public void acceptCookies(){
        if(acceptBtn.isDisplayed())
            $(acceptBtn).click();

    }

    public static String BASE_URL = PropertiesLoader.loadProperty("url");

}
