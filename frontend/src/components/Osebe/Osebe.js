import { Button, CircularProgress } from '@mui/material';
import React, { useEffect, useState, fetchData } from 'react';
import { OsebeApi } from '../../api/api';
import AddOseba from './AddOseba';
import OsebeTable from './OsebeTable';

const Products = () => {
    const [osebe, setOsebe] = useState([]);
    const [open, setOpen] = useState(false);
    const [editOpen, setEditOpen] = useState(false);
    const [editId, setEditId] = useState("");
    const [loaded, setLoaded] = useState(false);
    const osebeApi = new OsebeApi();

    const fetchData = () => {
        /*measurementsApi.getProducts()
            .then((result) => { setProducts(result.data); setLoaded(true); })
            .catch((response) => console.log(`error ${response}`));*/
        osebeApi.getOsebe()
            .then((result) => { setOsebe(result.data); setLoaded(true); console.log("OSEBE"); console.log(result)})
            .catch((response) => console.log(`error ${response}`));
    }
    useEffect(() => {
        fetchData();

    }, []);
    const handleOpen = () => {
        setOpen(true);
    }
    const handleClose = () => {
        setOpen(false);
        setEditOpen(false);
        setEditId("");
        fetchData();
    }
    return (
        <div style={{ padding: '25px' }}>
            <h2>Osebe</h2>
            <Button variant="contained" onClick={handleOpen}>New Oseba</Button>
            <br />
            <br />
            {loaded ? <OsebeTable osebe={osebe} /> : <CircularProgress />}
            <AddOseba open={open} handleClose={handleClose} />
        </div>
    );
}

export default Products;