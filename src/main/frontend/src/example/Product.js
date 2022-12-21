import React from 'react';
import ListComponent from "./ListComponent"

function Product(props) {

    const idArr = [
        { idx : 1, id : 'aaa', name : '허진욱1'},
        { idx : 2, id : 'bbb', name : '허진욱2'},
        { idx : 3, id : 'ccc', name : '허진욱3'},
    ]

    return (
        <div className="product">
            <ListComponent idArr={idArr}/>
        </div>
    );
}

export default Product;