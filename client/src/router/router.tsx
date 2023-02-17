import { createBrowserRouter } from "react-router-dom";

import App from "../App";
import { ExampleButton } from "../components/ExampleButton/ExampleButton";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
  },
  {
    path: "/button",
    element: <ExampleButton message={"hello"} />,
  },
  {
    path: "/button-error",
    element: <ExampleButton message={"error"} isError={true} />,
  },
]);
