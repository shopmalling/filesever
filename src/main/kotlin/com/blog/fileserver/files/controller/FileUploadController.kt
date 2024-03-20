package com.blog.fileserver.files.controller

import com.blog.fileserver.files.dto.response.FileUploadResponse
import com.blog.fileserver.files.service.FileStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class FileUploadController {

    @Autowired
    lateinit var fileStorageService: FileStorageService

    @PostMapping("/{productName}")
    fun uploadProduct(
        @PathVariable("productName") productName: String,
        @RequestParam("mainPhoto") mainPhoto: MultipartFile,
        @RequestParam("subPhotos") subPhotos: List<MultipartFile>
    ): FileUploadResponse {
        val mainPhotoResponse = fileStorageService.mainUploadFile(productName, mainPhoto)
        val subPhotoResponses = subPhotos.map { fileStorageService.subUploadFile(productName, it) }
        return FileUploadResponse(mainPhotoResponse, subPhotoResponses)
    }

}
