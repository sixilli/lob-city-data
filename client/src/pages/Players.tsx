import { useQuery } from "react-query";
import { requestPlayers } from "../requests/requests";
import Grid from "@mui/material/Grid";

import Loader from "../components/Loader/Loader";
import { ListItemButton, ListItemText, Typography } from "@mui/material";
import Stack from "@mui/material/Stack";
import { BasicPlayer } from "../models/nba-api";

export function Players() {
  const { isLoading, error, data } = useQuery<BasicPlayer[], Error>(
    "players",
    requestPlayers
  );

  if (isLoading)
    return (
      <div>
        <Loader />
      </div>
    );

  if (error) {
    console.log(error.message, data);
  }

  return (
    <>
      <Stack spacing={2}>
        <Typography align="center" variant="h3">
          Active NBA Players
        </Typography>
        <Grid container spacing={0} columns={{ xs: 4, sm: 8, md: 12 }}>
          {data?.map((player, index) => (
            <>
              <Grid xs={2} sm={4} md={4} key={index}>
                <ListItemButton>
                  <ListItemText
                    primary={`${player.fullName}`}
                    secondary={
                      <Typography style={{ color: "gray" }}>
                        {player.id}
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
