package quandoo.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import quandoo.pages.FilterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.devtools.v93.network.Network.clearBrowserCache;
import static org.openqa.selenium.devtools.v93.network.Network.clearBrowserCookies;

public class FiltersSteps {

    private FilterPage filtersPage = null;

    /*



    @Before
    public void beforeTest(){
        clearBrowserCookies();
        clearBrowserCache();
    }

    @After
    public void quitBrowser(){
        Selenide.closeWebDriver();
    }
 */
    @Given("user is on Berlin Restaurants page")
    public void userOnBerlinRestaurantsPage() {
        filtersPage = open(FilterPage.pageUrl, FilterPage.class);
        filtersPage.acceptCookies();
    }
    @When("user click on Top Rated button")
    public void clickOnTopRatedBtn(){

        filtersPage.clickOnTopRatedBtn();
    }
    @Then("user see filtered Top Rated list of restaurants")
    public void verifyTopRatedFilteredList(){
        filtersPage.verifyTopRatedFilter();
    }

    @When ("user click on Cuisine {} check box")
    public void clickOnCuisineCheckBox(String kitchen){

        filtersPage.clickOnCuisineFilter(kitchen);
        sleep(700);
    }

    @Then ("user see filtered for {} list of restaurants")
    public void verifyKitchenFilter(String kitchen){
        filtersPage.verifyCuisineFilter(kitchen);
    }
}
