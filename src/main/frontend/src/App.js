import React, {useEffect, useState, Component} from "react";
import Header from "./component/Header";
import Footer from "./component/Footer";
import Main from "./component/Main";
import Wrapper from "./component/wrapper";
import Example01 from "./example/Example01";
import Example02 from "./example/Example02";
import ListComponent from "./example/ListComponent";

import axios from 'axios';

function App(){
  const [hello, setHello] = useState('');

  const idArr = [
      { idx : 1, id : 'aaa', name : '허진욱1'},
      { idx : 2, id : 'bbb', name : '허진욱2'},
      { idx : 3, id : 'ccc', name : '허진욱3'},
  ]

  useEffect(()=>{
    axios.get('/api/hello')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
  }, []);

  return(
      <div>
          <Header/>
          <Wrapper>
            <Main name="허진욱" color="blue"/>
            <Main name="양찬" color="skyblue"/>
          </Wrapper>
          백엔드에서 가져온 데이터입니다. : {hello}
          <Example01 />
          <hr/>
          <Example02 />
          <hr/>
          <ListComponent idArr={idArr} />
          <Footer/>
      </div>
  );

}

export default App;