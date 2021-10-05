/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { AcademicRegistrationDTO } from '../models/AcademicRegistrationDTO';
import { request as __request } from '../core/request';

export class AcademicRegistrationControllerService {

    /**
     * @param id
     * @returns AcademicRegistrationDTO OK
     * @throws ApiError
     */
    public static async getAcademicRegistration(
        id: number,
    ): Promise<AcademicRegistrationDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/academicRegistrations/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateAcademicRegistration(
        id: number,
        requestBody: AcademicRegistrationDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/academicRegistrations/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteAcademicRegistration(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/academicRegistrations/${id}`,
        });
        return result.body;
    }

    /**
     * @returns AcademicRegistrationDTO OK
     * @throws ApiError
     */
    public static async getAllAcademicRegistrations(): Promise<Array<AcademicRegistrationDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/academicRegistrations`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createAcademicRegistration(
        requestBody: AcademicRegistrationDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/academicRegistrations`,
            body: requestBody,
        });
        return result.body;
    }

}