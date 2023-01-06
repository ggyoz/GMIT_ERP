import React, {useEffect, useState} from 'react';
import "../common/Login.css";
import axios from 'axios';
import { TextField, Button } from "@material-ui/core";


function Login(props) {

    //#region useState...
    const [hello, setHello] = useState('');
    const [values, setValues] = useState({
        userid : '',
        password : '',
    });
    //#endregion


    const changeUserInfo = (e) => {
        setValues({
                ...values,
                [e.target.name]: e.target.value,
            }
        );
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        /*axios.get(`/api/MemberTest/${values.userid}`)
            .then(response => idCheck(response.data))
            .catch(error => console.log(error));*/

        axios.post(`/api/auth/login`, {
            "email":values.userid, "password":values.password
        }).then(function (response) {
            console.log(response.data);
        })
        .catch(function (error) {
            alert("아이디와 비밀번호를 확인해주세요.");
        });

    };

    useEffect(()=>{
        axios.get('/api/hello')
            .then(response => setHello(response.data))
            .catch(error => console.log(error))
    }, []);

    function idCheck(data){

        if (data == null){
            console.log("등록된 아이디가 없습니다.");
            return false;
        }

        if (data.password == values.password ){
            console.log(`${data.name}님 환영합니다.`);
        }else{
            console.log(`비밀번호가 잘못 입력되었습니다.`);
            return false;
        }

    }

    function checkEmail(){
        axios.get(`/api/auth/cntmember?email=${values.userid}`)
           .then(response => console.log(response.data))
           .catch(error => console.log(error));
    }

    return (
        <div className="login_form">
            <p>백엔드에서 가져온 데이터입니다. : {hello}</p>

            <form onSubmit={handleSubmit}>
                <section>
                    <span>
                        <TextField required id="outlined-required"
                                   label="email"
                                   name="userid"
                                   value={values.userid}
                                   onChange={changeUserInfo}
                        />
                    </span>
                    <span>
                        <TextField id="outlined-password-input"
                                   label="Password"
                                   type="password"
                                   value={values.password}
                                   name="password"
                                   onChange={changeUserInfo}
                        />
                    </span>
                </section>
                <section>
                    <span>
                        <Button className="LoginBtn" type="submit" variant="contained" >Login</Button>
                        <Button className="SignInBtn" type="button" variant="outlined" href="./signin" >Sign in</Button>
                    </span>
                </section>
            </form>
        </div>
    );
}

export default Login;