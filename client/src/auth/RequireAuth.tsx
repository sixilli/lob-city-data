import { AuthContext } from "./AuthContextProvider";
import { useContext } from "react";
import { useLocation, Navigate } from "react-router-dom";

export function RequireAuth({ children }: { children: JSX.Element }) {
  let auth = useContext(AuthContext);
  let location = useLocation();

  if (!auth?.authProvider?.isAuthenticated) {
    return <Navigate to="/" state={{ from: location }} replace />;
  }

  return children;
}
