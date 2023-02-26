import ModalBase from "../ModalBase/ModalBase";
import { useQuery } from "react-query";
import { TeamStatistics } from "../../models/rapidapi";
import { requestTeamStatistics } from "../../requests/requests";
import Loader from "../Loader/Loader";
import {
  FormControl,
  Grid,
  InputLabel,
  MenuItem,
  Select,
  SelectChangeEvent,
  Stack,
  Typography,
} from "@mui/material";
import { useState } from "react";
import { SelectField } from "../SelectField/SelectField";

type Props = {
  teamName: string;
  teamId: string;
  season: string;
  open: boolean;
  handleClose: () => void;
};
export function TeamStatsModal({
  teamName,
  teamId,
  season,
  open,
  handleClose,
}: Props) {
  const [selectedSeason, setSelectedSeason] = useState(season);

  const { isLoading, error, data, refetch } = useQuery<TeamStatistics[], Error>(
    ["team stats", teamId, selectedSeason],
    () => requestTeamStatistics(teamId, selectedSeason)
  );

  if (isLoading)
    return (
      <ModalBase open={open} content={<Loader />} handleClose={handleClose} />
    );

  if (error) {
    console.log(error.message, data);
    handleClose();
  }

  const makeGridBlock = (message: string) => (
    <Grid item xs={4}>
      <Typography variant="body1">{message}</Typography>
    </Grid>
  );

  const handleChange = (event: SelectChangeEvent) => {
    setSelectedSeason(event.target.value as string);
    refetch();
  };

  const seasonSelections = (numYears: number) => {
    const selections = [];
    const start = new Date().getFullYear();
    for (let i = start; i > start - numYears; i--) {
      selections.push({ value: i, display: i.toString() });
    }
    return selections;
  };

  const modalContent = () => (
    <>
      {data && (
        <Stack spacing={2}>
          {data.map((stats) => (
            <>
              <TeamStastModalHeader
                teamName={teamName}
                selectedSeason={selectedSeason}
              />
              <SelectField
                label={"Season"}
                defaultValue={selectedSeason}
                keyValues={seasonSelections(20)}
                handleChange={handleChange}
              />
              <Grid container spacing={2}>
                {makeGridBlock(`Games: ${stats.games}`)}
                {makeGridBlock(`Fast Break Points: ${stats.fastBreakPoints}`)}
                {makeGridBlock(`Points in Paint: ${stats.pointsInPaint}`)}
                {makeGridBlock(`Biggest Lead: ${stats.biggestLead}`)}
                {makeGridBlock(
                  `Second Chance Points: ${stats.secondChancePoints}`
                )}
                {makeGridBlock(
                  `Points Off Turnovers: ${stats.pointsOffTurnovers}`
                )}
                {makeGridBlock(`Longest Run: ${stats.longestRun}`)}
                {makeGridBlock(`Points: ${stats.points}`)}
                {makeGridBlock(`FGM: ${stats.fgm}`)}
                {makeGridBlock(`FGA: ${stats.fga}`)}
                {makeGridBlock(`FGP: ${stats.fgp}`)}
                {makeGridBlock(`FTM: ${stats.ftm}`)}
                {makeGridBlock(`FTA: ${stats.fta}`)}
                {makeGridBlock(`FTP: ${stats.ftp}`)}
                {makeGridBlock(`TPM: ${stats.tpm}`)}
                {makeGridBlock(`TPA: ${stats.tpa}`)}
                {makeGridBlock(`Offensive Rebound: ${stats.offReb}`)}
                {makeGridBlock(`Defensive Rebounds: ${stats.defReb}`)}
                {makeGridBlock(`Total Rebounds: ${stats.totReb}`)}
                {makeGridBlock(`Assists: ${stats.assists}`)}
                {makeGridBlock(`Penalty Fouls: ${stats.pFouls}`)}
                {makeGridBlock(`Steals: ${stats.steals}`)}
                {makeGridBlock(`Turnovers: ${stats.turnovers}`)}
                {makeGridBlock(`Blocks: ${stats.blocks}`)}
                {makeGridBlock(`Plus Minus: ${stats.plusMinus}`)}
              </Grid>
            </>
          ))}
        </Stack>
      )}
    </>
  );

  return (
    <>
      <ModalBase
        open={open}
        content={modalContent()}
        handleClose={handleClose}
      />
    </>
  );
}

type headerProps = {
  teamName: string;
  selectedSeason: string;
};

function TeamStastModalHeader({ teamName, selectedSeason }: headerProps) {
  return (
    <Typography align="center" variant="h4">
      {teamName} - {selectedSeason}
    </Typography>
  );
}
