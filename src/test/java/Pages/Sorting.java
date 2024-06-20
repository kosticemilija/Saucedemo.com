package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting extends BaseTest {
    public Sorting() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product_sort_container")
    public WebElement productsSorter;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> productPrices;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productNames;




    public void selectOptionFromProductsSorter(String optionName) {
        switch (optionName) {
            case "Price (high to low)":
                productsSorter.click(); //Klik na dropdown menu
                driver.findElement(By.xpath("//option[text()='Price (high to low)']")).click();
                break;
            case "Price (low to high)":
                productsSorter.click();
                driver.findElement(By.xpath("//option[text()='Price (low to high)']")).click();
                break;
            case "Name (A to Z)":
                productsSorter.click();
                driver.findElement(By.xpath("//option[text()='Name (A to Z)']")).click();
                break;
            case "Name (Z to A)":
                productsSorter.click();
                driver.findElement(By.xpath("//option[text()='Name (Z to A)']")).click();
                break;
            default:
        }
    }

    public List<Double> getAllProductPrices() {
        return productPrices.stream()
                .map(p -> Double.valueOf(p.getText().replace("$", "")))// Uklanjanje znaka $ i konverzija u Double
                .collect(Collectors.toList());
    }

    public List<String> getAllProductNames() {
        return productNames.stream()
                .map(WebElement::getText) // Dobijanje teksta iz svakog WebElement-a
                .collect(Collectors.toList());
    }

    public boolean isSorted(List<String> list, boolean ascending) {
        // Pravim kopiju liste i sortiram je
        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        if (!ascending) {
            // Ako je sortiranje opadajuće, obrnem sortiranu listu
            Collections.reverse(sortedList);
        }
        // Vraćamo true ako je originalna lista jednaka sortiranoj listi
        return list.equals(sortedList);
    }


}