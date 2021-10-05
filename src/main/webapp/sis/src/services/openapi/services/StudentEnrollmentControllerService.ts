/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { StudentEnrollmentDTO } from '../models/StudentEnrollmentDTO';
import { request as __request } from '../core/request';

export class StudentEnrollmentControllerService {

    /**
     * @param id
     * @returns StudentEnrollmentDTO OK
     * @throws ApiError
     */
    public static async getStudentEnrollment(
        id: number,
    ): Promise<StudentEnrollmentDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/studentEnrollments/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateStudentEnrollment(
        id: number,
        requestBody: StudentEnrollmentDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/studentEnrollments/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteStudentEnrollment(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/studentEnrollments/${id}`,
        });
        return result.body;
    }

    /**
     * @returns StudentEnrollmentDTO OK
     * @throws ApiError
     */
    public static async getAllStudentEnrollments(): Promise<Array<StudentEnrollmentDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/studentEnrollments`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createStudentEnrollment(
        requestBody: StudentEnrollmentDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/studentEnrollments`,
            body: requestBody,
        });
        return result.body;
    }

}