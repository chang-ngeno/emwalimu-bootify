/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { StaffDTO } from '../models/StaffDTO';
import { request as __request } from '../core/request';

export class StaffControllerService {

    /**
     * @param id
     * @returns StaffDTO OK
     * @throws ApiError
     */
    public static async getStaff(
        id: number,
    ): Promise<StaffDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/staffs/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateStaff(
        id: number,
        requestBody: StaffDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/staffs/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteStaff(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/staffs/${id}`,
        });
        return result.body;
    }

    /**
     * @returns StaffDTO OK
     * @throws ApiError
     */
    public static async getAllStaffs(): Promise<Array<StaffDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/staffs`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createStaff(
        requestBody: StaffDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/staffs`,
            body: requestBody,
        });
        return result.body;
    }

}