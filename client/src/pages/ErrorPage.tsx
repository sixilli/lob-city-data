import { Stack, Typography } from "@mui/material";
import { Link, useRouteError } from "react-router-dom";

export const NotFound = () => {
  return (
    <>
      <Stack spacing={2}>
        <Typography align="center" variant="h3">
          404
        </Typography>
        <Typography align="center" variant="h6">
          Page not found.
        </Typography>
        <Link to={"/"}>home</Link>
      </Stack>
    </>
  );
};
