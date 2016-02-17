package com.softserve.test.at.tools;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ControlWrapper {
    private final String INVALID_TAG = "Invalid Tag. Must be <a>";
    private final String TAG_A = "a";
    private final String ATTRIBUTE_HREF = "href";
    private final String ATTRIBUTE_NAME = "name";
    private WebElement webElement;

    private ControlWrapper(WebElement webElement) {
        this.webElement = webElement;
    }

    static ControlWrapper get(WebElement webElement) {
        return new ControlWrapper(webElement);
    }

    public static ControlWrapper getVisibleWebElement(ControlLocation controlLocation) {
        return new ControlWrapper(ControlSearch.get().getVisibleWebElement(controlLocation));
    }

    public static List<ControlWrapper> getVisibleWebElements(ControlLocation controlLocation) {
        List<ControlWrapper> controlWrappers = new ArrayList<ControlWrapper>();
        for (WebElement webElement : ControlSearch.get().getVisibleWebElements(controlLocation)) {
            controlWrappers.add(new ControlWrapper(webElement));
        }
        return controlWrappers;
    }

    public static ControlWrapper getPresentWebElement(ControlLocation controlLocation) {
        return new ControlWrapper(ControlSearch.get().getPresentWebElement(controlLocation));
    }

    WebElement getWebElement() {
        return webElement;
    }

    public String getAttribute(String attribute) {
        return getWebElement().getAttribute(attribute);
    }

    public String getAttributeName() {
        return getWebElement().getAttribute(ATTRIBUTE_NAME);
    }

    public String getContent() {
        return getWebElement().getText();
    }

    public String getTagName() {
        return getWebElement().getTagName();
    }

    public String getText() {
        return getWebElement().getText();
    }

    public String getUrl() {
        if (getTagName().toLowerCase().equals(TAG_A)) {
            return getWebElement().getAttribute(ATTRIBUTE_HREF);
        } else {
            throw new RuntimeException(INVALID_TAG);
        }
    }

    public void clear() {
        click();
        getWebElement().clear();
    }

    public void click() {
        getWebElement().click();
    }

    public boolean isDisplayed() {
        return getWebElement().isDisplayed();
    }

    public boolean isEnabled() {
        return getWebElement().isEnabled();
    }

    public boolean isSelected() {
        return getWebElement().isSelected();
    }

    public void sendKeys(String text) {
        getWebElement().sendKeys(text);
    }

    public void sendKeysClear(String text) {
        clear();
        getWebElement().sendKeys(text);
    }

    public void setFocus() {
        sendKeys(new String());
    }

    public void submit() {
        getWebElement().submit();
    }

}
