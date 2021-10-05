/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { AcademicResultsDTO } from '../models/AcademicResultsDTO';
import { request as __request } from '../core/request';

export class AcademicResultsControllerService {

    /**
     * @param id
     * @returns AcademicResultsDTO OK
     * @throws ApiError
     */
    public static async getAcademicResults(
        id: number,
    ): Promise<AcademicResultsDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/academicResultss/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateAcademicResults(
        id: number,
        requestBody: AcademicResultsDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/academicResultss/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteAcademicResults(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/academicResultss/${id}`,
        });
        return result.body;
    }

    /**
     * @returns AcademicResultsDTO OK
     * @throws ApiError
     */
    public static async getAllAcademicResultss(): Promise<Array<AcademicResultsDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/academicResultss`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createAcademicResults(
        requestBody: AcademicResultsDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/academicResultss`,
            body: requestBody,
        });
        return result.body;
    }

}