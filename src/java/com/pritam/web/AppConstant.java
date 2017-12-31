package com.pritam.web;

public class AppConstant {

    public static String jdbcClass = "com.mysql.jdbc.Driver";
    public static String dbName = "NewsWeb";

//    public static String jdbcURL = "jdbc:mysql://localhost:3306/"+dbName;
//    public static String jdbcUsername = "root";
//    public static String jdbcPassword = "root"; 
    
   public static String jdbcURL = "jdbc:mysql://webserver.ckczvbrr9h31.us-east-1.rds.amazonaws.com:3306/"+dbName;
   public static String jdbcUsername = "pritam";
   public static String jdbcPassword = "pritam123";
    
     public static String webURL1 = "http://localhost:8880/NewsWeb/News";
     public static String webURL2 = "http://192.168.0.106:8880/NewsWeb/News";
     public static String webURL3 = "http://newsweb.us-east-1.elasticbeanstalk.com/";

}
