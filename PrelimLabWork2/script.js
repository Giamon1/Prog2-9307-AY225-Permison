//  login credentials
const users = [
    { username: "admin", password: "123" },
    { username: "Gian", password: "123" },
    { username: "John", password: "123" },
    { username: "Bon", password: "123" },
    { username: "Tom", password: "123" }
];

// Audio for incorrect login
const beep = new Audio('beep.mp3');

// Attendance store
let attendanceRecord = [];

// Track users who already logged in
let loggedUsers = new Set();

const loginForm = document.getElementById("loginForm");
const errorMsg = document.getElementById("errorMsg");
const clearBtn = document.getElementById("clearBtn");

loginForm.addEventListener("submit", function(event) {
    event.preventDefault();

    let userInput = document.getElementById("username").value;
    let passInput = document.getElementById("password").value;

    let validUser = users.find(user => user.username === userInput && user.password === passInput);

    if (validUser) {

        // Prevent duplicate logins
        if (loggedUsers.has(validUser.username)) {
            errorMsg.textContent = `${validUser.username} already logged attendance.`;
            return;
        }

        let now = new Date();
        let timestamp = now.toLocaleDateString() + " " + now.toLocaleTimeString();

        document.getElementById("welcome").textContent = `Welcome ${validUser.username}!`;
        document.getElementById("timestamp").textContent = "Logged in at: " + timestamp;

      
        attendanceRecord.push({
            username: validUser.username,
            time: timestamp
        });

        loggedUsers.add(validUser.username);

        document.getElementById("downloadBtn").style.display = "block";
        clearBtn.style.display = "block";

        // Display table 
        const attendanceTable = document.getElementById("attendanceTable");
        attendanceTable.style.display = "table";

        let row = attendanceTable.insertRow();
        let cell1 = row.insertCell(0);
        let cell2 = row.insertCell(1);

        cell1.style.border = "1px solid #999";
        cell1.style.padding = "6px";
        cell2.style.border = "1px solid #999";
        cell2.style.padding = "6px";

        cell1.textContent = validUser.username;
        cell2.textContent = timestamp;

        errorMsg.textContent = "";

    } else {
        beep.play();
        errorMsg.textContent = "Incorrect username or password. Please try again.";

        document.getElementById("welcome").textContent = "";
        document.getElementById("timestamp").textContent = "";
    }
});

document.getElementById("downloadBtn").addEventListener("click", function () {
    let csvContent = "Username,Timestamp\n";

    attendanceRecord.forEach(record => {
        csvContent += `${record.username},${record.time}\n`;
    });

    const blob = new Blob([csvContent], { type: "text/csv" });
    const link = document.createElement("a");

    link.href = URL.createObjectURL(blob);
    link.download = "attendance_summary.csv";
    link.click();
});

// Clear button function
clearBtn.addEventListener("click", function() {
    attendanceRecord = [];
    loggedUsers.clear();

    document.getElementById("attendanceTable").innerHTML = `
        <tr style="background:#eee;">
            <th style="border:1px solid #999; padding:8px;">Username</th>
            <th style="border:1px solid #999; padding:8px;">Timestamp</th>
        </tr>
    `;

    // Hide table completely
    const attendanceTable = document.getElementById("attendanceTable");
    attendanceTable.style.display = "none";
    
    // Reset welcome message and timestamp
    document.getElementById("welcome").textContent = "";
    document.getElementById("timestamp").textContent = "";

    clearBtn.style.display = "none";
    document.getElementById("downloadBtn").style.display = "none";
});
