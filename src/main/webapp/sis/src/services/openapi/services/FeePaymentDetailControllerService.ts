/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { FeePaymentDetailDTO } from '../models/FeePaymentDetailDTO';
import { request as __request } from '../core/request';

export class FeePaymentDetailControllerService {

    /**
     * @param id
     * @returns FeePaymentDetailDTO OK
     * @throws ApiError
     */
    public static async getFeePaymentDetail(
        id: number,
    ): Promise<FeePaymentDetailDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/feePaymentDetails/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateFeePaymentDetail(
        id: number,
        requestBody: FeePaymentDetailDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/feePaymentDetails/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteFeePaymentDetail(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/feePaymentDetails/${id}`,
        });
        return result.body;
    }

    /**
     * @returns FeePaymentDetailDTO OK
     * @throws ApiError
     */
    public static async getAllFeePaymentDetails(): Promise<Array<FeePaymentDetailDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/feePaymentDetails`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createFeePaymentDetail(
        requestBody: FeePaymentDetailDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/feePaymentDetails`,
            body: requestBody,
        });
        return result.body;
    }

}