import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import { Link } from "react-router-dom";

// Define what our component needs
type Props = {
  message: string;
  isError?: boolean;
};

export function ExampleButton({message, isError}: Props) {
  return (
    <Stack spacing={3}>
      <div>
        <Link to={"/"}>Home</Link>
      </div>
      {isError 
        ? <Button variant="contained" color="error">{message}</Button>
        : <Button variant="contained">{message}</Button>
      }
    </Stack>
  )
};