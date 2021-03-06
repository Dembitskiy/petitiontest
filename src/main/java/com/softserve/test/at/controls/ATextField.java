package com.softserve.test.at.controls;

abstract class ATextField<TComponent> extends ALabelClickable<TComponent>implements ITextField {

    // implements constructor
    protected ATextField() {
    }

    // implements interface

    public void clear() {
        getControlWrapper().clear();
    }

    public void sendKeys(String text) {
        getControlWrapper().sendKeys(text);
    }

    public void sendKeysClear(String text) {
        getControlWrapper().sendKeysClear(text);
    }

}
