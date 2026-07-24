const API_URL = "https://careflow-h34p.onrender.com/tickets";

/* CREATE TICKET */

const form = document.getElementById("ticketForm");

if (form) {

    form.addEventListener("submit", async function (e) {

        e.preventDefault();

        const ticket = {

            title: document.getElementById("title").value,
            category: document.getElementById("category").value,
            priority: document.getElementById("priority").value,
            description: document.getElementById("description").value,
            status: "Open",
            userEmail: "",
            resolution: ""

        };

        try {

            const response = await fetch(API_URL, {

                method: "POST",

                headers: {

                    "Content-Type": "application/json"

                },

                body: JSON.stringify(ticket)

            });

            if (response.ok) {

                alert("Ticket Created Successfully!");

                form.reset();

            } else {

                alert("Unable to create ticket.");

            }

        } catch (err) {

            console.error(err);

        }

    });

}

/* LOAD TICKETS */

async function loadTickets() {

    const table = document.getElementById("ticketTable");

    if (!table) return;

    table.innerHTML = "";

    try {

        const response = await fetch(API_URL);

        const tickets = await response.json();

        tickets.forEach(ticket => {

            table.innerHTML += `

            <tr>

                <td>${ticket.id}</td>

                <td>${ticket.title}</td>

                <td>${ticket.category}</td>

                <td>${ticket.priority}</td>

                <td>${ticket.status}</td>

                <td>

                    <button class="deleteBtn"

                    onclick="deleteTicket(${ticket.id})">

                    Delete

                    </button>

                </td>

            </tr>

            `;

        });

    } catch (err) {

        console.error(err);

    }

}

loadTickets();

/* DELETE */

async function deleteTicket(id) {

    if (!confirm("Delete Ticket?")) return;

    await fetch(API_URL + "/" + id, {

        method: "DELETE"

    });

    loadTickets();

}

/* SEARCH */

function searchTicket() {

    const input = document.getElementById("search").value.toLowerCase();

    const rows = document.querySelectorAll("#ticketTable tr");

    rows.forEach(row => {

        row.style.display = row.innerText.toLowerCase().includes(input)

            ? ""

            : "none";

    });

}

/* STATUS */

/* STATUS */

async function loadStatus() {

    const container = document.getElementById("statusContainer");

    if (!container) return;

    container.innerHTML = "";

    try {

        const response = await fetch(API_URL);

        const tickets = await response.json();


        tickets.forEach(ticket => {


            let statusClass = "";

            if(ticket.status === "Open"){
                statusClass = "open";
            }
            else if(ticket.status === "In Progress"){
                statusClass = "progress";
            }
            else if(ticket.status === "Resolved"){
                statusClass = "closed";
            }



            container.innerHTML += `


            <div class="status-card">


                <div class="status-header">


                    <h3>${ticket.title}</h3>


                    <span class="status-badge ${statusClass}">
                        ${ticket.status}
                    </span>


                </div>



                <div class="ticket-id">

                    Ticket ID : #${ticket.id}

                </div>



                <div class="status-details">


                    <p>
                    <i class="fa-solid fa-layer-group"></i>
                    Category : ${ticket.category}
                    </p>



                    <p>
                    <i class="fa-solid fa-flag"></i>
                    Priority : ${ticket.priority}
                    </p>



                    <p>
                    <i class="fa-solid fa-user"></i>
                    Assigned Agent : Sarah Johnson
                    </p>



                    <p>
                    <i class="fa-solid fa-robot"></i>
                    AI Confidence : 92%
                    </p>


                </div>


            </div>


            `;


        });


    } catch(err){

        console.error("Status Loading Error:",err);

    }

}

loadStatus();