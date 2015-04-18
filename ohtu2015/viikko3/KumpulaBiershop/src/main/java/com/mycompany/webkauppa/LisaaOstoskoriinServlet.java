
package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.*;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LisaaOstoskoriinServlet extends WebKauppaServlet {

    AbstractFactory komennot;
    Varasto varasto;

    public LisaaOstoskoriinServlet(Varasto varasto, String tyyppi){
        super(varasto);
        komennot = TehdasTuottaja.getFactory(tyyppi);
    }
    
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
           
        
        komennot.ostoksenLisaysKoriin(haeSessionOstoskori(request), tuoteId, varasto).suorita();
        
        naytaSivu("/Tuotelista", request, response);   
    }
}
