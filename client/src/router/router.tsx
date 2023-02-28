import { createBrowserRouter } from "react-router-dom";

import App from "../App";
import { ExampleButton } from "../components/ExampleButton/ExampleButton";
import { Teams } from "../pages/Teams";
import { Players } from "../pages/Players";
import SidebarLayout from "../components/SidebarLayout/SidebarLayout";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <SidebarLayout content={<App />} />,
  },
  {
    path: "/button",
    element: <SidebarLayout content={<ExampleButton message={"hello"} />} />,
  },
  {
    path: "/button-error",
    element: (
      <SidebarLayout
        content={<ExampleButton message={"error"} isError={true} />}
      />
    ),
  },
  {
    path: "/teams",
    element: <SidebarLayout content={<Teams />} />,
  },
  {
    path: "/players",
    element: <SidebarLayout content={<Players />} />,
  },
]);
