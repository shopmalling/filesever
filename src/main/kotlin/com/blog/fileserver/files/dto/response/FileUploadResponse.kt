package com.blog.fileserver.files.dto.response

data class FileUploadResponse(
    val mainPhoto: String,
    val subPhotos: List<String>
)
