function getXMLHTTPRequest() {
var req;
try {
	req = new XMLHttpRequest();
} catch(err1) {
	try {
		req = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (err2) {
		try {
			req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (err3) {
				req = false;
			}
		}
	}
	return req;
}

http = getXMLHTTPRequest();
http2 = getXMLHTTPRequest();
http3 = getXMLHTTPRequest();

function getHTTP(archivo,vars,divid){
	myRand = parseInt(Math.random()*999999999999999);
	var modurl = archivo +"?rand=" + myRand + vars; 
	http.open("GET", modurl, true);
	mydiv = divid;
	http.onreadystatechange = useHTTP;
	http.send(null);
}

function useHTTP() {
	if (http.readyState == 4) {
		if(http.status == 200) {
			var miTexto = http.responseText;
			document.getElementById(mydiv).innerHTML = (miTexto);
		}
	} 
	 //else {
		//document.getElementById(mydiv2).innerHTML = '<br><br><center><img src="ajax/cargando.gif"></center>';
//	}
//	else {
//	document.getElementById(mydiv).innerHTML = 'Procesando...';
//	}
}

function getHTTP2(archivo2,vars2,divid2){
	myRand2 = parseInt(Math.random()*999999999999999);
	var modurl2 = archivo2 +"?rand2=" + myRand2 + vars2; 
	http2.open("GET", modurl2, true);
	mydiv2 = divid2;
	http2.onreadystatechange = useHTTP2;
	http2.send(null);
}

function useHTTP2() {
	if (http2.readyState == 4) {
		if(http2.status == 200) {
			var miTexto2 = http2.responseText;
			document.getElementById(mydiv2).innerHTML = (miTexto2);
		}
	} //else {
		//document.getElementById(mydiv2).innerHTML = '<br><br><center><img src="ajax/cargando.gif"></center>';
	//}
}



function getHTTP3(archivo3,vars3,divid3){
	myRand3 = parseInt(Math.random()*999999999999999);
	var modurl3 = archivo3 +"?rand3=" + myRand3 + vars3; 
	http3.open("GET", modurl3, true);
	mydiv3 = divid3;
	http3.onreadystatechange = useHTTP3;
	http3.send(null);
}

function useHTTP3() {
	if (http3.readyState == 4) {
		if(http3.status == 200) {
			var miTexto3 = http3.responseText;
			document.getElementById(mydiv3).innerHTML = (miTexto3);
		}
	} //else {
		//document.getElementById(mydiv3).innerHTML = '<br><br><center><img src="ajax/cargando.gif"></center>';
	//}
}