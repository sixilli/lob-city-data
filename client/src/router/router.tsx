import { createBrowserRouter } from "react-router-dom";

import { Home } from "../pages/Home";
import { ExampleButton } from "../components/ExampleButton/ExampleButton";
import { Teams } from "../pages/Teams";
import { Players } from "../pages/Players";
import SidebarLayout from "../components/SidebarLayout/SidebarLayout";
import { NotFound } from "../pages/ErrorPage";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <SidebarLayout content={<Home />} />,
  },
  {
    path: "/button",
    element: <SidebarLayout content={<ExampleButton message={"hello"} />} />,
  },
  {
    path: "/teams",
    element: <SidebarLayout content={<Teams />} />,
  },
  {
    path: "/players",
    element: <SidebarLayout content={<Players />} />,
  },
  {
    path: "*",
    element: <SidebarLayout content={<NotFound />} />,
  },
]);
