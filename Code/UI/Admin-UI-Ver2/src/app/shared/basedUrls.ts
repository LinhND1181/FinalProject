const BASIC_URL = "http://localhost:8081/api/v1"
export const SERVER_NO_AUTH_URL: string = BASIC_URL + "/no-auth";
export const SERVER_ADMIN_URL: string = BASIC_URL + "/ad";
export const SERVER_MANAGER_URL: string = BASIC_URL + "/mn";
export const SERVER_EMP_URL: string = BASIC_URL + "/emp";
export const SERVER_USER_URL: string = BASIC_URL + "/u";
export const SERVER_ALL_URL: string = BASIC_URL + "/all";


export type LoginDTO = {
    username: string;
    password: string;
}

export type ErrorMessage = {
    message? : string;
}

export const headers = {
    'Authorization': 'Bearer ' + sessionStorage.getItem('accessToken')
};
