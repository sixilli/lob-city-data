import { GoogleAuthData, signInPopup, getCachedUser } from "./auth-provider";
import React, { createContext, useState, useEffect } from "react";

interface AuthContextType {
  authProvider?: GoogleAuthData;
  singIn: () => void;
  singOut: () => void;
  testSignIn: () => void;
}
export const AuthContext = createContext<AuthContextType>(null!);

// 1.3.2 Implement reusable flow within the UI.
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

  const testSignIn = () => {
    setAuthData({
      isAuthenticated: true,
      authData: null!,
      user: {
        uuid: "1234567890",
        displayName: "Test User",
        lastSignOn: null,
        favoriteTeam: "Miami",
        teamId: 0,
      },
      token: "test-user",
    });
  };

  const authContext: AuthContextType = {
    authProvider: authData,
    singIn: signIn,
    singOut: signOut,
    testSignIn,
  };

  return (
    <AuthContext.Provider value={authContext}>{children}</AuthContext.Provider>
  );
}
