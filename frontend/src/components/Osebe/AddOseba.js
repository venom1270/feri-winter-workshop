import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { TextField } from '@mui/material';
import { OsebeApi } from '../../api/api';

const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
};

export default function AddOseba({ open, handleClose }) {
    const [ime, setIme] = React.useState("");
    const [priimek, setPriimek] = React.useState("");
    const [email, setEmail] = React.useState("");
    const [idKomitenta, setIdKomitenta] = React.useState("");
    const osebeApi = new OsebeApi();
    const addOseba = async () => {
        const result = await osebeApi.postOseba(ime, priimek, email, idKomitenta);
        if (result.request.status === 200) {
            handleClose();
        }
    }

    return (
        <div>

            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    <Typography id="modal-modal-title" variant="h6" component="h2">
                        Add new Oseba
                    </Typography>
                    <TextField
                        required
                        id="ime"
                        label="Ime"
                        value={ime}
                        onChange={(event) => { setIme(event.target.value) }}
                    />
                    <TextField
                        required
                        id="priimek"
                        label="Priimek"
                        value={priimek}
                        onChange={(event) => { setPriimek(event.target.value) }}
                    />
                    <TextField
                        required
                        id="email"
                        label="Email"
                        value={email}
                        onChange={(event) => { setEmail(event.target.value) }}
                    />
                    <TextField
                        required
                        id="idKomitenta"
                        label="ID komitenta"
                        value={idKomitenta}
                        onChange={(event) => { setIdKomitenta(event.target.value) }}
                    />
                    <div>
                        <Button variant="contained"
                            onClick={() => {
                                addOseba();
                                setIme("");
                                setPriimek("");
                                setEmail("");
                                setIdKomitenta("");
                            }}>
                            Add
                        </Button>
                    </div>
                </Box>
            </Modal>
        </div>
    );
}