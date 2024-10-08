import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(0);

  // useEffect(() => {
  //   fetch('/api/counter')
  //     .then(response => response.json())
  //     .then(data => setCount(data));
  // }, []);

  const incrementCount = () => {
    fetch('/api/counter/increment', {
      method: 'POST',
    })
      .then(response => response.json())
      .then(data => setCount(data));
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Simple Counter</h1>
        <p>Count: {count}</p>
        <button onClick={incrementCount}>Increase</button>
      </header>
    </div>
  );
}

export default App;
