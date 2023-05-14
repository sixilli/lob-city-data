import { GoogleAuthData, signInPopup, getCachedUser } from "./auth-provider";
import React, { createContext, useState, useEffect } from "react";

interface AuthContextType {
  authProvider?: GoogleAuthData;
  singIn: () => void;
  singOut: () => void;
}
export const AuthContext = createContext<AuthContextType>(null!);

export function AuthContextProvider({
  children,
}: {
  children: React.ReactNode;
}) {
  const [authData, setAuthData] = useState<GoogleAuthData>(null!);

  const getCachedUserWrapper = async () => {
    const userData = await getCachedUser();
    if (userData?.isAuthenticated) {
      setAuthData(userData);
    }
  };

  useEffect(() => {
    getCachedUserWrapper().catch((e) => console.log(e));
  }, []);

  const signIn = () => {
    signInPopup().then((authProvider) => {
      if (authProvider) {
        setAuthData(authProvider);
      }
    });
  };

  const signOut = () => {
    setAuthData(null!);
  };

  const authContext: AuthContextType = {
    authProvider: authData,
    singIn: signIn,
    singOut: signOut,
  };

  return (
    <AuthContext.Provider value={authContext}>{children}</AuthContext.Provider>
  );
}
