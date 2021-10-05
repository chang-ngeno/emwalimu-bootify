/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { FeeInvoiceDetailDTO } from '../models/FeeInvoiceDetailDTO';
import { request as __request } from '../core/request';

export class FeeInvoiceDetailControllerService {

    /**
     * @param id
     * @returns FeeInvoiceDetailDTO OK
     * @throws ApiError
     */
    public static async getFeeInvoiceDetail(
        id: number,
    ): Promise<FeeInvoiceDetailDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/feeInvoiceDetails/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateFeeInvoiceDetail(
        id: number,
        requestBody: FeeInvoiceDetailDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/feeInvoiceDetails/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteFeeInvoiceDetail(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/feeInvoiceDetails/${id}`,
        });
        return result.body;
    }

    /**
     * @returns FeeInvoiceDetailDTO OK
     * @throws ApiError
     */
    public static async getAllFeeInvoiceDetails(): Promise<Array<FeeInvoiceDetailDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/feeInvoiceDetails`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createFeeInvoiceDetail(
        requestBody: FeeInvoiceDetailDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/feeInvoiceDetails`,
            body: requestBody,
        });
        return result.body;
    }

}