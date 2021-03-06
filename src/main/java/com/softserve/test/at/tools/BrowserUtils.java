package com.softserve.test.at.tools;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.softserve.test.at.data.StartData;

public final class BrowserUtils {
    private final String NO_SUCH_METHOD = "No such method.";
    private final String DEFAULT_BROWSER = "getDefaultBrowser";
    private final String EXPLICIT = "explicit";
    private final String IMPLICIT = "implicit";
    private static volatile BrowserUtils instance = null;
    private final HashMap<Long, StartData> startDatas;

    private BrowserUtils() {
        this.startDatas = new HashMap<Long, StartData>();
    }

    public static BrowserUtils get() {
        return get(null);
    }

    public static BrowserUtils get(StartData startData) {
        if (instance == null) {
            synchronized (BrowserUtils.class) {
                if (instance == null) {
                    instance = new BrowserUtils();
                }
            }
        }
        if (instance != null) {
            if (startData == null) {
                if (instance.getStartData() == null) {
                    instance.setStartData(new StartData());
                }
                if ((instance.getStartData().getBrowser() == null)
                        || (!instance.getBrowser().isEnabled())) {
                    instance.startupBrowser(instance.getStartData());
                }
            } else {

                if (instance.getStartData() == null) {
                    instance.setStartData(startData);
                }
                
                if ((instance.getStartData().getBrowser() != null)
                        && (instance.getBrowser().isEnabled())
                        && (!instance.getStartData().getBrowserName().equals(startData.getBrowserName()))) {
                    instance.getBrowser().close();
                    instance.setStartData(startData);
                }
                if ((instance.getStartData().getBrowser() == null)
                        || !instance.getBrowser().isEnabled()) {
                    instance.startupBrowser(instance.getStartData());
                }
            }
        }
        return instance;
    }

    public static void closeAll() {
        if (instance != null) {
            for (StartData startData : instance.startDatas.values()) {
                startData.getBrowser().close();
            }
        }
    }

    private void setStartData(StartData startData) {
        this.startDatas.put(Thread.currentThread().getId(), startData.clone());
    }

    public StartData getStartData() {
        return startDatas.get(Thread.currentThread().getId());
    }

    private List<String> getAccessableBrowsers() {
        List<String> result = new ArrayList<String>();
        for (Method method : BrowserRepository.class.getDeclaredMethods()) {
            if ((Modifier.isPublic(method.getModifiers())) 
                    && (!Modifier.isStatic(method.getModifiers()))) {
                result.add(method.getName());
            }
        }
        return result;
    }
    
    private boolean isAccessableBrowsersPath(String browserName) {
        boolean result = false;
        for (Method method : BrowserRepository.class.getDeclaredMethods()) {
            if ((Modifier.isPublic(method.getModifiers())) 
                    && (!Modifier.isStatic(method.getModifiers()))
                    && (method.getParameters().length == 1) 
                    && (method.getName().equals(browserName))
                    && (method.getParameters()[0].getType().getName().equals(String.class.getName()))) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    private void startupBrowser(StartData startData) {
        String browserName = DEFAULT_BROWSER;
        Method method;
        for (String methodName : getAccessableBrowsers()) {
            if (methodName.toLowerCase().contains(startData.getBrowserName().toLowerCase())) {
                browserName = methodName;
                break;
            }
        }
        if ((startData.getBrowserPath() != null)
                && (startData.getBrowserPath().length() > 0)
                && (isAccessableBrowsersPath(browserName))) {
            try {
               method = BrowserRepository.class.getMethod(browserName, String.class);
               startData.setBrowser((ABrowser) method.invoke(BrowserRepository.get(),
                       new Object[] { startData.getBrowserPath() }));
            } catch (Exception e) {
                throw new RuntimeException(NO_SUCH_METHOD, e);
            }
        } else {
            try {
                method = BrowserRepository.class.getMethod(browserName);
                startData.setBrowser((ABrowser) method.invoke(BrowserRepository.get()));
             } catch (Exception e) {
                 throw new RuntimeException(NO_SUCH_METHOD, e);
             }
        }
        setSearchStrategy(startData);
    }

    private void setSearchStrategy(StartData startData) {
        if ((startData.getSearchStrategy() != null) 
                && (startData.getSearchStrategy().length() > 0)) {
            if (startData.getSearchStrategy().toLowerCase().contains(EXPLICIT)) {
                ControlSearch.get().setContext(ContextRepository.get().getSearchExplicit());
            } else if (startData.getSearchStrategy().toLowerCase().contains(IMPLICIT)) {
                ControlSearch.get().setContext(ContextRepository.get().getSearchImplicit());
            } else {
                ControlSearch.get().setContext(ContextRepository.get().getSearchDefault());
            }
        } else {
            ControlSearch.get().setContext(ContextRepository.get().getSearchDefault());
        }
    }
    
    public ABrowser getBrowser() {
        return startDatas.get(Thread.currentThread().getId()).getBrowser();
    }

}
