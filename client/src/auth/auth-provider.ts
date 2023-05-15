import { GoogleAuthProvider, signInWithPopup, User } from "firebase/auth";
import { fbAuth } from "../main";
import { FirebaseError } from "firebase/app";
import { UserData } from "../models/user";
import { postGetUserData } from "../requests/requests";

// 1.0.1 Login flow
export async function signInPopup() {
  const auth = fbAuth;
  const provider = new GoogleAuthProvider();
  try {
    const result = await signInWithPopup(auth, provider);
    const credential = GoogleAuthProvider.credentialFromResult(result);
    const authProvider: GoogleAuthData = {};

    console.log(result);
    authProvider.authData = result.user;
    authProvider.token = credential?.accessToken
      ? credential.accessToken
      : undefined;
    authProvider.isAuthenticated = Boolean(authProvider.token);
    authProvider.user = await getUserData(result.user);

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

async function getUserData(authData: User): Promise<UserData> {
  const userData: UserData = {
    uuid: authData.uid,
    displayName: authData.displayName,
    lastSignOn: authData.metadata.lastSignInTime,
  };

  return postGetUserData(userData);
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

  authProvider.authData = fbAuth.currentUser;
  authProvider.token = credentials.accessToken;
  authProvider.isAuthenticated = Boolean(authProvider.token);
  return authProvider;
}

export interface GoogleAuthData {
  isAuthenticated?: boolean;
  authData?: User;
  user?: UserData;
  token?: string;
}
