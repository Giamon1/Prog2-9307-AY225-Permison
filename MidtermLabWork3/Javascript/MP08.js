const fs = require("fs");
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Enter CSV file path: ", function(path) {

    rl.question("Enter keyword to filter: ", function(keyword) {

        keyword = keyword.toLowerCase();
        let count = 0;

        try {

            const data = fs.readFileSync(path, "utf8");
            const rows = data.split("\n");

            console.log("\nFiltered Records:\n");

            rows.forEach(row => {
                row = row.trim();
                if (!row.startsWith('"')) return;

                const parts = row.split('",');
                if (parts.length < 2) return;

                const name = parts[0].replace('"', '');
                const columns = parts[1].split(",");

                const exam = columns[2];

                if (exam.toLowerCase().includes(keyword)) {
                    console.log(name + " | " + exam + " | " + columns[6]);
                    count++;
                }
            });

            console.log("\nTotal Matches: " + count);

        } catch (err) {
            console.log("Error reading dataset.");
        }

        rl.close();
    });

});
