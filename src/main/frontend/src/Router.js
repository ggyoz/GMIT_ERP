import React from 'react';
import App from './App';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Product from "./example/Product";
import Login from "./auth/Login";
import Header from "./component/Header";
import Footer from "./component/Footer";

function Router(props) {
    return (
        <>
            <Header/>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<App/>}></Route>
                    <Route path="/product/*" element={<Product/>}></Route>
                    <Route path="/login/*" element={<Login/>}></Route>
                </Routes>
            </BrowserRouter>
            <Footer/>
        </>

    );
}


export default Router;