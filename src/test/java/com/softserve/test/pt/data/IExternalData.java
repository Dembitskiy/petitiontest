package com.softserve.test.pt.data;

import java.util.List;

public interface IExternalData {

    List<List<String>> getAllCells(String absoluteFilePath);

}