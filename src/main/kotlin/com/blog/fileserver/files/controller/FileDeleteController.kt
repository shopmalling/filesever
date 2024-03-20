package com.blog.fileserver.files.controller

import com.blog.fileserver.files.service.FileStorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FileDeleteController {

    @Autowired
    lateinit var fileStorageService: FileStorageService

    @DeleteMapping("/{productName}")
    fun deleteProduct(
        @PathVariable("productName") productNames: List<String>,
        @RequestParam("mainPhotos") mainPhotos: String,
        @RequestParam("subPhotos") subPhotos: List<String>
    ) {
        if (productNames.isEmpty()) {
            throw IllegalArgumentException("productNames is empty")
        }

        if (mainPhotos.isNotBlank()) {
            fileStorageService.mainDeleteFile(mainPhotos)
        }

        if (subPhotos.isNotEmpty()) {
            fileStorageService.subDeleteFile(subPhotos)
        }
    }
}