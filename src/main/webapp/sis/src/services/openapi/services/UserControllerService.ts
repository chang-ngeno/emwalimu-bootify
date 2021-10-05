/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { UserDTO } from '../models/UserDTO';
import { request as __request } from '../core/request';

export class UserControllerService {

    /**
     * @param id
     * @returns UserDTO OK
     * @throws ApiError
     */
    public static async getUser(
        id: number,
    ): Promise<UserDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/users/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateUser(
        id: number,
        requestBody: UserDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/users/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteUser(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/users/${id}`,
        });
        return result.body;
    }

    /**
     * @returns UserDTO OK
     * @throws ApiError
     */
    public static async getAllUsers(): Promise<Array<UserDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/users`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createUser(
        requestBody: UserDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/users`,
            body: requestBody,
        });
        return result.body;
    }

}