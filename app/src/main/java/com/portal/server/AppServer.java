package com.portal.server;


import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.Container;
import org.apache.catalina.ContainerEvent;
import org.apache.catalina.ContainerListener;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

public class AppServer {
	  private static final int PORT = 8080;
	    public String getGreeting() {
	        return "Hello world.";
	    }

	    public static void main(String[] args) throws Exception {
	    	
	    	Logger logger = Logger.getLogger("");
	    	Handler fileHandler = new FileHandler("catalina.out", true);
	    	fileHandler.setFormatter(new SimpleFormatter());
	    	fileHandler.setLevel(Level.ALL);
	    	fileHandler.setEncoding("UTF-8");
	    	logger.addHandler(fileHandler);
	    	
	    	 String appBase = ".";
	         Tomcat tomcat = new Tomcat();
	         tomcat.setBaseDir(createTempDir());
	         tomcat.setPort(PORT);
	         tomcat.getHost().setAppBase(appBase);
	         tomcat.addWebapp("/portal", appBase);
	         tomcat.getServer().addLifecycleListener(new MyListner());
	         
	         tomcat.getConnector().addLifecycleListener(new MyListner());
	         tomcat.getEngine().addContainerListener(new MyContainerListner());
	         

	         tomcat.start();
	         tomcat.getServer().await();
	    }
	    
	    // based on AbstractEmbeddedServletContainerFactory
	    private static String createTempDir() {
	        try {
	            //File tempDir = File.createTempFile("tomcat.", "." + PORT);
	            File tempDir = new File("C:\\KBData\\tmp\\tomcat");
	            tempDir.createNewFile();
	            System.out.println("TMPDIR--------"+tempDir.getPath());
	            tempDir.delete();
	            tempDir.mkdir();
	            tempDir.deleteOnExit();
	            return tempDir.getAbsolutePath();
	        } catch (IOException ex) {
	            throw new RuntimeException(
	                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("C:\\KBData\\tmp\tomcat"),
	                    ex
	            );
	        }
	    }
}

class MyListner implements LifecycleListener{

	@Override
	public void lifecycleEvent(LifecycleEvent event) {
		
	}
	
}

class MyContainerListner implements ContainerListener{

	@Override
	public void containerEvent(ContainerEvent event) {
		
	}
	
}
