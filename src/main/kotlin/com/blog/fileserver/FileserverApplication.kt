package com.blog.fileserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FileserverApplication

fun main(args: Array<String>) {
    runApplication<FileserverApplication>(*args)
}
