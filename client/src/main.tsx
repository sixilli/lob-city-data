import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";

import { router } from "./router/router";
import { RouterProvider } from "react-router-dom";
import { QueryClient, QueryClientProvider } from "react-query";
import { createTheme } from "@mui/material";
import { ThemeProvider } from "@emotion/react";
import { AuthContextProvider } from "./auth/AuthContextProvider";

import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";
import firebaseConfig from "../firebaseConfig.json";

export const fbApp = initializeApp(firebaseConfig);
export const fbAuth = getAuth(fbApp);

const queryClient = new QueryClient();

const theme = createTheme({
  palette: {
    mode: "dark",
  },
});

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <ThemeProvider theme={theme}>
        <AuthContextProvider>
          <RouterProvider router={router} />
        </AuthContextProvider>
      </ThemeProvider>
    </QueryClientProvider>
  </React.StrictMode>
);
