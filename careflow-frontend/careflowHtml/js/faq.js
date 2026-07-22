const faqs = [

{
question:"How can I track my order?",
answer:"Go to My Orders in your account to track the shipment."
},

{
question:"How do I cancel my order?",
answer:"Orders can be cancelled before they are shipped."
},

{
question:"How long does a refund take?",
answer:"Refunds are usually processed within 5-7 business days."
},

{
question:"Payment failed. What should I do?",
answer:"Check your payment details or try another payment method."
},

{
question:"How can I contact customer support?",
answer:"Use the AI Chat or create a support ticket."
}

];

const container=document.getElementById("faqContainer");

function loadFaq(){

container.innerHTML="";

faqs.forEach((faq,index)=>{

container.innerHTML +=`

<div class="faq-item">

<div class="question"

onclick="toggleAnswer(${index})">

${faq.question}

</div>

<div
class="answer"
id="answer${index}">

${faq.answer}

</div>

</div>

`;

});

}

loadFaq();

function toggleAnswer(index){

const answer=document.getElementById("answer"+index);

if(answer.style.display==="block")

answer.style.display="none";

else

answer.style.display="block";

}

function searchFaq(){

const input=document.getElementById("searchFaq").value.toLowerCase();

const items=document.querySelectorAll(".faq-item");

items.forEach(item=>{

if(item.innerText.toLowerCase().includes(input))

item.style.display="block";

else

item.style.display="none";

});

}