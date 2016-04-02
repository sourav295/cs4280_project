/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelBooking.user.BookingService;

import hotelBooking.core.jdbc.BookingDBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hotelBooking.core.domain.Booking;
import hotelBooking.core.services.BookingService;
import java.util.Random;
/**
 *
 * @author shrankhla
 */
public class MakeBooking extends HttpServlet {

    public static int userCount=1;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
      
        out.println("<html>");
        out.println("<head>");
        out.println("<title>My Bookings</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Booking (Add)</h1>");
        out.println("<div style='width:600px'>");
        out.println("<fieldset>");
        String hotel = request.getParameter("hotels");
        String room = request.getParameter("rooms");
        if (hotel != null && !hotel.equalsIgnoreCase("") &&
                room != null && !room.equalsIgnoreCase("")) {
            
            
            Long id ;
            Random rand = new Random();
            id=rand.nextLong();
            
            String userName=Long.toString(id);
            
            Booking b = new Booking(hotel,room,userName);
            //b.setHotelID(hotel);
            //b.setRoomID(room);
            //b.setUserID(userName);
            
            
           BookingService bookingservice = new BookingService();
            
            boolean isConnectionMade = bookingservice.makeBooking(b);
            
            if(isConnectionMade)
                
            {
               out.println("<legend>New Booking is sucessfully made.</legend>");
            
            }
            else {
                out.println("<legend>ERROR: New record is failed to create.</legend>");
            }
        }
        else {
            if (hotel == null) {
                hotel = "";
            }
            if (room == null) {
                room = "";
            }
            out.println("<legend>Please fill in the form</legend>");
            out.println("<form method='POST' action='" + request.getRequestURI() + "'>");
            out.println("<input name='action' type='hidden' value='create' />");
            out.println("<p>Hotel:");
            out.println(" <select name=\"hotels\">\n" +
                    "    <option value=\"hyatt\">Hyatt</option>\n" +
                    "    <option value=\"radisson\">Radisson</option>\n" +
                    "    <option value=\"itc\">ITC</option>\n" +
                    "    <option value=\"leela\">Leela Palace</option>\n" +
                    "  </select></p>");
            out.println("<p>Room Type:");
            out.println(" <select name=\"rooms\">\n" +
                    "    <option value=\"single\">Single</option>\n" +
                    "    <option value=\"deluxe\">Deluxe</option>\n" +
                    "    <option value=\"suite\">Suite</option>\n" +
                    "    <option value=\"prsuite\">Presidential Suite</option>\n" +
                    "  </select></p>");
            
            out.println("<input type='submit' value='Make Booking!' />");
            out.println("</form>");
        }
        out.println("</fieldset>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        
        
                    
               
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    /*
     private String htmlEncode(String s) {

        StringBuffer sb = new StringBuffer(s.length() * 2);

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if ((ch >= '?' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch == ' ') || (ch == '\n')) {
                sb.append(ch);
            }
            else {
                switch(ch) {
                    case '>':
                        sb.append("&gt;");
                        break;
                    case '<':
                        sb.append("&lt;");
                        break;
                    case '&':
                        sb.append("&amp;");
                        break;
                    case '\'':
                        sb.append("&#039;");
                        break;
                    case '"':
                        sb.append("&quot;");
                        break;
                    default:
                        sb.append("&#");
                        sb.append(new Integer(ch).toString());
                        sb.append(';');
                }
            }
        }

        return sb.toString();
    }

   */ 
    
}
