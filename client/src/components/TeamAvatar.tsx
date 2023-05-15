import { Team } from "../models/nba-api";
import { Avatar } from "@mui/material";

type Props = {
  team: Team;
};

// 1.1.2 Team logos
export function TeamAvatar({ team }: Props) {
  const buildLogoLink = (team: Team) => {
    if (team.nickname.toLowerCase() === "nuggets")
      return "https://loodibee.com/wp-content/uploads/nba-denver-nuggets-logo-2018.png";

    if (team.nickname.toLowerCase() === "lakers")
      return "https://loodibee.com/wp-content/uploads/nba-los-angeles-lakers-logo.png";

    if (team.nickname.toLowerCase() === "clippers")
      return "https://loodibee.com/wp-content/uploads/nba-la-clippers-logo.png";

    const formattedName = team.fullName.toLowerCase().split(" ").join("-");
    return `https://loodibee.com/wp-content/uploads/nba-${formattedName}-logo.png`;
  };

  return <Avatar alt={team.nickname} src={buildLogoLink(team)} />;
}
