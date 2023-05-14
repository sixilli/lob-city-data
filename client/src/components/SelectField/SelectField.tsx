import {
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  SelectChangeEvent,
} from "@mui/material";

export type KeyValues = {
  value: any;
  display: string;
};

const ITEM_HEIGHT = 48;
const ITEM_PADDING_TOP = 8;
const MenuProps = {
  PaperProps: {
    style: {
      maxHeight: ITEM_HEIGHT * 4.5 + ITEM_PADDING_TOP,
      width: 250,
    },
  },
};

type Props = {
  label: string;
  defaultValue: any;
  keyValues: KeyValues[];
  handleChange: (event: SelectChangeEvent) => void;
};

export function SelectField({
  label,
  defaultValue,
  keyValues,
  handleChange,
}: Props) {
  return (
    <FormControl fullWidth>
      <InputLabel id={`${label}-select-label-input`}>{label}</InputLabel>
      <Select
        labelId={`${label}-select-label`}
        id={`${label}-season-select`}
        value={defaultValue}
        label={label}
        onChange={handleChange}
        MenuProps={MenuProps}
      >
        {keyValues.map((pair, index) => (
          <MenuItem key={`${pair.value}-${index}`} value={pair.value}>
            {pair.display}
          </MenuItem>
        ))}
      </Select>
    </FormControl>
  );
}
