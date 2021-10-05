/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

export type AcademicRegistrationDTO = {
    id?: number;
    calender: AcademicRegistrationDTO.calender;
    termSemester: AcademicRegistrationDTO.termSemester;
    classGroup?: AcademicRegistrationDTO.classGroup;
}

export namespace AcademicRegistrationDTO {

    export enum calender {
        CALENDER = 'CALENDER',
        TERM_SEMESTER = 'TERM_SEMESTER',
    }

    export enum termSemester {
        CALENDER = 'CALENDER',
        TERM_SEMESTER = 'TERM_SEMESTER',
    }

    export enum classGroup {
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
