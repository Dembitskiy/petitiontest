package com.softserve.test.at.controls;

abstract class AButton<TComponent> extends ALabelClickable<TComponent> implements IButton {

    // implements constructor
    protected AButton() {
    }

    // implements interface

    public void submit(){
        getControlWrapper().submit();
    }

}
