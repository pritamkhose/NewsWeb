/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var animalContainer = document.getElementById("animal-info");
var btn = document.getElementById("btn");
var pageCount = 1;

var ourRequest = new XMLHttpRequest();
// url fire on page load
ourRequest.open('GET','https://learnwebcode.github.io/json-example/animals-'+pageCount+'.json');
ourRequest.onload = function(){
   var ourData = JSON.parse(ourRequest.responseText);
    renderHtml(ourData);
};
ourRequest.send();
pageCount++;


// on click btn data url fire
btn.addEventListener("click", function(){

ourRequest.open('GET','https://learnwebcode.github.io/json-example/animals-'+pageCount+'.json');
if(pageCount > 3){
    btn.classList.add('hide-me');
}
ourRequest.onload = function(){
    if(ourRequest.status >= 200 && ourRequest.status <= 400 ){
    var ourData = JSON.parse(ourRequest.responseText);
    //console.log(ourData[0]);
    renderHtml(ourData);
    } else {
        console.log("connection to server but get error" + ourRequest.error());
        alert("connection to server but get error is " + ourRequest.error());
    }
};
ourRequest.error = function(){
     console.log("connection error");
     alert("connection error");
};
ourRequest.send();
pageCount++;
});


// add html to page
function renderHtml(data){
    var htmlStr = "";
    
    for(i =0; i < data.length; i++){
        htmlStr += "<p> "+ data[i].name + " is a " + data[i].species +" that like to eat is ";
        
        for(ii =0; ii < data[i].foods.likes.length; ii++){
            if(ii == 0){
                 htmlStr += data[i].foods.likes[ii] ;
            } else {
                htmlStr +=  ", " +data[i].foods.likes[ii] ;
            }
        }
        
        htmlStr +=  " and dislikes ";
        
        for(ii =0; ii < data[i].foods.dislikes.length; ii++){
            if(ii == 0){
                 htmlStr += data[i].foods.dislikes[ii] ;
            } else {
                htmlStr +=  ", " +data[i].foods.dislikes[ii] ;
            }
        }
        
        htmlStr +=  " </p>";
    }
    animalContainer.insertAdjacentHTML('beforeend',htmlStr);
};

// on hit url check brower console
//var ourRequest = new XMLHttpRequest();
//ourRequest.open('GET','https://learnwebcode.github.io/json-example/animals-1.json');
//ourRequest.onload = function(){
////    console.log(ourRequest.responseText);
//    var ourData = JSON.parse(ourRequest.responseText);
//    console.log(ourData[0]);
//};
//ourRequest.send();