import React, {useState} from 'react';

function Example02() {

    const [count, setCount] = useState(0);

    const addCount = () => {
        setCount(count + 1);
    }

    return (
        <div>
            <p> clicked {count} times </p>
            <button onClick={addCount}> click button </button>
        </div>

    );
}

export default Example02;