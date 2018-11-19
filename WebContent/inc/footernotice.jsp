<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<%@ page import="java.util.ArrayList,java.util.Calendar" %>

<%
 Calendar cal;
 
 String year;
 
 
	 cal = Calendar.getInstance();
	 
	 
	 year=cal.get(Calendar.YEAR)+"";
 
	 
 
	 
	 
%>



<footer class="row">
                      
                      <div class="col-xs-12">
                                                                  
                                                                                         <!-- footer ENAD -->
                                                                                         
                                                                                         <div style="background-color:#0099cc;
        font-size:4em;
        text-align:center;
        font-weight:bold;
        color:white;
        font-family:agencyfb;
        position:fixed;
        bottom:0px;
        width:100%;
        z-index:2;">
                                                                                         
                                                                                         
                                                                                         
                                                                                         <a target="_blank" style="color: white;" class="btn-block" href="https://4hwc4hwc.wixsite.com/4hwc">ENAD by 4HWC © <%out.println(year); %></a>
                                                                                         
                                                                                    
                                                                                         
                                                                                         </div>
                                                                  
                                                                  
                       </div>
 
 
 
 
 
 
 </footer>