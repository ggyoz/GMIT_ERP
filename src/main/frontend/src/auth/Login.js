import React, {useEffect, useState} from 'react';
import "../common/Login.css";
import axios from 'axios';

function Login(props) {

    const [values, setValues] = useState({
        userid : '',
        password : '',
    });

    const changeUserInfo = (e) => {
        setValues({
                ...values,
                [e.target.name]: e.target.value,
            }
        );
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        alert(`info : ${values.userid} / ${values.password}`);

        axios.get(`/api/MemberTest/${values.userid}`)
            .then(response => idCheck(response.data))
            .catch(error => console.log(error));
    };

    function idCheck(data){

        console.log(data);

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




    return (
        <div className="login_form">
            <form onSubmit={handleSubmit}>
                <div>
                    <span>
                        아이디 : <input id="userId" type="text" name="userid" value={values.userid} onChange={changeUserInfo} />
                    </span>
                    <span>
                        비밀번호 : <input id="userPw" type="password" name="password" value={values.password} onChange={changeUserInfo} />
                    </span>
                </div>
                <div>
                    <span>
                        <button type="submit" name="submit">submit</button>
                    </span>
                </div>
            </form>
        </div>
    );
}

export default Login;