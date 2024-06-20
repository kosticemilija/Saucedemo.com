package Tests;

import Base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class SortingTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get(links.saucedemoLink);
        successfulLogin();
    }

    @Test
    public void testSortingByPriceHighToLow() {
        List<Double> beforeFilterPriceList = sorting.getAllProductPrices();
        sorting.selectOptionFromProductsSorter("Price (high to low)");
        List<Double> afterFilterPriceList = sorting.getAllProductPrices();
        // Sortiranje liste pre filtera u opadajućem redosledu
        Collections.sort(beforeFilterPriceList);
        Collections.reverse(beforeFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
    }

    @Test
    public void testSortingByPriceLowToHigh() {
        List<Double> beforeFilterPriceList = sorting.getAllProductPrices();
        sorting.selectOptionFromProductsSorter("Price (low to high)");
        List<Double> afterFilterPriceList = sorting.getAllProductPrices();
        Collections.sort(beforeFilterPriceList);
        Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);
    }

    @Test
    public void testSortingByNameAToZ() {
        sorting.selectOptionFromProductsSorter("Name (A to Z)");
        List<String> afterFilterNameList = sorting.getAllProductNames();
        Assert.assertTrue(sorting.isSorted(afterFilterNameList, true));
    }

    @Test
    public void testSortingByNameZToA() {
        sorting.selectOptionFromProductsSorter("Name (Z to A)");
        List<String> afterFilterNameList = sorting.getAllProductNames();
        Assert.assertTrue(sorting.isSorted(afterFilterNameList, false));
    }
}