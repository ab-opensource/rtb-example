package com.adbrite.rtb.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
  * Example RTB server with embedded Jetty server.
  * 
  * Run RTBServer as Java Application. The server process will listen on all local addresses.
  * 
  * To test POST request execute following command in the project root directory:
  * 
  * curl -q --data @scripts/request.json 'http://127.0.0.1:8888/rtb'
  * 
  */
public class RTBServer {

    final static int DEFAULT_PORT = 8888;
    final static String DEFAULT_URL = "/rtb";

    public static void main(String[] args) throws Exception {

        /* 
         * TODO: RTBServer [PORT|8888] [URL|/rtb] 
         */
        int port = DEFAULT_PORT;
        String url = DEFAULT_URL;
        
        // Create Server and handler
        Server server = new Server(port);
        
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.addServlet(new ServletHolder(new RTBServlet()), url);
        server.setHandler(contextHandler);

        // Start the server
        server.start();
        server.join();
    }
}
