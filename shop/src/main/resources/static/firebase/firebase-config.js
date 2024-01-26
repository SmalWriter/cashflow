// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDUTxm-OSEekWetoONFdEBK0VYxqzJY1BU",
  authDomain: "multilogin-firstproject.firebaseapp.com",
  projectId: "multilogin-firstproject",
  storageBucket: "multilogin-firstproject.appspot.com",
  messagingSenderId: "211012224823",
  appId: "1:211012224823:web:7b5f3feaea1884ea71fcb2",
  measurementId: "G-8W7XT5450L"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

// Initialize Firebase
initializeApp(firebaseConfig);

// Initialize Firebase Auth
const auth = getAuth();

export { auth };