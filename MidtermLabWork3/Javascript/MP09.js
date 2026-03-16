const fs = require("fs");
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter CSV file path: ", function(path) {

    let total = 0;
    let pass = 0;
    let fail = 0;

    try {
        const data = fs.readFileSync(path, "utf8");
        const rows = data.split("\n");

        rows.forEach(row => {
            row = row.trim();
            if (!row.startsWith('"')) return;

            const parts = row.split('",');
            if (parts.length < 2) return;

            const columns = parts[1].split(",");

            total++;
            const result = columns[6].trim().toUpperCase();

            if (result === "PASS") pass++;
            if (result === "FAIL") fail++;
        });

        console.log("\nDataset Statistics");
        console.log("--------------------");
        console.log("Total Records:", total);
        console.log("PASS:", pass);
        console.log("FAIL:", fail);

    } catch (err) {
        console.log("Error reading dataset.");
    }

    rl.close();
});
