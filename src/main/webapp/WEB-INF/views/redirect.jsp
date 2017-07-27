
<h3>This is view</h3>
<html>
 
<head>
 
 
<script>
 
  function gup( name, url ) {
 
    if (!url) url = location.href;
 
    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
 
    var regexS = "[\\?&]"+name+"=([^&#]*)";
 
    var regex = new RegExp( regexS );
 
    var results = regex.exec( url );
 
    return results == null ? null : results[1];
 
  }
 
   
 
  var outString="";
 
  var idToken = gup('id_token');
 
  if (idToken!=null) outString = (JSON.parse(atob(idToken.split(/\./)[1])));
 
  if (idToken!=null) console.log(outString);
 
  if (idToken!=null) alert("Hello "+outString.sub);
  
  function setCookie(cname,cvalue,exdays) {
	    var d = new Date();
	    d.setTime(d.getTime() + (exdays*24*60*60*1000));
	    var expires = "expires=" + d.toGMTString();
	    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
	}

	function getCookie(cname) {
	    var name = cname + "=";
	    var decodedCookie = decodeURIComponent(document.cookie);
	    var ca = decodedCookie.split(';');
	    for(var i = 0; i < ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0) == ' ') {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) {
	            return c.substring(name.length, c.length);
	        }
	    }
	    return "";
	}

	function checkCookie() {
	    var user=getCookie("username");
	    if (user != "") {
	        alert("Welcome again " + user);
	    } else {
	       user = prompt("Please enter your name:","");
	       if (user != "" && user != null) {
	           setCookie("username", user, 30);
	       }
	    }
	}
	
  var x = getCookie("iPlanetDirectoryPro");
  console.log("Cookies iPlanetDirectoryPro:");
  console.log(x);
 
</script>
 
 
</head>
 
<body>
 
<h3>This is the dashboard page!</h3>
</body>
 
</html> 