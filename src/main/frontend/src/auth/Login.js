import React, {useState} from 'react';
import "../common/Login.css";

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
        )
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        alert(`info : ${values.userid} / ${values.password}`);
    };

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