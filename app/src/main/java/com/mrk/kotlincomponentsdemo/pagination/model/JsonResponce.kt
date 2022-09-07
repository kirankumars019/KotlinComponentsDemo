package com.mrk.kotlincomponentsdemo.pagination.model

data class JsonResponce
    (
    var content: List<ContentModule>,
    var pageSize: String?,
    var totalElements: String?,
    var pageNumber: String?,
    var totalPages : String?,
)

data class ContentModule
    (
    var name:String,
    var categoryPath :String,
    var cloudinaryImagePublicId: String?,
    var links:ArrayList<Int>
)

data class LinksModule

    (
    var rel:String,
    var href:String
)
