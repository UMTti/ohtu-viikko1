package com.mycompany.webkauppa;

import com.mycompany.webkauppa.ohjaus.KomentoTehdas;
import com.mycompany.webkauppa.ohjaus.OstoksenPoistoKorista;
import com.mycompany.webkauppa.sovelluslogiikka.Varasto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PoistaOstoskoristaServlet extends WebKauppaServlet {
             
    KomentoTehdas komennot;

    public PoistaOstoskoristaServlet(Varasto varasto){
        super(varasto);
        komennot = new KomentoTehdas();
        this.varasto = varasto;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        long tuoteId = Long.parseLong( request.getParameter("tuoteId") );
        
        komennot.ostoksenPoistoKorista(haeSessionOstoskori(request), tuoteId, varasto).suorita();     
        
        naytaSivu("/MaksaOstokset", request, response);
    }
}
