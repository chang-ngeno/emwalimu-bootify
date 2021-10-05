/* istanbul ignore file */
/* tslint:disable */
/* eslint-disable */

export type StudentCourseEnrollmentDTO = {
    id?: number;
    courseSubject: StudentCourseEnrollmentDTO.courseSubject;
    studentCourseSubject: number;
}

export namespace StudentCourseEnrollmentDTO {

    export enum courseSubject {
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
