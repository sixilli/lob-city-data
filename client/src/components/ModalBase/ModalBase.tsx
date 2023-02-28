import { useState } from "react";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { SxProps } from "@mui/material";

const style: SxProps = {
  position: "absolute" as "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  minWidth: 800,
  bgcolor: "#242424",
  border: "2px solid #000",
  boxShadow: 24,
  display: "flex",
  justifyContent: "center",
  flex: 1,
  p: 4,
};

type Props = {
  content: JSX.Element;
  open: boolean;
  handleClose: () => void;
};
export default function ModalBase({ content, open, handleClose }: Props) {
  return (
    <Modal
      open={open}
      onClose={handleClose}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"
    >
      <Box sx={style}>{content}</Box>
    </Modal>
  );
}
