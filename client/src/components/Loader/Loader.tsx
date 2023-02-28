import { Box, CircularProgress } from "@mui/material";

export default function Loader() {
  return (
    <div>
      <Box display="flex" alignContent="center">
        <CircularProgress color="inherit" />
      </Box>
    </div>
  );
}
