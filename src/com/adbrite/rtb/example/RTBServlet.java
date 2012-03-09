package com.adbrite.rtb.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONWriter;


public class RTBServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String RESPONSE_CODE = "response_code";

    ServletConfig servletConfig = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        servletConfig = config;
        ServletContext context = servletConfig.getServletContext();
        context.log("Init: "+context.getContextPath());
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException  {  
        ServletContext context = servletConfig.getServletContext();
        context.log("GET " + req.getRequestURI());

        PrintWriter writer = res.getWriter();
        writer.append("OK");
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
                                         throws ServletException, IOException  {

        ServletContext context = servletConfig.getServletContext();
        context.log("POST " + req.getRequestURI());

        PrintWriter out = res.getWriter();
        JSONWriter jsonWriter = new JSONWriter(out);
        
        try {

        	// Parse request
        	JSONObject adBidRequest = parseAdBidRequest(req);
        	context.log(adBidRequest.toString());

        	// Write PASS response
            context.log("Response: PASS");
            generatePassResponse(jsonWriter);
        
        } catch (JSONException e) {
        	context.log("JSONException: " + e);
        	out.println("JSONException: " + e);
        }
        
    }

    private JSONObject parseAdBidRequest(HttpServletRequest req) throws JSONException, UnsupportedEncodingException, IOException {
    	String encoding = req.getCharacterEncoding();
    	InputStreamReader reader = encoding != null ? 
    			new InputStreamReader(req.getInputStream(), encoding) :
    			new InputStreamReader(req.getInputStream())	;
    	return new JSONObject(new JSONTokener(reader)); 
    }
    
    private void generatePassResponse(JSONWriter jsonWriter) 
                                                    throws JSONException {
        jsonWriter.object().key(RESPONSE_CODE).value("pass").endObject();
    }
    
}
