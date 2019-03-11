package org.oneframework.helpers;

import org.openqa.selenium.WebElement;

public class Page {

    public void clickElement(WebElement element) throws Exception {
        element.click();
    }

    public String getText(WebElement element) throws Exception {
        return element.getText();
    }

    public void enterText(WebElement element, String value) {
        element.sendKeys(value);
    }

}
