// =========================
// TASK 1 - BASICS & SETUP
// =========================

console.log("Welcome to the Community Portal");

window.onload = () => {
    alert("Community Portal Loaded Successfully");
};

// =========================
// TASK 2 - DATA TYPES
// =========================

const portalName = "Community Portal";
const launchYear = 2026;

let totalRegistrations = Number(
    localStorage.getItem("registrations")
) || 0;

console.log(`${portalName} - ${launchYear}`);

// =========================
// TASK 5 - OBJECTS & PROTOTYPES
// =========================

class Event {

    constructor(
        id,
        name,
        category,
        location,
        date,
        seats
    ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.location = location;
        this.date = date;
        this.seats = seats;
    }
}

Event.prototype.checkAvailability =
function () {
    return this.seats > 0;
};

// =========================
// EVENTS ARRAY
// =========================

let events = [

    new Event(
        1,
        "Music Festival",
        "Music",
        "Chennai",
        "2027-01-10",
        25
    ),

    new Event(
        2,
        "Baking Workshop",
        "Workshop",
        "Coimbatore",
        "2027-02-15",
        20
    ),

    new Event(
        3,
        "Football Tournament",
        "Sports",
        "Madurai",
        "2027-03-20",
        15
    )
];

// =========================
// TASK 4 - CLOSURE
// =========================

function registrationTracker() {

    let count = 0;

    return function () {

        count++;

        console.log(
            "Registrations Count:",
            count
        );
    };
}

const trackRegistration =
registrationTracker();

// =========================
// DOM ELEMENTS
// =========================

const eventContainer =
document.getElementById(
    "eventContainer"
);

const categoryFilter =
document.getElementById(
    "categoryFilter"
);

const searchInput =
document.getElementById(
    "search"
);

const eventSelect =
document.getElementById(
    "eventSelect"
);

// =========================
// DASHBOARD STATS
// =========================

function updateStats() {

    const totalSeats =
    events.reduce(
        (sum, event) =>
        sum + event.seats,
        0
    );

    document.getElementById(
        "totalEvents"
    ).textContent =
    events.length;

    document.getElementById(
        "totalRegs"
    ).textContent =
    totalRegistrations;

    document.getElementById(
        "availableSeats"
    ).textContent =
    totalSeats;
}

// =========================
// TASK 7 - DOM MANIPULATION
// =========================

function displayEvents(
    eventList = events
) {

    eventContainer.innerHTML = "";

    eventSelect.innerHTML =
    '<option value="">Select Event</option>';

    eventList.forEach(event => {

        const card =
        document.createElement("div");

        card.className =
        "event-card";

        card.innerHTML = `
            <h3>${event.name}</h3>

            <p>
                Category:
                ${event.category}
            </p>

            <p>
                Location:
                ${event.location}
            </p>

            <p>
                Date:
                ${event.date}
            </p>

            <p>
                Seats:
                ${event.seats}
            </p>

            <button
            onclick="registerUser(${event.id})">
            Register
            </button>
        `;

        eventContainer.appendChild(
            card
        );

        const option =
        document.createElement(
            "option"
        );

        option.value =
        event.name;

        option.textContent =
        event.name;

        eventSelect.appendChild(
            option
        );
    });

    updateStats();
}

// =========================
// TASK 3 - CONDITIONALS
// ERROR HANDLING
// =========================

function registerUser(id) {

    try {

        const event =
        events.find(
            e => e.id === id
        );

        if (!event) {
            throw new Error(
                "Event not found"
            );
        }

        if (event.seats <= 0) {
            throw new Error(
                "No seats available"
            );
        }

        event.seats--;

        totalRegistrations++;

        localStorage.setItem(
            "registrations",
            totalRegistrations
        );

        trackRegistration();

        displayEvents();

        alert(
            "Registration Successful"
        );

    } catch(error) {

        console.error(error);

        alert(error.message);
    }
}

// =========================
// TASK 6 - ARRAYS
// =========================

const musicEvents =
events.filter(
    event =>
    event.category === "Music"
);

