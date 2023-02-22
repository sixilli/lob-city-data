import { Stack, Typography } from "@mui/material"
import { Link, useRouteError } from "react-router-dom"

export const ErrorPage = () => {
  const error:any = useRouteError();
  console.error(error);
  return (
    <>
      <Stack spacing={2}>
        <Link to={"/"}>home</Link>   
        <Typography align="center" variant="h3">Oops!</Typography>
        <Typography align="center" variant="h6">An unexpected error has occurred.</Typography>
        <p><i>{error.statusText || error.message} </i></p>
      </Stack>
      </>
  )
}
