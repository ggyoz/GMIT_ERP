import React from 'react';

function Wrapper(props) {

    const style = {
        backgroundColor : 'skyblue',
        height : "300px"
    }

    return (
        <div style={style}>
            {props.children}
        </div>
    );
}

export default Wrapper;