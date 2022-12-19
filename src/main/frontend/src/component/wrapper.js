import React from 'react';

function Wrapper(props) {

    const style = {
        backgroundColor : 'yellow',
        height : "300px"
    }

    return (
        <div style={style}>
            {props.children}
        </div>
    );
}

export default Wrapper;