import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  Routes,
} from "react-router-dom";

import { RequireAuth } from "../auth/RequireAuth";

import { Home } from "../pages/Home";
import { Teams } from "../pages/Teams";
import { Players } from "../pages/Players";
import SidebarLayout from "../components/SidebarLayout/SidebarLayout";
import { NotFound } from "../pages/ErrorPage";
import React from "react";

export const router = createBrowserRouter(
  createRoutesFromElements(
    <>
      <Route path={"/"} element={<SidebarLayout content={<Home />} />} />
      <Route path={"/teams"} element={authSidebar(<Teams />)} />
      <Route path={"/players"} element={authSidebar(<Players />)} />
      <Route path={"*"} element={<SidebarLayout content={<NotFound />} />} />
    </>
  )
);

function authSidebar(children: JSX.Element) {
  return (
    <RequireAuth>
      <SidebarLayout content={children} />
    </RequireAuth>
  );
}
