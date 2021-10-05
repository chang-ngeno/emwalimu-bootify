/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */
import type { FeeInvoiceDTO } from '../models/FeeInvoiceDTO';
import { request as __request } from '../core/request';

export class FeeInvoiceControllerService {

    /**
     * @param id
     * @returns FeeInvoiceDTO OK
     * @throws ApiError
     */
    public static async getFeeInvoice(
        id: number,
    ): Promise<FeeInvoiceDTO> {
        const result = await __request({
            method: 'GET',
            path: `/api/feeInvoices/${id}`,
        });
        return result.body;
    }

    /**
     * @param id
     * @param requestBody
     * @returns any OK
     * @throws ApiError
     */
    public static async updateFeeInvoice(
        id: number,
        requestBody: FeeInvoiceDTO,
    ): Promise<any> {
        const result = await __request({
            method: 'PUT',
            path: `/api/feeInvoices/${id}`,
            body: requestBody,
        });
        return result.body;
    }

    /**
     * @param id
     * @returns any OK
     * @throws ApiError
     */
    public static async deleteFeeInvoice(
        id: number,
    ): Promise<any> {
        const result = await __request({
            method: 'DELETE',
            path: `/api/feeInvoices/${id}`,
        });
        return result.body;
    }

    /**
     * @returns FeeInvoiceDTO OK
     * @throws ApiError
     */
    public static async getAllFeeInvoices(): Promise<Array<FeeInvoiceDTO>> {
        const result = await __request({
            method: 'GET',
            path: `/api/feeInvoices`,
        });
        return result.body;
    }

    /**
     * @param requestBody
     * @returns number OK
     * @throws ApiError
     */
    public static async createFeeInvoice(
        requestBody: FeeInvoiceDTO,
    ): Promise<number> {
        const result = await __request({
            method: 'POST',
            path: `/api/feeInvoices`,
            body: requestBody,
        });
        return result.body;
    }

}