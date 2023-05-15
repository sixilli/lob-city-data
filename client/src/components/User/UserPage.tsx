import { useContext, useState } from "react";
import { Stack, Typography } from "@mui/material";
import { UserEditModal } from "./UserEditModal";
import { AuthContext } from "../../auth/AuthContextProvider";

// 1.2.0	Player page to view active players
export function UserPage() {
  const auth = useContext(AuthContext);
  const [open, setOpen] = useState(false);
  const handleClose = () => setOpen(false);

  return (
    <>
      <Stack spacing={2}>
        <Typography align="center" variant="h3">
          You have been logged in {auth?.authProvider?.authData?.displayName}
        </Typography>
      </Stack>
      {open && <UserEditModal open={open} handleClose={handleClose} />}
    </>
  );
}
