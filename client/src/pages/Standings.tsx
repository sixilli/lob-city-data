import { useQuery } from "react-query";
import { requestStandings } from "../requests/requests";

import ListItemButton from "@mui/material/ListItemButton";
import ListItemText from "@mui/material/ListItemText";
import Grid from "@mui/material/Grid";

import Loader from "../components/Loader/Loader";
import { Standing } from "../models/rapidapi";
import { Typography } from "@mui/material";
import Stack from "@mui/material/Stack";


export function Standings() {
  const { isLoading, error, data } = useQuery<Standing[], Error>(
    "standings",
    requestStandings
  );

  if (isLoading)
    return (
      <div>
        <Loader />
      </div>
    );

  if (error) {
    console.log(error, data);
  }

  return (
    <>
      <Stack spacing={2}>
        <Typography align="center" variant="h3">
          NBA Standings
        </Typography>
        <Grid container spacing={0} columns={{ xs: 4, sm: 8, md: 12 }}>
          {data?.map((standing, index) => (
              <>
                  <Grid xs={2} sm={4} md={4} key={index}>
                    <ListItemButton>
                      <ListItemText
                        primary={standing.conference}
                        secondary={
                          <Typography style={{ color: "gray" }}>
                            {standing.team}
                          </Typography>
                        }
                      />
                    </ListItemButton>
                  </Grid>
              </>
            ))}
        </Grid>
      </Stack>
    </>
  );
}
