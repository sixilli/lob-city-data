import { useQuery } from "react-query";
import { requestTeams } from "../requests/requests";

import ListItemButton from "@mui/material/ListItemButton";
import ListItemText from "@mui/material/ListItemText";
import Grid2 from "@mui/material/Unstable_Grid2";

import Loader from "../components/Loader/Loader";
import { Team } from "../models/nba-api";
import {
  Avatar,
  List,
  ListItem,
  ListItemAvatar,
  Typography,
} from "@mui/material";
import Stack from "@mui/material/Stack";
import { useState } from "react";
import { TeamStatsModal } from "../components/TeamsStatsModal/TeamStatsModal";
import { TeamAvatar } from "../components/TeamAvatar";

export function Teams() {
  const [open, setOpen] = useState(false);
  const [teamName, setTeamName] = useState("");
  const [teamId, setTeamId] = useState("");

  const handleClose = () => setOpen(false);

  const { isLoading, error, data } = useQuery<Team[], Error>(
    "teams",
    requestTeams
  );

  const handleClick = (teamName: string, teamId: string) => {
    setTeamName(teamName);
    setTeamId(teamId);
    setOpen(true);
  };

  if (isLoading) return <Loader />;

  if (error) {
    console.log(error.message, data);
  }

  return (
    <>
      <Stack spacing={2}>
        <Typography align="center" variant="h3">
          NBA Teams
        </Typography>
        <Grid2 container spacing={0} columns={{ xs: 4, sm: 8, md: 12 }}>
          {data &&
            data.map((team, index) => (
              <Grid2 xs={2} sm={4} md={4} key={index}>
                <ListItem>
                  <ListItemButton
                    onClick={() =>
                      handleClick(team.nickname as string, team.id.toString())
                    }
                    key={`list-button-${index}`}
                  >
                    <ListItemAvatar>
                      <TeamAvatar team={team} />
                    </ListItemAvatar>
                    <ListItemText
                      key={`list-text-${index}`}
                      primary={team.nickname}
                      secondary={
                        <Typography style={{ color: "gray" }}>
                          {team.city}
                        </Typography>
                      }
                    />
                  </ListItemButton>
                </ListItem>
              </Grid2>
            ))}
        </Grid2>
      </Stack>
      {open && (
        <TeamStatsModal
          teamName={teamName}
          teamId={teamId}
          season={(new Date().getFullYear() - 1).toString()}
          open={open}
          handleClose={handleClose}
        />
      )}
    </>
  );
}
