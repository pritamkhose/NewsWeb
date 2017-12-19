/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pritam.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pritam.dao.ToiDAO;
import static com.pritam.web.AppConstant.*;
import com.pritam.web.model.NewsList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
public class MCtrl extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         LinkedHashMap <String,Object> hmData=new LinkedHashMap <>();  
        try {
            
            ToiDAO toiDAO = new ToiDAO();

            String req = request.getParameter("req");
            if(req == null){
                req= "sample";
            }
//            System.out.println("request -->"+ req);
            switch (req) {
                case "list":{
                        String search = null, cat= null;
                        try {
                        search = request.getParameter("search");
                        } catch (Exception e) {
                            search = null;
                        }

                        try {
                        cat = request.getParameter("cat");
                        } catch (Exception e) {
                            cat = null;
                        }
                        List<NewsList> list = toiDAO.listCATTOIWeb(search,cat);
                        if(list != null && list.size() > 0){
                           hmData.put("ErrorID", 0);
                           hmData.put("NewsList", list);
                        } else {
                            hmData.put("ErrorID", 10);
                            hmData.put("ErrorString", "Not Data Found");
                       }
                    }
                    break;
               case "details":{
                    List<NewsList> list = toiDAO.detailsTOIWeb(request.getParameter("id"));
                    if(list != null && list.size() == 1){
                        hmData.put("ErrorID", 0);
                        hmData.put("NewsDetails", list);
                    } else {
                         hmData.put("ErrorID", 10);
                        hmData.put("ErrorString", "Not Data Found");
                    }
                    }
                    break;
                case "cat":{    
                     List<String> list = toiDAO.listAllCATWeb();//toiDAO.listCATTOIWeb(search,cat);
                     if(list != null && list.size() > 0){
                     hmData.put("ErrorID", 0);
                     hmData.put("CatList", toiDAO.listAllCATWeb());
                     } else {
                         hmData.put("ErrorID", 10);
                         hmData.put("ErrorString", "Not Data Found");
                    }
                }
                break;
                case "sample":{   
                     hmData.put("ErrorID", 0);
                     ArrayList<String> sample = new ArrayList<>();
                     sample.add(webURL3 + "MCtrl");
                     sample.add(webURL3 + "MCtrl?req=details&id=1.0");
                     sample.add(webURL3 + "MCtrl?req=list");
                     sample.add(webURL3 + "MCtrl?req=list&search=pune");
                     sample.add(webURL3 + "MCtrl?req=cat");
                     sample.add(webURL3 + "MCtrl?req=list&cat=BUSINESS-INDIA-BUSINESS");
                     hmData.put("Sample", sample);
                }
                break;
                 default: {
                    hmData.put("ErrorID", 10);
                    hmData.put("ErrorString", "Not valid Request");
                }
                break;
            }
           

        } catch(Exception ex){
            StackTraceElement[] stack = new Exception().getStackTrace();
            String theTrace = ex.toString() + "\n";
            for(StackTraceElement line : stack)
            { 
               theTrace += line.toString()+"\n";
            }
             hmData.put("ErrorID", 20);
             hmData.put("ErrorString", "Error in request");
             hmData.put("ErrorInfo", theTrace);
              
        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        response.getWriter().write(gson.toJson(hmData));
        out.flush();
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
