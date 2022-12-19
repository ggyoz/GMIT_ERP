import React from 'react';
import PropTypes from "prop-types";

function Main({name, color}) {
    return (
        <div>
            <h1 style={{ color }}> Main Area { name }입니다. </h1>
        </div>
    );
}
// 타입설정
Main.propTypes = {
    name: PropTypes.string.isRequired,
}
// 기본값 설정
Main.defaultProps = {
    name : "이름없음"
}
export default Main;