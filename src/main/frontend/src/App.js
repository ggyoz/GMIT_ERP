import React, {useEffect, useState} from "react";
import Header from "./component/Header";
import Footer from "./component/Footer";
import Main from "./component/Main";
import Wrapper from "./component/wrapper";
import Example01 from "./example/Example01";
import Example04 from "./example/Example04";
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import axios from 'axios';

function App(){
  const [hello, setHello] = useState('');

  useEffect(()=>{
    axios.get('/api/hello')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
  }, []);

  return(
      <div className="App">
          <Wrapper>
              <Main name="허진욱" color="blue"/>
          </Wrapper>
          백엔드에서 가져온 데이터입니다. : {hello}
          <Example04/>
      </div>
  );
}

export default App;