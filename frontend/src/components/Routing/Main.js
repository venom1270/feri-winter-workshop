import React from 'react';
import { Routes, Route } from "react-router-dom";
import Measurements from '../Measurements/Measurements';
import PageNotFound from "../PageNotFound/PageNotFound";
import Products from '../Products/Products';
import Osebe from '../Osebe/Osebe';

const Main = () => {
    return (
        <Routes>
            <Route path="/" element={<Measurements />} />
            <Route path="/products" element={<Products />} />
            <Route path="/osebe" element={<Osebe />} />
            <Route path="*" element={<PageNotFound />} />
        </Routes>
    );
}

export default Main;