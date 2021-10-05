/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { StudentCourseEnrollmentDTO } from '../models/StudentCourseEnrollmentDTO';
import { request as __request } from '../core/request';

export class StudentCourseEnrollmentControllerService {

    /**
     * @param id
     * @returns StudentCourseEnrollmentDTO OK
     * @throws ApiError
     */
    public static async getStudentCourseEnrollment(
        id: number,
    ): Promise<StudentCourseEnrollmentDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/studentCourseEnrollments/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateStudentCourseEnrollment(
        id: number,
        requestBody: StudentCourseEnrollmentDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/studentCourseEnrollments/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteStudentCourseEnrollment(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/studentCourseEnrollments/${id}`,
        });
        return result.body;
    }

    /**
     * @returns StudentCourseEnrollmentDTO OK
     * @throws ApiError
     */
    public static async getAllStudentCourseEnrollments(): Promise<Array<StudentCourseEnrollmentDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/studentCourseEnrollments`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createStudentCourseEnrollment(
        requestBody: StudentCourseEnrollmentDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/studentCourseEnrollments`,
            body: requestBody,
        });
        return result.body;
    }

}