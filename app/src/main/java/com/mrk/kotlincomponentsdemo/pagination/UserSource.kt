package com.mrk.kotlincomponentsdemo.pagination

import android.content.ContentValues
import android.util.Log
import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mrk.kotlincomponentsdemo.pagination.model.ContentModule
import com.mrk.kotlincomponentsdemo.pagination.service.PaginationApi
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel

class UserSource(private val paginationApi: PaginationApi) : PagingSource<Int, ContentModule>() {
    private val TAG = "UserSource"

    companion object {
        private const val DEFAULT_PAGE_INDEX = 0
    }

    override fun getRefreshKey(state: PagingState<Int, ContentModule>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ContentModule> {
        return try {

            val page: Int = params.key ?: DEFAULT_PAGE_INDEX
            val response = paginationApi.getPagingData(page, 10, "Jewellery")
            val contents = response.body()?.content as List<ContentModule>
            Log.e(ContentValues.TAG, "responce :$contents ")
            // Log.e(TAG, "getPagingData: ${response.raw()}", )
            // Log.e(TAG, "getPagingData: ${response.body()}", )

            LoadResult.Page(
                data = contents,
                prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - 1,
                nextKey = if (contents.isEmpty()) null else page + 1
            )

        } catch (e: java.lang.Exception) {
            LoadResult.Error(e)
        }
    }


}