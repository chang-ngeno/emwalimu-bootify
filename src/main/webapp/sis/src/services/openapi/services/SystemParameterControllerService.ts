/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { SystemParameterDTO } from '../models/SystemParameterDTO';
import { request as __request } from '../core/request';

export class SystemParameterControllerService {

    /**
     * @param id
     * @returns SystemParameterDTO OK
     * @throws ApiError
     */
    public static async getSystemParameter(
        id: number,
    ): Promise<SystemParameterDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/systemParameters/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateSystemParameter(
        id: number,
        requestBody: SystemParameterDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/systemParameters/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteSystemParameter(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/systemParameters/${id}`,
        });
        return result.body;
    }

    /**
     * @returns SystemParameterDTO OK
     * @throws ApiError
     */
    public static async getAllSystemParameters(): Promise<Array<SystemParameterDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/systemParameters`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createSystemParameter(
        requestBody: SystemParameterDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/systemParameters`,
            body: requestBody,
        });
        return result.body;
    }

}