import { useState } from "react";
import reactLogo from "./assets/react.svg";
import "./App.css";

import { Link } from "react-router-dom";


function App() {
  return (
      <AppComponent />
  )
}

function AppComponent() {
  const [count, setCount] = useState(0);

  return (
    <div className="App">
      <div>
        <Link to={"/"}>home</Link>
      </div>
      <div>
        <Link to={"button"}>button</Link>
      </div>
      <div>
        <Link to={"button-error"}>error button</Link>
      </div>
      <div>
        <Link to={"teams"}>Teams</Link>
      </div>
      <h1>Counter Example</h1>
      <div className="card">
        <p>Click button to increment</p>
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
      </div>
    </div>
  );
}

export default App;
