import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';

type Props = {
  year: string;
};

export default function SelectAutoWidth({ message}: Props) {
  const [year, setYear] = React.useState('');

  const handleChange = (event: SelectChangeEvent) => {
    setYear(event.target.value);
  };

  return (
    <div>
      <FormControl sx={{ m: 1, minWidth: 80 }}>
        <InputLabel id="demo-simple-select-autowidth-label">Year</InputLabel>
        <Select
          labelId="demo-simple-select-autowidth-label"
          id="demo-simple-select-autowidth"
          value={year}
          onChange={handleChange}
          autoWidth
          label="Year"
        >
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value={10}>2022</MenuItem>
          <MenuItem value={21}>2021</MenuItem>
          <MenuItem value={22}>2020</MenuItem>
        </Select>
      </FormControl>
    </div>
  );
}
