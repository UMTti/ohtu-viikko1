
package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LisaaOstoskoriinServlet extends WebKauppaServlet {

    KomentoTehdas komennot;

    public LisaaOstoskoriinServlet(){
        komennot = new KomentoTehdas();
    }
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
           
        
        komennot.ostoksenLisaysKoriin(haeSessionOstoskori(request), tuoteId).suorita();
        
        naytaSivu("/Tuotelista", request, response);   
    }
}
