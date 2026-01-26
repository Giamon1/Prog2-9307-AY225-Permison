function compute() {
    let attendance = parseFloat(document.getElementById("attendance").value);
    let lab1 = parseFloat(document.getElementById("lab1").value);
    let lab2 = parseFloat(document.getElementById("lab2").value);
    let lab3 = parseFloat(document.getElementById("lab3").value);

    if (isNaN(attendance) || isNaN(lab1) || isNaN(lab2) || isNaN(lab3)) {
        alert("Please enter all values correctly.");
        return;
    }

    let labAvg = (lab1 + lab2 + lab3) / 3;
    let classStanding = (attendance * 0.40) + (labAvg * 0.60);

    let requiredPassing = (75 - (classStanding * 0.30)) / 0.70;
    let requiredExcellent = (100 - (classStanding * 0.30)) / 0.70;

    let out = `<div class="section-title">Results</div>`;
    out += `<p>Attendance: ${attendance.toFixed(2)}</p>`;
    out += `<p>Lab Work 1: ${lab1.toFixed(2)}</p>`;
    out += `<p>Lab Work 2: ${lab2.toFixed(2)}</p>`;
    out += `<p>Lab Work 3: ${lab3.toFixed(2)}</p>`;
    out += `<p>Lab Work Average: ${labAvg.toFixed(2)}</p>`;
    out += `<p>Class Standing: ${classStanding.toFixed(2)}</p>`;

    out += `<div class="section-title">Required Prelim Exam Scores</div>`;

    if (requiredPassing > 100) {
        out += `<p>To PASS (75): Impossible based on current Class Standing.</p>`;
    } else if (requiredPassing <= 0) {
        out += `<p>To PASS (75): Already guaranteed even with 0 exam score.</p>`;
    } else {
        out += `<p>To PASS (75): ${requiredPassing.toFixed(2)}</p>`;
    }

    if (requiredExcellent > 100) {
        out += `<p>To get EXCELLENT (100): Impossible based on current Class Standing.</p>`;
    } else if (requiredExcellent <= 0) {
        out += `<p>To get EXCELLENT (100): Already guaranteed even with 0 exam score.</p>`;
    } else {
        out += `<p>To get EXCELLENT (100): ${requiredExcellent.toFixed(2)}</p>`;
    }

    document.getElementById("output").innerHTML = out;
}

function clearFields() {
    document.getElementById("attendance").value = "";
    document.getElementById("lab1").value = "";
    document.getElementById("lab2").value = "";
    document.getElementById("lab3").value = "";
    document.getElementById("output").innerHTML = "";
}
