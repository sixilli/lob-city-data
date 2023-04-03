import { GoogleAuthProvider, signInWithPopup, User } from "firebase/auth";
import { fbAuth } from "../main";
import { FirebaseError } from "firebase/app";

export async function signInPopup() {
  const auth = fbAuth;
  const provider = new GoogleAuthProvider();
  try {
    const result = await signInWithPopup(auth, provider);
    const credential = GoogleAuthProvider.credentialFromResult(result);
    const authProvider: GoogleAuthData = {};
    authProvider.user = result.user;
    authProvider.token = credential?.accessToken
      ? credential.accessToken
      : undefined;
    authProvider.isAuthenticated = Boolean(authProvider.token);
    console.log("yay", authProvider);
    return authProvider;
  } catch (error) {
    if (error instanceof FirebaseError) {
      const errorCode = error?.code;
      const errorMessage = error?.message;
      const email = error?.customData?.email;
      // const credential = AuthProvider.credentialFromError(error);
      console.log(errorCode, " ", errorMessage, " email: ", email);
    }
  }
}

export async function getCachedUser() {
  const authProvider: GoogleAuthData = {};
  if (!fbAuth.currentUser) {
    return authProvider;
  }

  const credentials = GoogleAuthProvider.credential(
    await fbAuth.currentUser.getIdToken()
  );

  if (!credentials.accessToken) {
    return authProvider;
  }

  authProvider.user = fbAuth.currentUser;
  authProvider.token = credentials.accessToken;
  authProvider.isAuthenticated = Boolean(authProvider.token);
  console.log(authProvider);
  return authProvider;
}

export interface GoogleAuthData {
  isAuthenticated?: boolean;
  user?: User;
  token?: string;
}
