package com.example.androidassignment.api.model

data class FileInfo(
    val code: Int,
    val message: String,
    val success: Boolean,
    val data: ArrayList<FileItem>,
    val errors: String?
)

data class FileItem(
    val id: String,
    val name: String,
    val type: String,
    val section: String,
    val tags: List<TagItem>,
    val file: String,
    val version: Int,
    val status: Int,
    val comment_count: Int,
    val uploaded_at: String,
    val uploaded_by: UploadedBy,
    val file_size: Double
)

data class TagItem(
    val id: String,
    val name: String
)

data class UploadedBy(
    val id: String,
    val name: String,
    val photo: String,
    val organization_name: String
)