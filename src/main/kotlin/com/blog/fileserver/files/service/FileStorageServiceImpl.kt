package com.blog.fileserver.files.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Service
class FileStorageServiceImpl : FileStorageService{
    override fun mainUploadFile(productName: String, mainPhoto: MultipartFile): String {
        val directory = Paths.get("uploads/$productName/main")
        val filePath = directory.resolve(mainPhoto.originalFilename!!)

        // 디렉토리가 존재하지 않으면 생성
        if (!Files.exists(directory)) {
            Files.createDirectories(directory)
        } else {
            // 디렉토리가 존재하면 기존 파일 삭제
            Files.list(directory).forEach { Files.delete(it) }
        }


        // 파일 저장
        mainPhoto.inputStream.use { inputStream ->
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)
        }

        return filePath.toString()
    }

    override fun subUploadFile(productName: String, subPhoto: MultipartFile): String {

        val directory = Paths.get("uploads/$productName/sub")
        val filePath = directory.resolve(subPhoto.originalFilename!!)

        subPhoto.inputStream.use { inputStream ->
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)
        }

        return filePath.toString()
    }

    override fun mainDeleteFile(filePath: String) {
        filePath.let {
            Files.delete(Paths.get(it))
        }
    }
    override fun subDeleteFile(filePath: List<String>) {
        filePath.forEach {
            Files.delete(Paths.get(it))
        }
    }
}