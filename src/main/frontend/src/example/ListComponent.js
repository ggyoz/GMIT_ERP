import React from 'react';
import Example03 from './Example03';

function ListComponent({idArr}) {

    const idList = idArr.map(v => (<Example03 key={v.id} idx={v.idx} id={v.id} name={v.name}/>));

    console.log(idList);

    return (
        <table style={{'border' : '1px solid black'}}>
            <tbody>
                {idList}
            </tbody>
        </table>
    );
}

export default ListComponent;