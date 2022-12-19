import React from 'react';

class Example01 extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            count : 0
        }
    }

    render() {
        return (

            <div>
                <p> clicked {this.state.count} times </p>
                <button onClick={() => this.setState({count : this.state.count + 1 })}> click button </button>
            </div>

        );
    }

}

export default Example01;