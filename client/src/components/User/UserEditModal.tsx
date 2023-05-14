import { useContext } from "react";
import { AuthContext } from "../../auth/AuthContextProvider";
import { Grid, Stack, Typography } from "@mui/material";
import { SelectField } from "../SelectField/SelectField";
import ModalBase from "../ModalBase/ModalBase";
import Loader from "../Loader/Loader";

type Props = {
  open: boolean;
  handleClose: () => void;
};

export function UserEditModal({ open, handleClose }: Props) {
  const auth = useContext(AuthContext);
  const data = false;
  const isLoading = false;

  if (isLoading && !data)
    return (
      <ModalBase open={open} content={<Loader />} handleClose={handleClose} />
    );

  const modalContent = () => (
    <>
      {data && (
        <Stack spacing={2}>
          <Typography variant={"body1"}>hello</Typography>
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
