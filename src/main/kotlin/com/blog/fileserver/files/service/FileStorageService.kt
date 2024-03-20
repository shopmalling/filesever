package com.blog.fileserver.files.service

import org.springframework.web.multipart.MultipartFile

interface FileStorageService {
    fun mainUploadFile(productName: String, mainPhoto: MultipartFile): String
    fun subUploadFile(productName: String, subPhoto: MultipartFile): String
    fun mainDeleteFile(filePath: String)
    fun subDeleteFile(filePath: List<String>)
}