const express = require("express");
const cors = require("cors");

const app = express();
app.use(cors()); // ✅ Allow all origins for dev

app.get("/api/hello", (req, res) => {
  res.send("Hello from Node.js Backend!");
});

app.listen(5000, () => {
  console.log("🚀 Backend running on port 5000");
});
