package com.softserve.test.at.controls;

import com.softserve.test.at.tools.ControlLocation;
import com.softserve.test.at.tools.ControlSearch;
import com.softserve.test.at.tools.ControlWrapper;

public abstract class ABaseComponent<TComponent> {
    private ControlLocation controlLocation;
    private ControlWrapper controlWrapper;
    private TComponent tComponent;

    protected ABaseComponent() {

    }
 
    public TComponent getById(String id) {
        return get(ControlLocation.getById(id));
    }

    public TComponent getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public TComponent getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public TComponent getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public TComponent getByCssSelector(String cssSelector) {
        return get(ControlLocation.getByCssSelector(cssSelector));
    }

    public TComponent getByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }

    private TComponent get(ControlLocation controlLocation) {
        this.controlLocation = controlLocation;
        // TODO Set strategy for Searching Elements
        this.controlWrapper = ControlWrapper.getVisibleWebElement(controlLocation);
        return tComponent;
    }

    // TODO Change strategy Implicit/Explicit and Visible/Present

    // implements getters and setters

    ControlWrapper getControlWrapper() {
        return this.controlWrapper;
    }

    ControlLocation getControlLocation() {
        return this.controlLocation;
    }

    protected void setTComponent(TComponent tComponent) {
        this.tComponent = tComponent;
    }

    public boolean isInvisibleWebElementById(String id) {
        return ControlSearch.get().isInvisibleWebElementById(id);
    }

    public boolean isInvisibleWebElementByPartialLinkText(String partialLinkText) {
        return ControlSearch.get().isInvisibleWebElementByPartialLinkText(partialLinkText);
    }

}
