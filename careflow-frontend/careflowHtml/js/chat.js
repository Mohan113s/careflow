async function sendMessage() {

    let input = document.getElementById("message");
    let text = input.value.trim();

    if (text === "") return;

    let chat = document.getElementById("chatBox");
    let typing = document.getElementById("typing");

    // User Message
    let user = document.createElement("div");
    user.className = "message user";
    user.innerHTML = `
        <div class="bubble">
            ${text}
        </div>
    `;

    chat.appendChild(user);

    input.value = "";

    chat.scrollTop = chat.scrollHeight;

    typing.style.display = "block";

    try {

        const response = await fetch("http://localhost:8081/api/chat", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                message: text
            })

        });

        const data = await response.json();

        typing.style.display = "none";

        let ai = document.createElement("div");

        ai.className = "message ai";

        ai.innerHTML = `
            <div class="avatar">
                <i class="fa-solid fa-robot"></i>
            </div>

            <div class="bubble">

                <strong>CareFlow AI</strong>

                <br><br>

                ${data.reply}

            </div>
        `;

        chat.appendChild(ai);

    } catch (error) {

        typing.style.display = "none";

        let ai = document.createElement("div");

        ai.className = "message ai";

        ai.innerHTML = `
            <div class="avatar">
                <i class="fa-solid fa-triangle-exclamation"></i>
            </div>

            <div class="bubble">

                <strong>Error</strong>

                <br><br>

                Unable to connect to CareFlow Server.

            </div>
        `;

        chat.appendChild(ai);

        console.error(error);
    }

    chat.scrollTop = chat.scrollHeight;
}

function quickMessage(text) {

    document.getElementById("message").value = text;

    sendMessage();
}

function transferAgent() {

    let chat = document.getElementById("chatBox");

    let msg = document.createElement("div");

    msg.className = "message ai";

    msg.innerHTML = `
        <div class="avatar">
            <i class="fa-solid fa-headset"></i>
        </div>

        <div class="bubble">

            👨‍💼 Your conversation has been transferred to a Human Support Agent.

        </div>
    `;

    chat.appendChild(msg);

    chat.scrollTop = chat.scrollHeight;
}