<%-- 
    Document   : header
    Created on : Sep 18, 2017, 12:17:13 AM
    Author     : Pritam
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>News Apps</title>
        <meta charset="utf-8">
        <!--   below line required frist time open website as per device , no need to default zoom -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style type="text/css">
        <%@include file="css/mystyle.css" %>
        </style>
        
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle Navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="/NewsWeb/News">News.com</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/NewsWeb/News">Latest News</a></li>
                                                 <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="/NewsWeb/News"  id="textWhite" >All <span class="caret"></span></a>
                            <ul class="dropdown-menu" id="textBLACK">
                            <li><a href="News?cat=BUSINESS-INDIA-BUSINESS"  id="textBLUE">BUSINESS-INDIA-BUSINESS</a></li>
                            <li><a href="News?cat=BUSINESS-INTERNATIONAL-BUSINESS"  id="textBLUE">BUSINESS-INTERNATIONAL-BUSINESS</a></li>
                            <li><a href="News?cat=CADILA-TO-APPLY-FOR-CLINICAL-TRIALS-FOR-SWINE-FLU-VACCINE"  id="textBLUE">CADILA-TO-APPLY-FOR-CLINICAL-TRIALS-FOR-SWINE-FLU-VACCINE</a></li>
    			
                            <li><a href="News?cat=ENTERTAINMENT-BENGALI"  id="textBLUE">ENTERTAINMENT-BENGALI</a></li>
                            <li><a href="News?cat=ENTERTAINMENT-HINDI"  id="textBLUE">ENTERTAINMENT-HINDI</a></li>
                            <li><a href="News?cat=HAVING-JOB-BLUES-ENGAGE-YOUR-BOSS"  id="textBLUE">HAVING-JOB-BLUES-ENGAGE-YOUR-BOSS</a></li>
                            <li><a href="News?cat=HOME-EDUCATION"  id="textBLUE">HOME-EDUCATION</a></li>
                            <li><a href="News?cat=HOME-ENVIRONMENT"  id="textBLUE">HOME-ENVIRONMENT</a></li>
                            <li><a href="News?cat=HOME-SCIENCE"  id="textBLUE">HOME-SCIENCE</a></li>
                            <li><a href="News?cat=HOME-SELF-GOALS-A-BIGGER-THREAT-TO-BJP-THAN-OPPONENT-RAHUL"  id="textBLUE">HOME-SELF-GOALS-A-BIGGER-THREAT-TO-BJP-THAN-OPPONENT-RAHUL</a></li>
                            <li><a href="News?cat=INDIA"  id="textBLUE">INDIA</a></li>
                            <li><a href="News?cat=LIFE-STYLE-BEAUTY"  id="textBLUE">LIFE-STYLE-BEAUTY</a></li>
                            <li><a href="News?cat=LIFE-STYLE-BOOKS"  id="textBLUE">LIFE-STYLE-BOOKS</a></li>
                            <li><a href="News?cat=LIFE-STYLE-FASHION"  id="textBLUE">LIFE-STYLE-FASHION</a></li>
                            <li><a href="News?cat=LIFE-STYLE-HEALTH-FITNESS"  id="textBLUE">LIFE-STYLE-HEALTH-FITNESS</a></li>
                            <li><a href="News?cat=LIFE-STYLE-HOME-GARDEN"  id="textBLUE">LIFE-STYLE-HOME-GARDEN</a></li>
                            <li><a href="News?cat=LIFE-STYLE-RELATIONSHIPS"  id="textBLUE">LIFE-STYLE-RELATIONSHIPS</a></li>
                            <li><a href="News?cat=MUMBAI"  id="textBLUE">MUMBAI</a></li>
                            <li><a href="News?cat=NEW-WAVE-OF-SWINE-FLU-COULD-SICKEN-MILLIONS"  id="textBLUE">NEW-WAVE-OF-SWINE-FLU-COULD-SICKEN-MILLIONS</a></li>
                            <li><a href="News?cat=NRI-OTHER-NEWS"  id="textBLUE">NRI-OTHER-NEWS</a></li>
                            <li><a href="News?cat=NRI-US-CANADA-NEWS"  id="textBLUE">NRI-US-CANADA-NEWS</a></li>
                            <li><a href="News?cat=SYNTHETIC-BEDDING-CAN-CAUSE-ASTHMA"  id="textBLUE">SYNTHETIC-BEDDING-CAN-CAUSE-ASTHMA</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="/NewsWeb/News"  id="textWhite" >City <span class="caret"></span></a>
                            <ul class="dropdown-menu" id="textBLACK">
                            <li><a href="News?cat=CITY-AHMEDABAD"  id="textBLUE">AHMEDABAD</a></li>
                            <li><a href="News?cat=CITY-ALLAHABAD"  id="textBLUE">ALLAHABAD</a></li>
                            <li><a href="News?cat=CITY-BENGALURU"  id="textBLUE">BENGALURU</a></li>
                            <li><a href="News?cat=CITY-BHUBANESWAR"  id="textBLUE">BHUBANESWAR</a></li>
                            <li><a href="News?cat=CITY-CHANDIGARH"  id="textBLUE">CHANDIGARH</a></li>
                            <li><a href="News?cat=CITY-CHENNAI"  id="textBLUE">CHENNAI</a></li>
                            <li><a href="News?cat=CITY-COIMBATORE"  id="textBLUE">COIMBATORE</a></li>
                            <li><a href="News?cat=CITY-DELHI"  id="textBLUE">DELHI</a></li>
                            <li><a href="News?cat=CITY-GOA"  id="textBLUE">GOA</a></li>
                            <li><a href="News?cat=CITY-GURGAON"  id="textBLUE">GURGAON</a></li>
                            <li><a href="News?cat=CITY-GUWAHATI"  id="textBLUE">GUWAHATI</a></li>
                            <li><a href="News?cat=CITY-HUBBALLI"  id="textBLUE">HUBBALLI</a></li>
                            <li><a href="News?cat=CITY-HYDERABAD"  id="textBLUE">HYDERABAD</a></li>
                            <li><a href="News?cat=CITY-KANPUR"  id="textBLUE">KANPUR</a></li>
                            <li><a href="News?cat=CITY-KOLKATA"  id="textBLUE">KOLKATA</a></li>
                            <li><a href="News?cat=CITY-LUCKNOW"  id="textBLUE">LUCKNOW</a></li>
                            <li><a href="News?cat=CITY-LUDHIANA"  id="textBLUE">LUDHIANA</a></li>
                            <li><a href="News?cat=CITY-MUMBAI"  id="textBLUE">MUMBAI</a></li>
                            <li><a href="News?cat=CITY-MYSURU"  id="textBLUE">MYSURU</a></li>
                            <li><a href="News?cat=CITY-NAGPUR"  id="textBLUE">NAGPUR</a></li>
                            <li><a href="News?cat=CITY-NOIDA"  id="textBLUE">NOIDA</a></li>
                            <li><a href="News?cat=CITY-PATNA"  id="textBLUE">PATNA</a></li>
                            <li><a href="News?cat=CITY-PUNE"  id="textBLUE">PUNE</a></li>
                            <li><a href="News?cat=CITY-RAJKOT"  id="textBLUE">RAJKOT</a></li>
                            <li><a href="News?cat=CITY-RANCHI"  id="textBLUE">RANCHI</a></li>
                            <li><a href="News?cat=CITY-SURAT"  id="textBLUE">SURAT</a></li>
                            <li><a href="News?cat=CITY-THANE"  id="textBLUE">THANE</a></li>
                            <li><a href="News?cat=CITY-THIRUVANANTHAPURAM"  id="textBLUE">THIRUVANANTHAPURAM</a></li>
                            <li><a href="News?cat=CITY-VADODARA"  id="textBLUE">VADODARA</a></li>
                            <li><a href="News?cat=CITY-VARANASI"  id="textBLUE">VARANASI</a></li>
                            </ul>
                        </li>
                       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="/NewsWeb/News"  id="textWhite" >SPORTS <span class="caret"></span></a>
                            <ul class="dropdown-menu" id="textBLACK">
                             <li><a href="News?cat=SPORTS-BADMINTON"  id="textBLUE">BADMINTON</a></li>
                            <li><a href="News?cat=SPORTS-BOXING"  id="textBLUE">BOXING</a></li>
                            <li><a href="News?cat=SPORTS-CRICKET"  id="textBLUE">CRICKET</a></li>
                            <li><a href="News?cat=SPORTS-FOOTBALL"  id="textBLUE">FOOTBALL</a></li>
                            <li><a href="News?cat=SPORTS-MORE-SPORTS"  id="textBLUE">MORE-SPORTS</a></li>
                            <li><a href="News?cat=SPORTS-NEW-ZEALAND-IN-INDIA-2016"  id="textBLUE">NEW-ZEALAND-IN-INDIA-2016</a></li>
                            <li><a href="News?cat=SPORTS-OFF-THE-FIELD"  id="textBLUE">OFF-THE-FIELD</a></li>
                            <li><a href="News?cat=SPORTS-TENNIS"  id="textBLUE">TENNIS</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="/NewsWeb/News"  id="textWhite" >WORLD <span class="caret"></span></a>
                            <ul class="dropdown-menu" id="textBLACK">
			<li><a href="News?cat=WORLD-CHINA"  id="textBLUE">CHINA</a></li>
                            <li><a href="News?cat=WORLD-EUROPE"  id="textBLUE">EUROPE</a></li>
                            <li><a href="News?cat=WORLD-MAD-MAD-WORLD"  id="textBLUE">MAD-MAD-WORLD</a></li>
                            <li><a href="News?cat=WORLD-MIDDLE-EAST"  id="textBLUE">MIDDLE-EAST</a></li>
                            <li><a href="News?cat=WORLD-PAKISTAN"  id="textBLUE">PAKISTAN</a></li>
                            <li><a href="News?cat=WORLD-REST-OF-WORLD"  id="textBLUE">REST-OF-WORLD</a></li>
                            <li><a href="News?cat=WORLD-SOUTH-ASIA"  id="textBLUE">SOUTH-ASIA</a></li>
                            <li><a href="News?cat=WORLD-UK"  id="textBLUE">UK</a></li>
                            <li><a href="News?cat=WORLD-US"  id="textBLUE">US</a></li>
                            </ul>
                        </li>
                        <li><a href="aboutus.jsp"  id="textWhite">About US</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>



