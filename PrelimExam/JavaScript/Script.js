//Records - Gian Carlo J. Permison - 23-0322-603

// CSV
const csvData = `
StudentID,FirstName,LastName,Lab1,Lab2,Lab3,Prelim,Attendance
073900438,Osbourne,Wakenshaw,69,5,52,12,78
114924014,Albie,Gierardi,58,92,16,57,97
111901632,Eleen,Pentony,43,81,34,36,16
084000084,Arie,Okenden,31,5,14,39,99
272471551,Alica,Muckley,49,66,97,3,95
104900721,Jo,Burleton,98,94,33,13,29
111924392,Cam,Akram,44,84,17,16,24
292970744,Celine,Brosoli,3,15,71,83,45
107004352,Alan,Belfit,31,51,36,70,48
071108313,Jeanette,Gilvear,4,78,15,69,69
`;

let records = [];

// Parse CSV
const lines = csvData.trim().split("\n");
for (let i = 1; i < lines.length; i++) {
    const [
        studentId,
        firstName,
        lastName,
        lab1,
        lab2,
        lab3,
        prelim,
        attendance
    ] = lines[i].split(",");

    records.push({
        studentId,
        firstName,
        lastName,
        lab1,
        lab2,
        lab3,
        prelim,
        attendance
    });
}

// Render table
function render() {
    const tbody = document.getElementById("tableBody");
    tbody.innerHTML = "";

    records.forEach((r, index) => {
        tbody.innerHTML += `
        <tr>
            <td>${r.studentId}</td>
            <td>${r.firstName}</td>
            <td>${r.lastName}</td>
            <td>${r.lab1}</td>
            <td>${r.lab2}</td>
            <td>${r.lab3}</td>
            <td>${r.prelim}</td>
            <td>${r.attendance}</td>
            <td><button onclick="deleteRecord(${index})">Delete</button></td>
        </tr>`;
    });
}

// Add record
function addRecord() {
    records.push({
        studentId: studentId.value,
        firstName: firstName.value,
        lastName: lastName.value,
        lab1: lab1.value,
        lab2: lab2.value,
        lab3: lab3.value,
        prelim: prelim.value,
        attendance: attendance.value
    });
    render();
}

// Delete record
function deleteRecord(index) {
    records.splice(index, 1);
    render();
}

render();
