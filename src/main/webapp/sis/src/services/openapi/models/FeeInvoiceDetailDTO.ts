/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

export type FeeInvoiceDetailDTO = {
    id?: number;
    voteHead: FeeInvoiceDetailDTO.voteHead;
    dateFrom: string;
    dateTo?: string;
    periodcity: FeeInvoiceDetailDTO.periodcity;
    totalAmount: number;
    govtCapitation: number;
    parentGuardianSponsor: number;
    feeInvoice: number;
}

export namespace FeeInvoiceDetailDTO {

    export enum voteHead {
        DEPARTMENT = 'DEPARTMENT',
        ROLE = 'ROLE',
        EXAM_PERIOD = 'EXAM_PERIOD',
        EXAM_TYPE = 'EXAM_TYPE',
        CLASS_GROUP = 'CLASS_GROUP',
        PRIVILEGE = 'PRIVILEGE',
        COURSE_SUBJECT = 'COURSE_SUBJECT',
        OTHER = 'OTHER',
    }

    export enum periodcity {
        DEPARTMENT = 'DEPARTMENT',
        ROLE = 'ROLE',
        EXAM_PERIOD = 'EXAM_PERIOD',
        EXAM_TYPE = 'EXAM_TYPE',
        CLASS_GROUP = 'CLASS_GROUP',
        PRIVILEGE = 'PRIVILEGE',
        COURSE_SUBJECT = 'COURSE_SUBJECT',
        OTHER = 'OTHER',
    }


}
