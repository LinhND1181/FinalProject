export interface User {

    username: string;
    password: string;
    email: string;
    fullName: string;
    birthday: Date;
    gender: string;
    address: string;
    phoneNumber: string;

}

export class UserModel implements User {
    username: string;
    password: string;
    email: string;
    fullName: string;
    birthday: Date;
    gender: string;
    address: string;
    phoneNumber: string;

    constructor(username: string,
        password: string,
        email: string,
        fullName: string,
        birthday: Date,
        gender: string,
        phoneNumber: string,
        address: string) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.fullName = fullName;
            this.birthday = birthday;
            this.gender = gender;
            this.address = address;
            this.phoneNumber = phoneNumber;
    }
}
