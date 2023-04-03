import { useContext, useEffect } from "react";
import { pingBackend } from "../requests/requests";
import Button from "@mui/material/Button";
import { AuthContext } from "../auth/AuthContextProvider";

export function Home() {
  const auth = useContext(AuthContext);
  useEffect(() => {
    pingBackend();
  }, []);

  return (
    <div className="App">
      <h2>Home Page</h2>
      {!auth?.authProvider?.isAuthenticated ? (
        <Button variant="contained" onClick={() => auth.singIn()}>
          Login
        </Button>
      ) : (
        <div>
          <h3>
            You have been logged in {auth?.authProvider?.user?.displayName}
          </h3>
        </div>
      )}
    </div>
  );
}
