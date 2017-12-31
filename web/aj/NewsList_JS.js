/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var ourRequest = new XMLHttpRequest();
//ourRequest.open('GET', 'http://newsweb.us-east-1.elasticbeanstalk.com/MCtrl?req=list&search=');
ourRequest.open('GET', 'http://localhost:8880/NewsWeb/MCtrl?req=list&search=');
ourRequest.onload = function() {
  if (ourRequest.status >= 200 && ourRequest.status < 400) {
    var data = JSON.parse(ourRequest.responseText);
    console.log(data);
    createHTML(data);
  } else {
    console.log("We connected to the server, but it returned an error.");
  }
};

ourRequest.onerror = function() {
  console.log("Connection error");
};

ourRequest.send();

function createHTML(petsData) {
  var rawTemplate = document.getElementById("petsTemplate").innerHTML;
  var compiledTemplate = Handlebars.compile(rawTemplate);
  var ourGeneratedHTML = compiledTemplate(petsData);

  var petsContainer = document.getElementById("pets-container");
  petsContainer.innerHTML = ourGeneratedHTML;
}