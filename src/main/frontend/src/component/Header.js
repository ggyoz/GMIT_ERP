import React, {useState} from 'react';

function Header(props) {

    const [styleCss, setStyleCss] = useState({
        backgroundColor:"skyblue",
        height:"50px",
        textAlign:"center",
        display:"block",
        padding:"50px"
    });

    const changeBackground = (e) => {
        console.log(e.target.value);
        setStyleCss(
            {
                ...styleCss, backgroundColor: e.target.value
            }
        )
    }

    return (
        <div style={styleCss}>
            <span style={{display:"block"}}>Header Area</span>
            <span>{styleCss.backgroundColor}</span>
            <span>
                <button onClick={changeBackground} value={"skyblue"}>blue</button>
                <button onClick={changeBackground} value={"white"}>white</button>
            </span>
        </div>
    );
}

export default Header;