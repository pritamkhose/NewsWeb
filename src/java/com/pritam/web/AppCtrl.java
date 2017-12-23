/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pritam.web;

import com.pritam.dao.ToiDAO;
import static com.pritam.web.AppConstant.*;
import com.pritam.model.NewsList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pritam
 */
public class AppCtrl extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            ToiDAO toiDAO = new ToiDAO();
    
            String search = null, cat= null;
            try {
            search = request.getParameter("search");
            } catch (Exception e) {
                search = null;
            }

            cat = request.getRequestURL().toString().replaceAll("Select Category", "")
                   .replaceAll(webURL1, "").replaceAll(webURL2, "").replaceAll(webURL3, ""); 
            if(cat.length() == 0){
                cat= null;
            }
            
            String url = request.getRequestURL().toString().replaceAll(webURL1, "").replaceAll(webURL2, "").replaceAll(webURL3, "");
            switch (url) {
               case "Edit":{
                    //System.out.println("Edit -->"+ url + " "+ request.getParameter("id") );
                    List<NewsList> list = toiDAO.detailsTOIWeb(request.getParameter("id"));
                    if(list != null && list.size() == 1){
                        request.setAttribute("list", list);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("toidetails.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        response.sendRedirect(webURL3);
                    }
                   
                    }
                    break;
                 default: {
                    // Home Page
                    List<NewsList> list = toiDAO.listCATTOIWeb(search,cat);
                    if(cat != null && cat.length() > 0){
                    request.setAttribute("cat", cat);
                    } else {
                    request.setAttribute("cat", "All");
                    }
                    request.setAttribute("list", list);
                    request.setAttribute("catlist", toiDAO.listAllCATWeb());
                    //response.sendRedirect("toilist.jsp");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("toilist.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            }
           

        } catch(Exception e){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AppCtrl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error AppCtrl at " + e.toString() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
