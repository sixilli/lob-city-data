import { Box, CircularProgress } from "@mui/material";

export default function Loader() {
  return (
    <div>
      <Box sx={{ display: "flex" }}>
        <CircularProgress color="inherit" />
      </Box>
    </div>
  );
}
