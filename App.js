import logo from './logo.svg';
import './App.css';
import {Routes,Route,Redirect} from 'react-router-dom'
import Post from './components/Posts/Post';
import Home from './components/Home/Home';

function App() {
  return (
    <div className="App">
      <Routes>
        {/* <Route path='/posts' element={<Post/>}/> */}
        <Route path='/' element={<Home/>}></Route>
        <Route path='/users/:userId'></Route>
        </Routes>
    </div>
  );
}

export default App;