console.log(musicEvents);

const eventNames =
events.map(
    event =>
    `Workshop on ${event.name}`
);

console.log(eventNames);

events.forEach(event => {

    console.log(
        Object.entries(event)
    );
});

// =========================
// TASK 8 - EVENT HANDLING
// =========================

categoryFilter.addEventListener(
    "change",
    () => {

        const category =
        categoryFilter.value;

        if (
            category === "All"
        ) {
            displayEvents();
            return;
        }

        const filtered =
        events.filter(
            event =>
            event.category === category
        );

        displayEvents(filtered);
    }
);

searchInput.addEventListener(
    "keyup",
    () => {

        const keyword =
        searchInput.value
        .toLowerCase();

        const filtered =
        events.filter(event =>
            event.name
            .toLowerCase()
            .includes(keyword)
        );

        displayEvents(filtered);
    }
);

// =========================
// ADD EVENT FORM
// =========================

document
.getElementById("eventForm")
.addEventListener(
"submit",
function(event){

    event.preventDefault();

    const eventName =
    document.getElementById(
        "eventName"
    ).value;

    const category =
    document.getElementById(
        "eventCategory"
    ).value;

    const location =
    document.getElementById(
        "eventLocation"
    ).value;

    const seats =
    parseInt(
        document.getElementById(
            "eventSeats"
        ).value
    );

    const newEvent =
    new Event(
        Date.now(),
        eventName,
        category,
        location,
        "2027-01-01",
        seats
    );

    events.push(newEvent);

    displayEvents();

    this.reset();

    alert("Event Added");
});

// =========================
// TASK 11 - FORMS
// =========================

document
.getElementById(
    "registrationForm"
)
.addEventListener(
"submit",
async function(event){

    event.preventDefault();

    const name =
    this.elements["name"]
    .value;

    const email =
    this.elements["email"]
    .value;

    const selectedEvent =
    this.elements["event"]
    .value;

    const msg =
    document.getElementById(
        "msg"
    );

    if(
        name.trim() === ""
    ){

        msg.innerHTML =
        "Name Required";

        return;
    }

    if(
        !email.includes("@")
    ){

        msg.innerHTML =
        "Invalid Email";

        return;
    }

    // =====================
    // TASK 12 AJAX
    // =====================

    msg.innerHTML =
    "Submitting...";

    setTimeout(
    async () => {

        try {

            const response =
            await fetch(
            "https://jsonplaceholder.typicode.com/posts",
            {
                method:"POST",

                headers:{
                    "Content-Type":
                    "application/json"
                },

                body:
                JSON.stringify({
                    name,
                    email,
                    selectedEvent
                })
            });

            const result =
            await response.json();

            console.log(result);

            msg.innerHTML =
            "Registration Successful";

        } catch(error){

            console.error(error);

            msg.innerHTML =
            "Registration Failed";
        }

    },2000);
});

// =========================
// TASK 9
// PROMISES + ASYNC
// =========================

function fetchEventsPromise(){

    return fetch(
        "https://jsonplaceholder.typicode.com/users"
    )

    .then(response =>
        response.json()
    )

    .then(data => {

        console.log(
            "Promise Data",
            data
        );
    })

    .catch(error => {

        console.error(error);
    });
}

async function fetchEventsAsync(){

    try{

        const response =
        await fetch(
        "https://jsonplaceholder.typicode.com/users"
        );

        const data =
        await response.json();

        console.log(
            "Async Data",
            data
        );

    }catch(error){

        console.error(error);
    }
}

// =========================
// TASK 13 DEBUGGING
// =========================

console.log(
    "Application Started"
);

console.log(
    "Events Loaded:",
    events
);

// =========================
// TASK 10 MODERN JS
// =========================

const clonedEvents =
[...events];

const {
    name:firstEventName
} = events[0];

console.log(
    firstEventName
);

console.log(
    clonedEvents
);

// =========================
// INITIAL LOAD
// =========================

displayEvents();

fetchEventsPromise();

fetchEventsAsync();