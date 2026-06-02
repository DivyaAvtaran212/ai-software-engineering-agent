import { useEffect, useState } from "react";
import { api } from "../services/api";

function Home() {

  const [message, setMessage] = useState("Loading...");

  useEffect(() => {

    api.get("/health")
      .then((response) => {

        console.log("BACKEND RESPONSE:", response.data);

        setMessage(response.data);

      })
      .catch((error) => {

        console.error("API ERROR:", error);

        setMessage("Backend connection failed");

      });

  }, []);

  return (
    <div>

      <h1>AI Software Engineering Agent</h1>

      <p>{message}</p>

    </div>
  );
}

export default Home;