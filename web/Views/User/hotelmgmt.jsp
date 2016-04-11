<%-- 
    Document   : hotelmgmt
    Created on : 4 Apr, 2016, 2:49:33 AM
    Author     : aksharma2
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/newheader.jsp"%>
<%@page import="hotelBooking.core.domain.Hotel"%>
<%@page import="hotelBooking.core.jdbc.HotelDBHandler"%>
<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/form.css" />
         <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/hoteltable.css" />
         
        <title>JSP Page</title>
    </head>
    <body>
        <h1>View hotels!</h1>
        
        <div class="testbox">
  <h1>Input parameter</h1>

  <form action="${pageContext.request.contextPath}/ViewHotel" method="post">
      <hr>
    <div class="accounttype">
      <input type="radio" value="city" id="radioOne" name="Q2" checked/>
      <label for="radioOne" class="radio" chec>By City</label>
      <input type="radio" value="id" id="radioTwo" name="Q2" />
      <label for="radioTwo" class="radio">By id</label>
       <input type="radio" value="allHotels" id="radioThree" name="Q2" />
      <label for="radioThree" class="radio">All Hotels</label>
    </div>
  <hr>
  
  <input type="text" name="id" id="name" placeholder="Enter text" />
  
  <div class="gender">
    
   </div> 
   <p>By clicking Submit, you agree on our <a href="#">terms and condition</a>.</p>
   <input type="submit" value="submit">
  </form>
</div>
      
     
        
        
      <div class="box-table">  
       <table>

                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>City</th>
                        <th>Hotel Images</th>
                        <th>Book Now</th>
                        
                    </tr>
                    </thead>
           
          <tbody>
                    
          <% try{ List<Hotel> myList = (ArrayList<Hotel>) request.getAttribute("hotel"); %>
           
                            <% for (Hotel h:myList){ %>
                            <tr>
                            <td><h3><%=h.getId() %></h3></td> 
                            <td><h3><%=h.getName() %></h3></td>
                            <td><h3><%=h.getCity() %></h3></td>
                            
                            
                             <td> <% for(String s:h.getImg()){ %> 
                                  <img src=" <%= s %> " height="200" width="150">  
                            
                                  <% } %></td> 
                            
                           <td>
                                <form action="${pageContext.request.contextPath}/BookMyRoom" method="get">
                                    
                                    <INPUT TYPE=hidden NAME="hotelN" VALUE="<%=h.getName() %>">
                                    <INPUT TYPE=hidden NAME="hotelC" VALUE="<%=h.getCity() %>">
                                    
                                    
                                    <% for(String s:h.getImg()){ %> 
                                 
                                        <INPUT TYPE=hidden NAME="hotelU" VALUE=" <%= s %>">
                                      
                                    <% } %>
                                    
                                   <button type="submit" class="btn btn-warning">BOOK NOW!</button>
                                </form>
                              
                            </td>
          </tr>
                                
                                <% } %>   <% }catch(NullPointerException n){
                                        n.printStackTrace();
                                        }  %>
                                
                                
          
                           
                                
                                
                                
                                
                                   
                   
                            
                                
                                
                    
                    </tbody>
            </table>
      </div>
       
    
        
                            
                            
                                
                        
                               
                                
                    
        
      
    </body> 
</html>
