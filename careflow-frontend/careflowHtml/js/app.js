const button = document.getElementById("themeBtn");

button.addEventListener("click", function () {

    document.body.classList.toggle("dark");

    if(document.body.classList.contains("dark")){

        button.innerHTML="Light Mode";

    }else{

        button.innerHTML="Dark Mode";

    }

});

fetch("http://localhost:8081/dashboard")

.then(res=>res.json())

.then(data=>{

document.getElementById("totalTickets").innerHTML=data.totalTickets;

document.getElementById("openTickets").innerHTML=data.openTickets;

document.getElementById("resolvedTickets").innerHTML=data.resolvedTickets;

document.getElementById("totalChats").innerHTML=data.totalChats;

let table=document.getElementById("recentTickets");

table.innerHTML="";

data.recentTickets.forEach(ticket=>{

table.innerHTML+=`

<tr>

<td>${ticket.id}</td>

<td>${ticket.title}</td>

<td>${ticket.status}</td>

</tr>

`;

});

});