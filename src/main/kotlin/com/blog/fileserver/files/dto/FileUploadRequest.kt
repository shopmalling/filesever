package com.blog.fileserver.files.dto

import com.blog.fileserver.files.dto.response.FileUploadResponse

data class FileUploadRequest(
    val ProductName: String,
    val mainPhoto: FileUploadResponse,
    val subPhotos: List<FileUploadResponse>
)
