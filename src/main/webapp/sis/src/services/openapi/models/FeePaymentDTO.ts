/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

export type FeePaymentDTO = {
    id?: number;
    txnDate: string;
    txnAmount: number;
    balance: number;
    txnMode: FeePaymentDTO.txnMode;
}

export namespace FeePaymentDTO {

    export enum txnMode {
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
