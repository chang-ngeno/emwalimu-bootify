/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { FeePaymentDTO } from '../models/FeePaymentDTO';
import { request as __request } from '../core/request';

export class FeePaymentControllerService {

    /**
     * @param id
     * @returns FeePaymentDTO OK
     * @throws ApiError
     */
    public static async getFeePayment(
        id: number,
    ): Promise<FeePaymentDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/feePayments/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateFeePayment(
        id: number,
        requestBody: FeePaymentDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/feePayments/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteFeePayment(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/feePayments/${id}`,
        });
        return result.body;
    }

    /**
     * @returns FeePaymentDTO OK
     * @throws ApiError
     */
    public static async getAllFeePayments(): Promise<Array<FeePaymentDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/feePayments`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createFeePayment(
        requestBody: FeePaymentDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/feePayments`,
            body: requestBody,
        });
        return result.body;
    }

}