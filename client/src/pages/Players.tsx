import { useQuery } from "react-query";
import { requestPlayers } from "../requests/requests";
import Grid from '@mui/material/Grid';

import Loader from "../components/Loader/Loader";
import { Player } from "../models/rapidapi";
import { ListItemButton, ListItemText, Typography } from "@mui/material";
import Stack from "@mui/material/Stack";
import { Link } from "react-router-dom";

export function Players() {
  const { isLoading, error, data } = useQuery<Player[], Error>(
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
    console.log(error, data);
  }

  return (
    <>
        <Stack spacing={2}> 
            <Link to={"/"}>home</Link>            
            <Typography align="center" variant="h3">NBA Players</Typography>
            <Grid container spacing={0} columns={{ xs: 4, sm: 8, md: 12 }}>
                {data?.map((player, index) => (
                  <>
                    
                      <Grid xs={2} sm={4} md={4} key={index}>
                        <ListItemButton>
                          <ListItemText
                            primary={`${player.firstname} ${player.lastname}`}
                            secondary={
                              <Typography style={{ color: "gray" }}>
                                {player.college}
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
