/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

export type UserDTO = {
    id?: number;
    firstName: string;
    lastName: string;
    secondName?: string;
    email: string;
    mobileNumber: string;
    password: string;
    avatar?: string;
    deleted: boolean;
    active: boolean;
    location: string;
    userRoles?: Array<number>;
}
