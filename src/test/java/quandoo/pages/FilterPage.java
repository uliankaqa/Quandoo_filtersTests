package quandoo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.Before;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import quandoo.data.CommonData;
import quandoo.utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.devtools.v93.network.Network.clearBrowserCache;
import static org.openqa.selenium.devtools.v93.network.Network.clearBrowserCookies;

public class FilterPage extends Page {
    public static String pageUrl = BASE_URL + "/berlin";


    @FindBy(xpath = "//button[@data-qa='filter-button-top-rated']")
    private SelenideElement topRatedBtn;


    @FindBy(css= ".sc-1w62342-6 > span")
    private SelenideElement reviewScore;

    @FindBy(xpath = "//div[@data-qa='results-count']")
    private SelenideElement resultCount;

    //Cuisine filters elements
    //Arabic cuisine filter
    @FindBy(xpath = "//div[@data-qa='filter-cuisine-label-5e6ac69c-e488-46ef-9987-22f7a3e81fc2']")
    private SelenideElement cuisineArabic;
    //African cuisine filter
    @FindBy(xpath = "//div[@data-qa='filter-cuisine-label-03c331d2-8f5f-4d45-8731-e5e98ebfee00']")
    private SelenideElement cuisineAfrican;
    //Argentinian cuisine filter
    @FindBy(xpath = "//div[@data-qa='filter-cuisine-label-f64217f4-2f04-4c96-aa6a-70183e05cd8f']")
    private SelenideElement cuisineArgentinian;



    public void clickOnTopRatedBtn(){

        topRatedBtn.scrollIntoView(true).click();
    }

    public void setCountProductsNumber(String number){
        CommonData.COUNT_PRODUCTS = number;

    }

    public void clickOnCuisineFilter(String filter){

        String numText = "";
        String kitchen = PropertiesLoader.loadProperty(filter);

        if(kitchen.equals("African")) {
            numText = clickCuisineFilterAndGetResultNumber(cuisineAfrican);
        }

        if(kitchen.equals("Argentinian")) {
            numText = clickCuisineFilterAndGetResultNumber( cuisineArgentinian);
        }
        if(kitchen.equals("Arabic")) {
            numText = clickCuisineFilterAndGetResultNumber(cuisineArabic);
        }
        System.out.println("TEXT COUNT NUMBER CUISINE FILTER " + numText);
        setCountProductsNumber(numText.split("")[1]);
    }

    private String clickCuisineFilterAndGetResultNumber(SelenideElement cuisineFilter){
        cuisineFilter.scrollIntoView(true).click();
        SelenideElement element = cuisineFilter.find(By.xpath("span[@class='ulye33-6 hZxYrh']"));
        String text = cuisineFilter.find(By.xpath("span[@class='ulye33-6 hZxYrh']")).innerText();
        return text;
    }

    public void verifyTopRatedFilter() {
        reviewScore.shouldBe(Condition.exist);
    }

    public void verifyCuisineFilter(String kitchen){
        System.out.println("Page Counter: " + resultCount.getText() );
        System.out.println("Filter counter: " + CommonData.COUNT_PRODUCTS);
        resultCount.shouldHave(Condition.text(CommonData.COUNT_PRODUCTS));
    }
}
