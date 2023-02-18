import { createBrowserRouter } from "react-router-dom";

import App from "../App";
import { ExampleButton } from "../components/ExampleButton/ExampleButton";
import { Teams } from "../pages/Teams";

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
  {
    path: "/teams",
    element: <Teams />
  }
]);
