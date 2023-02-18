import { useQuery } from "react-query";
import { requestTeams } from "../requests/requests";

import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import Grid from '@mui/material/Grid';

import Loader from "../components/Loader/Loader";
import { Team } from "../models/rapidapi";
import { Typography } from "@mui/material";
import Stack from "@mui/material/Stack";

export function Teams() {
  const { isLoading, error, data } = useQuery<Team[], Error>("teams", requestTeams)

  if (isLoading) return (
    <div>
      <Loader />
    </div>
  )

  if (error) {
    console.log(error, data);
  }

  return (
    <>
      <Stack spacing={2}>
        <Typography align="center" variant="h3">NBA Teams</Typography>
        <Grid container spacing={0} columns={{ xs: 4, sm: 8, md: 12 }}>
          {data?.map((team, index) => (
            <>
              {team.nbaFranchise &&
                <Grid xs={2} sm={4} md={4} key={index}>
                  <ListItemButton>
                    <ListItemText 
                      primary={team.name} 
                      secondary={
                        <Typography style={{ color: "gray"}}>
                          {team.city}
                        </Typography>
                      }
                    />
                  </ListItemButton> 
                </Grid>
              }
            </>
          ))}
        </Grid>
      </Stack>
    </>
  );
}
