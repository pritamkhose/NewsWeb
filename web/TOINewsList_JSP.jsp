<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script type="text/javascript">
            function changedata(x)
            {
                window.location.replace('?id=' + x + ".0");
            }
        </script>
    </head>

    <body>
        <script>
            var animalContainer = document.getElementById("animal-info");
            var app = angular.module('myApp', []);
            app.controller('myCtrl', function ($scope, $http) {
                $http.get("http://newsweb.us-east-1.elasticbeanstalk.com/MCtrl?req=list&search=pune")
                        .then(function (response) {
                            $scope.data = response.data;
                    
                            //var ourData = data;
                          
                            renderHtml();
                        });
            });

            function renderHtml(data) {
                var htmlStr = " hi ";
//            for (i = 0; i < data.length; i++){
//            htmlStr += "<p> " + data[i].id + " is a " + data[i].cat + " ";
//           
//            }
//
//            htmlStr += " </p>";
//            }
                animalContainer.insertAdjacentHTML('beforeend', htmlStr);
            }
            ;
        </script>  
        <%@ include file = "header.jsp" %>


        <form>
            <div>
                <div class="row">
                    <div class="col-sm-5" align="center">
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



        <div ng-app="myApp" ng-controller="myCtrl"> 
            <p>{{data.ErrorID}}</p>
            <!-- <p>{{data.NewsList}}</p>-->
            <div id="animal-info" > </div>


        </div>
        <%@ include file = "footer.jsp" %>    


    </body>
</html>
