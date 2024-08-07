import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import Navbar from './NavBar'
import './App.css'
// Import our custom CSS
import './styles/styles.scss'
import './styles/variables-mint.scss'

// Import all of Bootstrap's JS
import * as bootstrap from 'bootstrap'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div data-bs-theme="mint">
      <Navbar/>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button class="btn btn-primary" onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
      <div class="container py-4 px-3 mx-auto">
        <h1>Hello, Bootstrap and Vite!</h1>
        <button class="btn btn-primary">Primary button</button>
      </div>
    </div>
  )
}

export default App
