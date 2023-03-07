import ModalBase from "../ModalBase/ModalBase";
import { useQuery } from "react-query";
import { TeamStatistic } from "../../models/nba-api";
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

  const { isLoading, error, data, refetch } = useQuery<TeamStatistic, Error>(
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
    const start = new Date().getFullYear() - 1;
    for (let i = start; i > start - numYears; i--) {
      selections.push({ value: i, display: i.toString() });
    }
    return selections;
  };

  const modalContent = () => (
    <>
      {data && (
        <Stack spacing={2}>
          <TeamStastModalHeader
            teamName={teamName}
            selectedSeason={data.year}
          />
          <SelectField
            label={"Season"}
            defaultValue={selectedSeason}
            keyValues={seasonSelections(20)}
            handleChange={handleChange}
          />
          <Grid container spacing={2}>
            {makeGridBlock(`Games: ${data.gp}`)}
            {makeGridBlock(`Wins: ${data.wins}`)}
            {makeGridBlock(`Losses: ${data.losses}`)}
            {makeGridBlock(`Win Percentage: ${data.winPct}`)}
            {makeGridBlock(`Conference Rank: ${data.confRank}`)}
            {makeGridBlock(`Playoff Wins: ${data.poWins}`)}
            {makeGridBlock(`Playoff Losses: ${data.poLosses}`)}
            {makeGridBlock(`FGM: ${data.fgm}`)}
            {makeGridBlock(`FGA: ${data.fga}`)}
            {makeGridBlock(`FGP: ${data.fgPct}`)}
            {makeGridBlock(`3 FGP: ${data.fg3Pct}`)}
            {makeGridBlock(`FTM: ${data.ftm}`)}
            {makeGridBlock(`FTA: ${data.fta}`)}
          </Grid>
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
