package com.softserve.test.pt.data;

/**
 * Created by rdem on 16.02.2016.
 */
public class StringSearchRepository {
    private static String MetallicaSearch = "Metallica";
    private static String MetallicaSearchResult = "Запросити в Україну легендарну рок-групу Metallica";
    private static String MinisterSearch = "Міністр";
    private static String MinisterSearchResult = "Вибори прем'єр-міністра за відкритим конкурсом";

    public static String getMetallicaSearch() {
        return MetallicaSearch;
    }

    public static String getMetallicaSearchResult() {
        return MetallicaSearchResult;
    }

    public static String getMinisterSearch(){
        return MinisterSearch;
    }

    public static String getMinisterSearchResult(){
        return MinisterSearchResult;
    }
}
