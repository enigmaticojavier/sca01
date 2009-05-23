<script language="javascript">
var w3c=(document.getElementById)?true:false;
var ie4=(document.all && !w3c)?true:false;
var ie5=(document.all && w3c)?true:false;
var ns4=(document.layers)?true:false;
var ns6=(w3c && !document.all)?true:false;
var mi=0; var yi=0;
var calA=new Array();
var cal_m, cal_y, cal, calS, now;

function setMonth(incr){
if(!ns4){
mi+=(incr)?1:-1;
if(mi>11)mi=0;
if(mi<0)mi=11;
now.setMonth(mi);
updateCalender();
}}

function setYear(incr){
if(!ns4){
yi+=(incr)?1:-1;
if(yi>50)yi=0;
if(yi<0)yi=50;
now.setFullYear(yi+1970);
updateCalender();
}}

function updateCalender(){
var dim=[31,0,31,30,31,30,31,31,30,31,30,31];
dim[1]=(((now.getFullYear()%100!=0)&&(now.getFullYear()%4==0))||(now.getFullYear()%400==0))?29:28;
cal_m.innerHTML=['January','February','March','April','May','June','July','August','September','October','November','December'][mi];
cal_y.innerHTML=yi+1970;
var offsetD=new Date();
offsetD.setFullYear(yi+1970);
offsetD.setMonth(mi);
offsetD.setDate(1);
offsetD=offsetD.getDay()+1;
for(i=1;i<=42;i++){
if((i-offsetD>=0)&&(i-offsetD<dim[mi])){
calA[i].innerHTML=i-offsetD+1;
calA[i].i=i;
calA[i].o=offsetD;
calA[i].className=((now.ref.getDate()==i-offsetD+1)&&(now.ref.getFullYear()==now.getFullYear())&&(now.ref.getMonth()==now.getMonth()))?"calToday":"calText";
}else{
calA[i].className="calText";
calA[i].innerHTML=' ';
}}}

window.onload=function(){
if(!ns4){
for(i=1;i<=42;i++)calA[i]=(ie4)?document.all['cal'+i]:document.getElementById('cal'+i);
cal_m=(ie4)?document.all["calender_m"]:document.getElementById("calender_m");
cal_y=(ie4)?document.all["calender_y"]:document.getElementById("calender_y");
cal=(ie4)?document.all["calender"]:document.getElementById("calender");
calS=(ie4)?document.all["calenderS"]:document.getElementById("calenderS");
calS.style.height=((ie4||ie5)?cal.clientHeight:(w3c)?cal.offsetHeight:200)+'px';
calS.style.width=((ie4||ie5)?cal.clientWidth:(w3c)?cal.offsetWidth:300)+'px';
cal.parentNode.style.width=parseInt(calS.style.width)+10+'px';
cal.parentNode.style.height=parseInt(calS.style.height)+10+'px';
now=new Date(); now.ref=new Date();
mi=now.getMonth(); yi=now.getFullYear()-1970;
updateCalender();
}
// ADD OTHER WINDOW ONLOAD EVENTS HERE...

</script>
