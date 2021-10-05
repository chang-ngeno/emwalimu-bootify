/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { StudentDTO } from '../models/StudentDTO';
import { request as __request } from '../core/request';

export class StudentControllerService {

    /**
     * @param id
     * @returns StudentDTO OK
     * @throws ApiError
     */
    public static async getStudent(
        id: number,
    ): Promise<StudentDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/students/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateStudent(
        id: number,
        requestBody: StudentDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/students/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteStudent(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/students/${id}`,
        });
        return result.body;
    }

    /**
     * @returns StudentDTO OK
     * @throws ApiError
     */
    public static async getAllStudents(): Promise<Array<StudentDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/students`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createStudent(
        requestBody: StudentDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/students`,
            body: requestBody,
        });
        return result.body;
    }

}