package com.portal.server;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.startup.Tomcat;

public class AppServer {
	  private static final int PORT = 8080;
	    public String getGreeting() {
	        return "Hello world.";
	    }

	    public static void main(String[] args) throws Exception {
	    	 String appBase = ".";
	         Tomcat tomcat = new Tomcat();
	         tomcat.setBaseDir(createTempDir());
	         tomcat.setPort(PORT);
	         tomcat.getHost().setAppBase(appBase);
	         tomcat.addWebapp("", appBase);
	         tomcat.start();
	         tomcat.getServer().await();
	    }
	    
	    // based on AbstractEmbeddedServletContainerFactory
	    private static String createTempDir() {
	        try {
	            File tempDir = File.createTempFile("tomcat.", "." + PORT);
	            tempDir.delete();
	            tempDir.mkdir();
	            tempDir.deleteOnExit();
	            return tempDir.getAbsolutePath();
	        } catch (IOException ex) {
	            throw new RuntimeException(
	                    "Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"),
	                    ex
	            );
	        }
	    }
}
