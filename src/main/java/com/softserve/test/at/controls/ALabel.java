package com.softserve.test.at.controls;

abstract class ALabel<TComponent> extends AComponent<TComponent> implements ILabel {

    // implements constructor
    protected ALabel() {
    }

    // implements interface

    public String getText() {
        return getControlWrapper().getText();
    }

}
