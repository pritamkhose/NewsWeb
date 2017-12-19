<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript">
            function changedata(x)
            {
                window.location.replace(x);
            }
        </script>
   
    </head>

    <body>
        <%@ include file = "header.jsp" %>


        <div style="overflow-x:auto;">
            <table>
                <c:forEach var="item" items="${list}">
                    <tr>
                    <div class="w3-container">
                        <div class="w3-card-4" style="width:100%">
                            <header class="w3-container w3-light-grey">
                                <h3><a href="<c:out value='${item.articlelink}' />"><c:out value="${item.heading1}"/></a></h3>
                            </header>
                            <div class="w3-container">
                             <p align="right"><font color="black"><b>${item.cat}</b></font></p>
                                <br/>
                            </div>
                            <div class="w3-container">
                                <img style='object-fit: contain' src="${item.image}" onclick="changedata(${item.image});" class="img-responsive" alt="https://s3.amazonaws.com/elasticbeanstalk-us-east-1-623485753983/img/No-image-found.jpg" >
                            </div>
                             <div class="w3-container">
                                 <br/>
                                 <p><b>${item.data}</b></p>
                            </div>
                          <div class="w3-container">
                                 <br/>
                            <p align="right"><font color="black"> ${item.auth_detail}</font></p>
                            <p align="right"><font color="blue">  <i>${item.time_cptn}</i></font></p>
                          </div>
                    </div>
                    </tr>
                </c:forEach>
            </table>

        </div>	
        <%@ include file = "footer.jsp" %>
    </body>
</html>
