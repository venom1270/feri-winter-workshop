import axios from 'axios';

export const ameasurementsApi = axios.create({
    baseURL: process.env.REACT_APP_BACKEND_URL,
    timeout: 5000,
    headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
    },
});

export class MeasurementsApi {
    constructor() {
        this.client = axios.create({
            baseURL: process.env.REACT_APP_BACKEND_URL,
            timeout: 5000,
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
            },
        });
    }
    //measurements
    getHistory = () => {
        return this.client.get("/history");
    }
    postMeasurement = (id, avgTemperature) => {
        return this.client.post("/product_measurement", {
            id: id,
            avgTemperature: avgTemperature
        });
    }
    //products
    getProducts = () => {
        return this.client.get("/products");
    }
    getProductById = (id) => {
        return this.client.get(`/products/${id}`);
    }
    postProduct = (name, max, min) => {
        return this.client.post("/products", {
            name: name,
            maxMeasure: max,
            minMeasure: min
        });
    }
    putProduct = (id, name, max, min) => {
        return this.client.put(`/products/${id}`, {
            name: name,
            maxMeasure: max,
            minMeasure: min
        });
    }
    deleteProduct = (id) => {
        return this.client.delete(`/products/${id}`);
    }
}




export class OsebeApi {
    constructor() {
        this.client = axios.create({
            baseURL: process.env.REACT_APP_BACKEND_URL,
            timeout: 5000,
            headers: {
                "Content-Type": "application/json",
                Accept: "application/json",
            },
        });
    }
    getOsebe = () => {
        return this.client.get("/prvi/osebe");
    }
    getProductById = (ime) => {
        return this.client.get(`/prvi/osebe/${ime}`);
    }
    postOseba = (ime, priimek, email, idKomitenta) => {
        return this.client.post("/prvi/osebe", {
            id: 0,
            ime: ime,
            priimek: priimek,
            email: email,
            idKomitenta: idKomitenta
        });
    }
}
