/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pritam.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pritam.dao.ToiDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
/**
 *
 * @author Pritam
 */
public class TOIWebsiteReader {

        static int pold = -1;
	static ArrayList<HashMap<String,Object>> aList;
	public static String domain= "http://timesofindia.indiatimes.com";
	public static String domainurl = "http://timesofindia.indiatimes.com/rss.cms";
	private static final String imgpath = "https://beautypageants.indiatimes.com";
	private static final String imgicon = "https://static.toiimg.com/photo/msid-58127550/toilogo.jpg";
	
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, HH:mm z", Locale.ENGLISH);
	
    
    
    ArrayList<String> total_link =  new ArrayList(); 
    public ArrayList<String> getLink() {
        total_link =  new ArrayList();	
                ArrayList<String> arrlist_feed  = getListFeed();
		//System.out.println("List of feed = "+String.valueOf(arrlist_feed.size()) +"\n"+ arrlist_feed.toString());

		for(int feedlink=0;feedlink<arrlist_feed.size();feedlink++){
		//for(int feedlink=0;feedlink<1;feedlink++){
			total_link.addAll(getfeedlink(arrlist_feed.get(feedlink)));
			
		}
		
		//collectAllDetails(total_link);
        return total_link;
    }

       
	private static ArrayList<String> getfeedlink(String feedurl) {
		// TODO Auto-generated method stub
		
		HashSet<String> arrlist_link =  new HashSet<String>();   
		try{

			Document doc = Jsoup
					.connect(feedurl)
					.userAgent(
							"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21"
									+ " (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
					.timeout(999999999).get();

			

			Elements links = doc.getAllElements();
			for (Element link : links) {  
				String s = link.text();
				if(s.contains(".cms") && s.startsWith("https://") && !s.contains("photo") && s.contains("/articleshow"))
					arrlist_link.add(s); 	
			}  

		} catch(Exception e)
		{
			//System.out.println("Exception Occure @ getfeedlink");  
			e.printStackTrace();  

		}
		
		ArrayList total_link =  new ArrayList();	
		total_link.addAll(arrlist_link);
		return total_link;


	}

	private static ArrayList<String> getListFeed() {
		// TODO Auto-generated method stub
		HashSet<String> arrlist_feed =  new HashSet<String>();   
		try{
			String domainurl = "http://timesofindia.indiatimes.com/rss.cms";

			Document doc = Jsoup
					.connect(domainurl)
					.userAgent(
							"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21"
									+ " (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
					.timeout(999999999).get();


			Elements links = doc.getElementsByClass("tbody");  

			links = doc.select("a[href]");  
			for (Element link : links) {  
				String linkurl = link.attr("href"); 

				if (linkurl.contains(".cms") && linkurl.contains("http://timesofindia.indiatimes.com/rssfeeds/") &&
						!linkurl.contains("google") && !linkurl.contains("yahoo")  && 
						!linkurl.contains("newsgator") && !linkurl.contains("live"))   
					arrlist_feed.add(linkurl); 		   
			}  

			//System.out.println("List of feed = "+String.valueOf(arrlist_feed.size()) +"\n"+ arrlist_feed.toString());
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}

		ArrayList arrlist_all=  new ArrayList(); 
		arrlist_all.addAll(arrlist_feed);
		return arrlist_all ;
	}
        
        
        
        public HashMap<String,Object> collectAllDetails(ArrayList total_link) {
		// TODO Auto-generated method stub
		 aList =  new ArrayList();
		for(int link_inc=0;link_inc < total_link.size();link_inc++)
		{
			String articlelink = (String) total_link.get(link_inc);
			String[] n = articlelink.replaceAll("https://timesofindia.indiatimes.com/", "").split("/articleshow")[0].split("/");
			String name;
			if(n.length > 2){
				name = n[0]+"-"+n[1];
			} else{
				name = n[0];
			}
				
			//System.out.println("link "+link_inc+"= \t"+name.toUpperCase()+"--> \t"+s);
			int p = ((link_inc*100)/total_link.size());
			if(p != pold){
				pold = p;
			System.out.println("Data collect progress = "+p+" %");	  
			}
			
			
		    getarticledetails(articlelink,name);
		} 
                    //System.out.println("aList = "+aList.size());
		 //Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 //System.out.println(gson.toJson(aList));
		 
                
                HashMap<String,Object> result = new HashMap<>();
		 try{
		 ToiDAO toiDAO = new ToiDAO();
		 result = toiDAO.insertNewTOI(aList);
		 } catch(Exception e){
			 e.printStackTrace();
		 }
                 
                 return result;

	}

            private static void getarticledetails(String articlelink, String name) {
		HashMap<String,Object> hm = new HashMap<>();
		hm.put("articlelink", articlelink);
		hm.put("cat", name.toUpperCase().replaceAll("'", ""));
		
		try{
			
			
	    	 Document doc = Jsoup
						.connect(articlelink)
						.userAgent(
								"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21"
										+ " (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
						.timeout(999999999).get();
			 
	    	 
	    	 String s =  doc.getElementsByClass("Normal").text().replaceAll("'", "");
	    	 if(!s.isEmpty()){
	    	 
	    		
	    		 hm.put("heading1", doc.getElementsByClass("heading1").text().replaceAll("'", ""));
	    		 
	    		 String st = doc.getElementsByClass("time_cptn").text().replaceAll("'", "");
	    		 hm.put("time_cptn", st );
	    		 if(st != null && st.length() > 3){
	    			 	try{
	    			 	String[] arr = st.split("\\|",-1);
	    			 	st = arr[arr.length-1].replaceAll("Updated: " , "").trim();
	    				LocalDateTime date = LocalDateTime.parse(st, formatter);
	    				st = date.toString().replace( "T" , " " )+":00";
	    			 	} catch(Exception e){
	    			 		st = "";
	    			 	}
	    		 } else {
	    			 st = "";
	    		 }
                         
                         if(st != null && st.length() > 0) {
	    		 hm.put("time_date", st );
                         } else {
                            st = formatter.format(LocalDateTime.now());
                         }
	    		 hm.put("auth_detail", doc.getElementsByClass("auth_detail").text().replaceAll("'", ""));
	    		 
	    		 ArrayList img =  new ArrayList();
	    		 Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
	    		 for (Element image : images) {  
	    			 	String str = image.attr("src");
	    			 	if(!str.equals(imgicon))
	    			 	img.add(imgpath+str); 
		           }  
		          
		           
		           String c7 =  (domain+img.get(0)); 
		           hm.put("image", img);
		           
		           String c8 =  doc.getElementsByClass("Normal").text();//doc.getElementsByClass("Normal").html().replaceAll("\n", "").replaceAll("\\\"images", "");
		           hm.put("data", c8.replaceAll("'", ""));
                         aList.add(hm);
                         
	    	 }

	    } catch(Exception e)
		{
			//e.printStackTrace();  
		}
		
	}
	
	
 }
    

        
  
