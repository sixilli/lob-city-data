import { AuthContext } from "./AuthContextProvider";
import { useContext } from "react";
import { useLocation, Navigate } from "react-router-dom";

// 1.3.2 Implement reusable flow within the UI
export function RequireAuth({ children }: { children: JSX.Element }) {
  let auth = useContext(AuthContext);
  let location = useLocation();

  if (!auth?.authProvider?.isAuthenticated) {
    return <Navigate to="/" state={{ from: location }} replace />;
  }

  return children;
}
