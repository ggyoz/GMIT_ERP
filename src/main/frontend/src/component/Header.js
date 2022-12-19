import React, {useState} from 'react';

function Header(props) {

    const [styleCss, setStyleCss] = useState({
        backgroundColor:"skyblue",
        height:"100px",
        textAlign:"center",
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
            <span style={{lineHeight:"100px"}}>Header Area</span>
            <p>
                <span>{styleCss.backgroundColor}</span>
                <span>
                    <button onClick={changeBackground} value={"skyblue"}>blue</button>
                    <button onClick={changeBackground} value={"white"}>white</button>
                </span>
            </p>
        </div>
    );
}

export default Header;