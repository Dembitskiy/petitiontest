package com.softserve.test.pt.data;

public final class UrlRepository {

	    private static volatile UrlRepository instance = null;

	    private UrlRepository() {
	    }

	    public static UrlRepository get() {
	        if (instance == null) {
	            synchronized (UrlRepository.class) {
	                if (instance == null) {
	                    instance = new UrlRepository();
	                }
	            }
	        }
	        return instance;
	    }

	    public IUrls getLocalUrls() {
	        return Urls.get()
	                .setLogin("http://localhost:8080/#/login")
	                .setLogout("http://localhost:8080/#/logout")
	                .build();
	    }
	    
	    public IUrls getTrainingUrls() {
	        return Urls.get()
	                .setLogin("http://java.training.local:8080/#/login")
	                .setLogout("hhttp://java.training.local:8080/#/logout")
	                .build();
	    }
	}
