package io.forus.me.android.domain.repository.records

import io.forus.me.android.domain.models.records.*
import io.reactivex.Observable

interface RecordsRepository {

    fun getRecordTypes(): Observable<List<RecordType>>


    fun getCategories(): Observable<List<RecordCategory>>


    fun newCategory(newRecordCategoryRequest: NewRecordCategoryRequest): Observable<Boolean>


    fun getCategory(categoryId: Long): Observable<RecordCategory>


    fun getRecordsCount(recordCategoryId: Long): Observable<Long>


    fun getRecords(recordCategoryId: Long): Observable<List<Record>>


    fun newRecord(model: NewRecordRequest) : Observable<NewRecordRequest>


    fun getRecord(recordId: Long): Observable<Record>


    fun getRecordUuid(recordId: Long): Observable<String>
}
