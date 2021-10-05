/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

export type SystemParameterDTO = {
    id?: number;
    paramType: SystemParameterDTO.paramType;
    code: string;
    name: string;
    description: string;
}

export namespace SystemParameterDTO {

    export enum paramType {
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
