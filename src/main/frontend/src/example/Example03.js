import React from 'react';

function Example03({idx, id, name}) {
    return (
        <tr key={idx}>
            <td>{idx}</td>
            <td>{id}</td>
            <td>{name}</td>
        </tr>
    );
}
export default Example03;