<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript">
            function changedata(x)
            {
//                window.location.replace('http://newsweb.us-east-1.elasticbeanstalk.com/Edit?id='+x+".0");
                window.location.replace('?id='+x+".0");
            }
        </script>
    </head>

    <body>
        <%@ include file = "header.jsp" %>

        <form>
            <div>
                <div class="row">
                    <div id="myDIVLeft" class="col-sm-3" align="left" >  
<!--                        <h4><b><c:out value="${param.cat}" /></b></h4>-->
<!--                       <select name="catlist" id="mySelect" onChange="window.location.replace(this.value)" >  
                            <c:forEach items="${catlist}" var="catlist">
                                <option value="${catlist}" ${item.cat == catlist ? 'selected' : ''}>${catlist}</option>
                            </c:forEach>
                        </select>-->
                    </div>
                    <div class="col-sm-5" align="center">
<!--                        <h4><b>List of News</b></h4>-->
                    </div>
                    <div id="myDIVRight" class="col-sm-4" align="right" >
                        <div class="search-container">
                            <div class="ui-widget">
                                <input type="text" id="search" name="search" class="search"  placeholder="   Search  "/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </form>

        <div style="overflow-x:auto;">
            <table>
                <!--                <tr>
                                    <th>id</th>
                                    <th>Article Link</th>
                                     <th>cat</th>
                                     <th>heading1</th>
                                     <th>time_date</th>
                                    <th>  </th>
                                </tr>-->
                <c:forEach var="item" items="${list}">
                    <tr>
<!--                        <td><a href="Edit?id=<c:out value='${item.id}' />"><c:out value="${item.cat}" /></a></td>
                        <td><a href="Edit?id=<c:out value='${item.id}' />"><c:out value="${item.heading1}" /></a></td>
                        <td><a href="Edit?id=<c:out value='${item.id}' />"><c:out value="${item.time_date}" /></a></td>-->

                    <div class="w3-container">
                        <div class="w3-card-4" style="width:100%">
                            <header class="w3-container w3-light-grey">
                                <h4><a href="News?id=<c:out value='${item.id}' />"><c:out value="${item.heading1}"/></a></h4>
                            </header>
                            <div class="w3-container">
                                <img style='object-fit: contain' src="${item.image}" onclick="changedata(${item.id});" onerror="this.src='https://s3.amazonaws.com/elasticbeanstalk-us-east-1-623485753983/img/No-image-found.jpg'" alt="No Image Found" class="img-responsive" style="width:200px">
                                </br>
                            </div>
                                <div class="w3-container"> 
                                <p><b>${item.data}</b></p>
                                <p ><font color="black"></font></p>
<!--                                <p align="right"><font color="blue">${item.cat}  <i>${item.time_cptn}</i></font></p>-->
                            <p align="right"><font color="blue"<i>${item.time_cptn}</i></font></p>
                            </div>
                        </div>
                    </div>
                    </tr>
                </c:forEach>
            </table>

        </div>	
        <%@ include file = "footer.jsp" %>
    </body>
</html>
