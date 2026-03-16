const fs = require("fs");
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter CSV file path: ", function(path) {

    const seen = new Set();
    let duplicates = 0;

    try {
        const data = fs.readFileSync(path, "utf8");
        const rows = data.split("\n");

        rows.forEach(row => {
            row = row.trim();
            if (!row.startsWith('"')) return;

            if (seen.has(row)) {
                console.log("Duplicate Record:", row);
                duplicates++;
            } else {
                seen.add(row);
            }
        });

        console.log("\nTotal Duplicates:", duplicates);

    } catch (err) {
        console.log("Error reading dataset.");
    }

    rl.close();
});
