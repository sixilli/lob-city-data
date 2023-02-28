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

  const makeGridBlock = (message: string, key: string) => (
    <Grid item xs={4} key={key}>
      <Typography variant="body1" key={key + "-body"}>
        {message}
      </Typography>
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
          {data.map((stats, index) => (
            <>
              <TeamStastModalHeader
                teamName={teamName}
                selectedSeason={selectedSeason}
                key={`${index}-header`}
              />
              <SelectField
                label={"Season"}
                defaultValue={selectedSeason}
                keyValues={seasonSelections(20)}
                handleChange={handleChange}
                key={`${index}-select`}
              />
              <Grid container spacing={2}>
                {makeGridBlock(`Games: ${stats.games}`, `${index}-games`)}
                {makeGridBlock(
                  `Fast Break Points: ${stats.fastBreakPoints}`,
                  `${index}-break-points`
                )}
                {makeGridBlock(
                  `Points in Paint: ${stats.pointsInPaint}`,
                  `${index}-paint`
                )}
                {makeGridBlock(
                  `Biggest Lead: ${stats.biggestLead}`,
                  `${index}-biggest-lead`
                )}
                {makeGridBlock(
                  `Second Chance Points: ${stats.secondChancePoints}`,
                  `${index}second-chance`
                )}
                {makeGridBlock(
                  `Points Off Turnovers: ${stats.pointsOffTurnovers}`,
                  `${index}-points-off-turnovers`
                )}
                {makeGridBlock(
                  `Longest Run: ${stats.longestRun}`,
                  `${index}-longest-run`
                )}
                {makeGridBlock(`Points: ${stats.points}`, `${index}-points`)}
                {makeGridBlock(`FGM: ${stats.fgm}`, `${index}-fgm`)}
                {makeGridBlock(`FGA: ${stats.fga}`, `${index}-fga`)}
                {makeGridBlock(`FGP: ${stats.fgp}`, `${index}-fgp`)}
                {makeGridBlock(`FTM: ${stats.ftm}`, `${index}-ftm`)}
                {makeGridBlock(`FTA: ${stats.fta}`, `${index}-fta`)}
                {makeGridBlock(`FTP: ${stats.ftp}`, `${index}-ftp`)}
                {makeGridBlock(`TPM: ${stats.tpm}`, `${index}-tpm`)}
                {makeGridBlock(`TPA: ${stats.tpa}`, `${index}-tpa`)}
                {makeGridBlock(
                  `Offensive Rebound: ${stats.offReb}`,
                  `${index}-off-rebounds`
                )}
                {makeGridBlock(
                  `Defensive Rebounds: ${stats.defReb}`,
                  `${index}-def-rebounds`
                )}
                {makeGridBlock(
                  `Total Rebounds: ${stats.totReb}`,
                  `${index}-tot-rebounds`
                )}
                {makeGridBlock(`Assists: ${stats.assists}`, `${index}-assits`)}
                {makeGridBlock(
                  `Penalty Fouls: ${stats.pFouls}`,
                  `${index}-fouls`
                )}
                {makeGridBlock(`Steals: ${stats.steals}`, `${index}-steals`)}
                {makeGridBlock(
                  `Turnovers: ${stats.turnovers}`,
                  `${index}-turnovers`
                )}
                {makeGridBlock(`Blocks: ${stats.blocks}`, `${index}-blocks`)}
                {makeGridBlock(
                  `Plus Minus: ${stats.plusMinus}`,
                  `${index}-plus-minus`
                )}
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
