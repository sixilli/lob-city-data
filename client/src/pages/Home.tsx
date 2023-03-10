import { useEffect } from "react";
import { pingBackend } from "../requests/requests";

export function Home() {
  useEffect(() => {
    pingBackend();
  }, []);

  return (
    <div className="App">
      <h2>Home Page</h2>
    </div>
  );
}
