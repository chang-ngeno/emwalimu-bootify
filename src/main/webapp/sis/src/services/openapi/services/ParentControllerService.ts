/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { ParentDTO } from '../models/ParentDTO';
import { request as __request } from '../core/request';

export class ParentControllerService {

    /**
     * @param id
     * @returns ParentDTO OK
     * @throws ApiError
     */
    public static async getParent(
        id: number,
    ): Promise<ParentDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/parents/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateParent(
        id: number,
        requestBody: ParentDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/parents/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteParent(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/parents/${id}`,
        });
        return result.body;
    }

    /**
     * @returns ParentDTO OK
     * @throws ApiError
     */
    public static async getAllParents(): Promise<Array<ParentDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/parents`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createParent(
        requestBody: ParentDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/parents`,
            body: requestBody,
        });
        return result.body;
    }

}