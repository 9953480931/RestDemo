function registerUser() {
       var oFormElement= document.getElementById('formdata');
       var formData = new FormData(oFormElement);
       var text = "{\"";
       for (var value of formData.entries()) {
         text += value.toString().replace(",","\":\"") + "\",\""; 
       }
       text += "\"}";
       var xhttp = new XMLHttpRequest();
         xhttp.onreadystatechange = function() {
           if (xhttp.readyState == 4 && xhttp.status == 200) {
             var returnText = xhttp.responseText;
             var object = {returnText};
             if(object['returnText'].indexOf("Unable") > 0){
                document.getElementById("errorDiv").innerHTML=object['returnText'];
             }else{
                window.location.href = object['returnText'];
             }
           }
         };
         xhttp.open("POST", "http://localhost:8080/RestDemo/rest/employee/add", false);
         xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
         xhttp.send("json="+text);
}
