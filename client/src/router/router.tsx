import { createBrowserRouter } from "react-router-dom";

import App from "../App";
import { ExampleButton } from "../components/ExampleButton/ExampleButton";
import { Teams } from "../pages/Teams";
import { Players } from "../pages/Players";
import { ErrorPage } from "../pages/ErrorPage";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />
  },
  {
    path: "/button",
    element: <ExampleButton message={"hello"} />,
    errorElement: <ErrorPage />
  },
  {
    path: "/button-error",
    element: <ExampleButton message={"error"} isError={true} />,
    errorElement: <ErrorPage />
  },
  {
    path: "/teams",
    element: <Teams />,
    errorElement: <ErrorPage />
  },
  {
    path: "/players",
    element: <Players />,
    errorElement: <ErrorPage />
  }
]);
