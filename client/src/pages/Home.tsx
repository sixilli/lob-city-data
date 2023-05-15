import { useContext, useEffect } from "react";
import { pingBackend } from "../requests/requests";
import Button from "@mui/material/Button";
import { AuthContext } from "../auth/AuthContextProvider";
import { Grid, Stack, Typography } from "@mui/material";
import banner from "../assets/Banner_Image_Home_Page.svg";
import { UserPage } from "../components/User/UserPage";

// 1.0.0 Landing home page
export function Home() {
  const auth = useContext(AuthContext);
  useEffect(() => {
    pingBackend();
  }, []);

  return (
    <>
      {!auth?.authProvider?.isAuthenticated ? (
        <>
          <Stack spacing={2}>
            <img src={banner} alt="Lob City Data banner" />
            <Typography align="center" variant="body1">
              To use Lob City Data you must be logged in.
            </Typography>
            <Grid>
              <Stack direction="row" spacing={4} justifyContent={"center"}>
                <Button
                  variant="contained"
                  size={"medium"}
                  sx={{ width: "auto" }}
                  onClick={() => auth.singIn()}
                >
                  Login
                </Button>
                <Button
                  variant="contained"
                  size={"medium"}
                  sx={{ width: "auto" }}
                  onClick={() => auth.testSignIn()}
                >
                  Test User
                </Button>
              </Stack>
            </Grid>
          </Stack>
        </>
      ) : (
        <UserPage />
      )}
    </>
  );
}
