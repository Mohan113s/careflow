const API_URL = "http://localhost:8081/tickets";

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

async function loadStatus() {

    const container = document.getElementById("statusContainer");

    if (!container) return;

    container.innerHTML = "";

    const response = await fetch(API_URL);

    const tickets = await response.json();

    tickets.forEach(ticket => {

        let width = 40;

        if (ticket.status === "In Progress") width = 70;

        if (ticket.status === "Resolved") width = 100;

        container.innerHTML += `

        <div class="ticket-card">

            <h3>${ticket.title}</h3>

            <p><b>Ticket ID:</b> ${ticket.id}</p>

            <p><b>Status:</b> ${ticket.status}</p>

            <p class="agent">Assigned Agent : Sarah Johnson</p>

            <p class="ai-score">AI Confidence : 92%</p>

            <div class="progress">

                <div class="progress-bar"

                style="width:${width}%">

                </div>

            </div>

        </div>

        `;

    });

}

loadStatus();