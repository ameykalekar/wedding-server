package com.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Autowired
    public ApplicationContextProvider(ApplicationContext ac) {
        setApplicationContext(ac);
    }

    public static ApplicationContext getContext() {
        return context;
    }

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;		
	}
}
